package ra.rekkei.demo_thymeleaf.model.repository;

import ra.rekkei.demo_thymeleaf.model.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    boolean save(Student student);
}
