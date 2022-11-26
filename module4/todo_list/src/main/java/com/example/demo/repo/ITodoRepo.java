package com.example.demo.repo;

import com.example.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public interface ITodoRepo extends JpaRepository<Todo, Integer> {

    @Modifying// đánh dấu query thay đổi cấu trúc dữ liệu của database
    @Transactional // Transaction để rollback nếu cần
    @Query("update Todo t set t.display = 0 where t.id = :id")
//    @Query(value = "update todo set `view` = 0 where id = :id", nativeQuery = true)
    void updateById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into todo (title,content,date_begin) values (?1,?2,?3)", nativeQuery = true)
    void save(String title, String content, Date date);

    @Query(value = "select * from todo where display = 1", nativeQuery = true)
    List<Todo> findByDisplayEquals();

}
