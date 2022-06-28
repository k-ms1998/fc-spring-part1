package app.repository;


import app.domain.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private final Map<String, Student> storage = new HashMap<>();

    @Cacheable(value = "getStudent")
    public Student getStudent(String name) {
        System.out.println("[repository] Bottleneck");
        return storage.get(name);
    }

    public Student enroll(String name, Integer age) {
        Student student = new Student(name, age);
        storage.put(name, student);

        return student;
    }
}
