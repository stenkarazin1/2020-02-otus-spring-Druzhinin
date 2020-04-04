package ru.otus.spring.logic;

import ru.otus.spring.domain.AnsweredTestItem;
import ru.otus.spring.domain.TestItem;

import java.io.IOException;

public interface TestBox {
    TestItem getTestItem()  ;
    int getTestItemCount() ;
    void setAnswer(TestItem testItem, int response);
    int getAnsweredTestItemCount();
    AnsweredTestItem getAnsweredTestItem(int i);
    int getRightAnsweredTestItemCount();
}
