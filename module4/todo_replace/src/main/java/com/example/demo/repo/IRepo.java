package com.example.demo.repo;

import ch.qos.logback.core.boolex.EvaluationException;
import com.example.demo.entity.Todo;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface IRepo extends JpaRepository<Todo, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update todo set display = 0 where id = ?1", nativeQuery = true)
    void updateById(Integer id);

    @Query(value = "select * from todo where display = 1", nativeQuery = true)
    List<Todo> findByDisplay();

    @Modifying
    @Transactional
    @Query(value = "insert into todo (title,content,date_begin) values(?1,?2,?3)", nativeQuery = true)
    void save(String title, String content, Date date);
}
