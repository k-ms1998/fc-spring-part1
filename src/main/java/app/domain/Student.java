package app.domain;

import lombok.Getter;

@Getter
public class Student {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
