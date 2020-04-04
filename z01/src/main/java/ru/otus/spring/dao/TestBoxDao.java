package ru.otus.spring.dao;

import ru.otus.spring.domain.TestItem;

public interface TestBoxDao {
    int pullByFileName(String fileName);
    TestItem getTestItem(String name, int stringNumber);
}
