package com.todo.repository;

import com.todo.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface IActionRepository extends JpaRepository<Action, Long> {

    @Modifying
    @Query(value = "insert into action (title,content,time_finish) values (?1, ?2, ?3)", nativeQuery = true)
    void save(String title, String content,Timestamp time);

    @Query(value = "select * from action where DATEDIFF(time_begin, now()) < 1", nativeQuery = true)
    List<Action> findAll();

    List<Action> findAllByTimeBeginAfterAndStatusIsContaining(Timestamp localDateTime, String status);

    List<Action> findAllByTimeBeginBeforeAndStatusIsContaining(Timestamp localDateTime, String status);

}
