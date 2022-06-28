package app.domain;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
public class Student implements Serializable{

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

    @Override
    public String toString() {
        return name + ":" + age;
    }
}
