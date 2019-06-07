package com.lssjzmn.kilin.boost.dao;

import com.lssjzmn.kilin.boost.entity.DataEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends PagingAndSortingRepository<DataEntity, Integer> {

    Iterable<DataEntity> findByContentEquals(String content);

    Iterable<DataEntity> findByContentContains(String content);

    Iterable<DataEntity> findByContentIsNot(String content);

    @javax.annotation.Nullable
    DataEntity findTopByContentEndsWith(String content);

    Integer countByContent(String content);
}
