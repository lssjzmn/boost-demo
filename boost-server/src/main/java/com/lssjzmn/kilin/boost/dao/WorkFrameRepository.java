package com.lssjzmn.kilin.boost.dao;

import com.lssjzmn.kilin.boost.entity.WorkAxesFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkFrameRepository extends JpaRepository<WorkAxesFrame, Integer> {

    Iterable<WorkAxesFrame> findByNameEquals(String name);

    Iterable<WorkAxesFrame> findByNameContains(String name);

    Iterable<WorkAxesFrame> findByNameIsNot(String name);

}
