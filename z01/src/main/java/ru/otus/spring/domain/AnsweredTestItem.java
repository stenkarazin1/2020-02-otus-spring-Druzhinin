package ru.otus.spring.domain;

public class AnsweredTestItem {

    private final TestItem testItem;
    private final int userAnswer;       // Номер варианта ответа, введенный пользователем

    public AnsweredTestItem(TestItem testItem, int userAnswer) {
        this.testItem = testItem;
        this.userAnswer = userAnswer;
    }

    public String getQuestion() {
        return this.testItem.getQuestion();
    }

    public int getRightAnswer() {
        return this.testItem.getRightAnswer();
    }

    public int getUserAnswer() {
            return this.userAnswer;
        }

    public String getVariant(int i) { return this.testItem.variants.get( i - 1 ); }
}