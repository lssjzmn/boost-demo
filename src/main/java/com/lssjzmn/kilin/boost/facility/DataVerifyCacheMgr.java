package com.lssjzmn.kilin.boost.facility;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.lssjzmn.kilin.boost.bo.RetCode;
import com.lssjzmn.kilin.boost.bo.dataverify.VerifyResult;
import com.lssjzmn.kilin.boost.bo.dataverify.VerifyTarget;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;

@Component
public class DataVerifyCacheMgr {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ListeningExecutorService listeningService
            = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

    @Autowired
    DataVerifyCache dataVerifyCache;

    /**
     * 从缓存获取数据
     */
    public VerifyResult getCache(VerifyTarget target) {
        return dataVerifyCache.getCache(target);
    }

    /**
     * 从缓存获取全部数据
     */
    public ConcurrentMap<VerifyTarget, VerifyResult> getAll() {
        return dataVerifyCache.getAll();
    }

    public Collection<VerifyResult> getAllResults() {
        return getAll().values();
    }

    /**
     * 清除缓存数据，缓存清除后，数据会重新调用load方法获取
     */
    public void refresh(VerifyTarget target) {
        dataVerifyCache.refresh(target);
    }

    /**
     * 主动设置缓存数据
     */
    public void put(VerifyTarget target, VerifyResult result) {
        dataVerifyCache.put(target, result);
    }

    public void add(VerifyTarget verifyTarget) {
        DataVerifyWorker verifyWorker = new DataVerifyWorker();
        verifyWorker.setVerifyTarget(verifyTarget);
        put(verifyTarget, verifyWorker.doVerify());
    }

    /**
     * 使用轮询方式更新缓存
     * <p>
     * 主要解决问题：
     * <p>
     * CacheBuilder.refreshAfterWrite(long, TimeUnit)：可以为缓存增加自动定时刷新功能。
     * 和expireAfterWrite相反，refreshAfterWrite通过定时刷新可以让缓存项保持可用，但请注意：
     * 缓存项只有在被检索时才会真正刷新，即只有刷新间隔时间到了你再去get(key)
     * 才会重新去执行Loading否则就算刷新间隔时间到了也不会执行loading操作。
     * 因此，如果你在缓存上同时声明expireAfterWrite和refreshAfterWrite，
     * 缓存并不会因为刷新盲目地定时重置，如果缓存项没有被检索，那刷新就不会真的发生，
     * 缓存项在过期时间后也变得可以回收。
     * 还有一点比较重要的是refreshAfterWrite和expireAfterWrite两个方法设置以后，
     * 重新get会引起loading操作都是同步串行的。这其实可能会有一个隐患，
     * 当某一个时间点刚好有大量检索过来而且都有刷新或者回收的话，是会产生大量的请求同步调用loading方法，
     * 这些请求占用线程资源的时间明显变长。如正常请求也就20ms，
     * 当刷新以后加上同步请求loading这个功能接口可能响应时间远远大于20ms。
     * 为了预防这种井喷现象，可以不设置CacheBuilder.refreshAfterWrite(long, TimeUnit)，
     * 改用LoadingCache.refresh(K)因为它是异步执行的，不会影响正在读的请求，
     * 同时使用ScheduledExecutorService可以帮助你很好地实现这样的定时调度
     * ，配上cache.asMap().keySet()返回当前所有已加载键，这样所有的key定时刷新就有了。
     */

    @PostConstruct
    public void refreshJob() {
        Timer refreshTimer = new Timer("refreshVerifyDataCacheTimer");
        refreshTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refreshJobFutureTask();
            }
        }, 5000, 5000);
    }

    private void refreshJobFutureTask() {
        Futures.addCallback(
                listeningService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Set<VerifyTarget> keys = getAll().keySet();
                        for (VerifyTarget key : keys) {
                            refresh(key);
                        }
                        //logger.info("refreshJobFutureTask called.");
                        return RetCode.SUCCESS;
                    }
                }),
                new FutureCallback<String>() {
                    @Override
                    public void onSuccess(@Nullable String s) {
                        //logger.info("FutureCallback onSuccess ret:" + s);
                        //ConcurrentMap<VerifyTarget, VerifyResult> map = getAll();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        logger.error("onFailure ret:" + throwable.getMessage());
                    }
                },
                listeningService);
    }
}
