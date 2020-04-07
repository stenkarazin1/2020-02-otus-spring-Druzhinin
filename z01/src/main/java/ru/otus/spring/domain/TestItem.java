package ru.otus.spring.domain;

import java.util.List;

public class TestItem {                     // Элемент теста

    protected final String question;        // Вопрос
    protected final List<String> variants;  // Варианты ответа
    protected final int rightAnswer;        // Номер правильного ответа

    public TestItem(String question, List<String> variants, int rightAnswer) {
        this.question = question;
        this.variants = variants;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getVariants() { return variants; }

    public int getRightAnswer() { return rightAnswer; }
}
