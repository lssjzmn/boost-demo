package com.lssjzmn.kilin.boost.boostclient.buz;

import com.lssjzmn.kilin.boost.boostclient.amqp.AmqpMessageSender;
import com.lssjzmn.kilin.boost.boostclient.bo.LoginRet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduledTask {

    @Autowired
    AmqpMessageSender messageSender;

    //cron、fixedDelay、fixedRate 三者之间不能共存！！！
    @Async("scheduledWorker")
    @Scheduled(fixedRate = 5 * 1000L, initialDelay = 8 * 1000L)
    public void scheduledWork() {
        log.info("scheduledWork at " + System.currentTimeMillis());
        LoginRet rabbitLogin = new LoginRet();
        rabbitLogin.setId(12345L);
        rabbitLogin.setStatus("200 OK");
        rabbitLogin.setInfo("this is a rabbitmq message from boost client");
        rabbitLogin.getBody().put("bofyInfo", 99999);
        messageSender.sendMessage("rabbitmq_queue_routingkey", rabbitLogin);
    }
}
