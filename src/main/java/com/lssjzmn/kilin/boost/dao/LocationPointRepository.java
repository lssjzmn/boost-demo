package com.lssjzmn.kilin.boost.dao;

import com.lssjzmn.kilin.boost.entity.RobotLocationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationPointRepository extends JpaRepository<RobotLocationPoint, Integer> {

    Iterable<RobotLocationPoint> findByIdGreaterThan(Integer id);

    Iterable<RobotLocationPoint> findByTimeGreaterThan(Long time);
}
