package com.lssjzmn.kilin.boost.dao;

import com.lssjzmn.kilin.boost.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPageRepository extends JpaRepository<DataEntity, Integer> {
}
