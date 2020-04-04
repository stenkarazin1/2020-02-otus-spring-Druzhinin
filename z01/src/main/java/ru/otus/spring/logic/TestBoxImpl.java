package ru.otus.spring.logic;

import ru.otus.spring.dao.TestBoxDao;
import ru.otus.spring.domain.TestItem;
import ru.otus.spring.domain.AnsweredTestItem;

import java.util.LinkedList;
import java.util.List;

public class TestBoxImpl implements TestBox {

    private final TestBoxDao dao;
    // Список заданных вопросов и список вопросов, на которые ответили - не одно и то же. Так я решил
    private List<TestItem> testItemList;
    private List<AnsweredTestItem> answeredTestItemList;
    private int[] testItemNumbers = {4, 2, 0, 1, 3, 6, 8, 5, 7};
    private int i = 0;

    public TestBoxImpl(TestBoxDao dao) {
        this.dao = dao;
        testItemList = new LinkedList<TestItem>();
        answeredTestItemList= new LinkedList<AnsweredTestItem>();
    }

    public TestItem getTestItem() {
        // Потому что набор вопросов должен определяться бизнес-логикой
        // Конечно, массив псевдослучайных чисел - убогий способ тасовать список вопросов
        TestItem testItem = dao.getTestItem("/test.csv",testItemNumbers[(i++)]);
        if (testItem != null) testItemList.add(testItem);
        return testItem;
    }

    public int getTestItemCount() {
        return testItemList.size();
    }

    public void setAnswer(TestItem testItem, int response) {
        AnsweredTestItem answeredTestItem = new AnsweredTestItem(testItem, response);
        answeredTestItemList.add(answeredTestItem);
    }

    public int getAnsweredTestItemCount() {
        return answeredTestItemList.size();
    }

    public AnsweredTestItem getAnsweredTestItem(int i) {
        return answeredTestItemList.get(i);
    }

    public int getRightAnsweredTestItemCount() {
        int count = 0;
        for (AnsweredTestItem answeredTestItem : answeredTestItemList) {
            if (answeredTestItem.getRightAnswer() == answeredTestItem.getUserAnswer()) count++;
        }
        return count;
    }
}
