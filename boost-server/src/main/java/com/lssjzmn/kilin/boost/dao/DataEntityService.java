package com.lssjzmn.kilin.boost.dao;

import com.lssjzmn.kilin.boost.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@CacheConfig(cacheNames = "dataEntityCaches")
public class DataEntityService {

    @Autowired
    private DataRepository dataRepository;

    @CachePut(key = "#dataEntity.getId()")
    public DataEntity save(DataEntity dataEntity) {
        return dataRepository.save(dataEntity);
    }

    @CachePut
    public List<DataEntity> save(List<DataEntity> dataEntitys) {
        return (List<DataEntity>) dataRepository.save(dataEntitys);
    }

    @CacheEvict
    public void delete(Integer id) {
        dataRepository.delete(id);
    }

    @CacheEvict
    public void delete(DataEntity dataEntity) {
        dataRepository.delete(dataEntity);
    }

    @Cacheable(value = "dataEntityCaches")
    public DataEntity getOne(Integer id) {
        return dataRepository.findOne(id);
    }

    @Cacheable(value = "dataEntityCaches")
    public Iterable<DataEntity> getAllCache() {
        return dataRepository.findAll();
    }

    public Iterable<DataEntity> getAll() {
        return dataRepository.findAll();
    }

    public Iterable<DataEntity> getAllByPaging(Pageable pageable) {
        return dataRepository.findAll(pageable);
    }

    @Cacheable
    public Iterable<DataEntity> getContentEquals(String content) {
        return dataRepository.findByContentEquals(content);
    }


    @Cacheable
    public Iterable<DataEntity> getContentCacheContains(String content) {
        return dataRepository.findByContentContains(content);
    }

    public Iterable<DataEntity> getContentContains(String content) {
        return dataRepository.findByContentContains(content);
    }

    @Cacheable
    public Iterable<DataEntity> getContentNot(String content) {
        return dataRepository.findByContentIsNot(content);
    }

    @Cacheable
    public DataEntity getTopContentEndsWith(String content) {
        return dataRepository.findTopByContentEndsWith(content);
    }

    public void exists(Integer id) {
        dataRepository.exists(id);
    }

    public long count() {
        return dataRepository.count();
    }

}
