package codegym.vn.springboot.repository;

import codegym.vn.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
}
