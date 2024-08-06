package ra.rekkei.demo_thymeleaf.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ra.rekkei.demo_thymeleaf.model.entity.Student;
import ra.rekkei.demo_thymeleaf.model.repository.StudentRepository;
import ra.rekkei.demo_thymeleaf.model.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }
}
