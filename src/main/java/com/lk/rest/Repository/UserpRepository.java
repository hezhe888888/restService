package com.lk.rest.Repository;



import com.lk.rest.Model.Userp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserpRepository extends JpaRepository<Userp, Integer> {

    Userp findById(int id);

    List<Userp> findByName(String name);

    List<Userp> findByAge(int age);

    @Override
    @Transactional
    void deleteById(Integer integer);

    @Query(value = "select * from userp where created_at between " +
            "cast(:beginTime AS timestamp) and cast(:endTime AS timestamp)", nativeQuery = true)
    List<Userp> findUserByPeriod(@Param("beginTime") String beginTime, @Param("endTime") String endTime);


}
