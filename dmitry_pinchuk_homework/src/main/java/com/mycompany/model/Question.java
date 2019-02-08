package com.mycompany.model;

public class Question {

    private String body;

    private boolean answer;

    public Question() {
    }

    public Question(String body, boolean answer) {
        this.body = body;
        this.answer = answer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
