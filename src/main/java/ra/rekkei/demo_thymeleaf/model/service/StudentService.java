package ra.rekkei.demo_thymeleaf.model.service;

import ra.rekkei.demo_thymeleaf.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean save(Student student);
}
