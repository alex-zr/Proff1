package ua.kiev.prog;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private String name;
    private String surname;
    private int age;
    List <Questions> questions;
    public User() {
    }

    public User(String name, String surname, int age, List<Questions> questions) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}
