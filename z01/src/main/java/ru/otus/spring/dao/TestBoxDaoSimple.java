package ru.otus.spring.dao;

import ru.otus.spring.domain.TestItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class TestBoxDaoSimple implements TestBoxDao {

    List<TestItem> testItemList;
    Map< String, List<TestItem> > fileMap = new LinkedHashMap<>();

    public int pullByFileName(String fileName) {
        try {
            BufferedReader reader = new BufferedReader( new FileReader( getClass().getResource( fileName ).toString().replace("file:","") ) );
            String line = null;
            testItemList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String str[] = line.split(",");
                List<String> variants = new ArrayList<>();
                for(int i = 2; i < str.length; i++) variants.add(str[i]);
                TestItem testItem = new TestItem(str[1], variants, Integer.parseInt(str[0]));
                testItemList.add(testItem);
            }
            reader.close();
        } catch (FileNotFoundException ignored) { return 1;
        } catch (IOException ignored) { return 1;
        }
        fileMap.put(fileName, testItemList);
        return 0;
    }

    public TestItem getTestItem(String fileName, int stringNumber) {
        // Каждый новый источник данных кэшируется и регистрируется в мапе
        // По понятным причинам файлы открываются не в конструкторе
        if(! fileMap.containsKey(fileName))
            if(pullByFileName( fileName ) == 1) return null;
        testItemList = fileMap.get(fileName);
        return (stringNumber < testItemList.size() ? testItemList.get(stringNumber) : null);
    }
}
