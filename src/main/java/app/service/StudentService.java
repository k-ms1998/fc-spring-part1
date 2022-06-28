package app.service;

import app.domain.Student;
import app.repository.StudentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Getter
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void printStudent(String name) {
        Student student = studentRepository.getStudent(name);

        System.out.println("student = " + student);
    }

    @PostConstruct
    public void init() {
        studentRepository.enroll("jack", 20);
        studentRepository.enroll("fred", 25);
        studentRepository.enroll("andreas", 30);
    }
}
