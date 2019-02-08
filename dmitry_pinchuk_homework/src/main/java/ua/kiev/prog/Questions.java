package ua.kiev.prog;

import java.util.concurrent.atomic.AtomicInteger;

public class Questions {

    private String string;
    private AtomicInteger answer;

    public Questions(String string, AtomicInteger answer) {
        this.string = string;
        this.answer = answer;
    }

    public Questions() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public AtomicInteger getAnswer() {
        return answer;
    }

    public void setAnswer(AtomicInteger answer) {
        this.answer = answer;
    }
}
