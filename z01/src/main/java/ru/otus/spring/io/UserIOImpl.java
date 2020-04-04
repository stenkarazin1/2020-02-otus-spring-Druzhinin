package ru.otus.spring.io;

import ru.otus.spring.domain.AnsweredTestItem;
import ru.otus.spring.domain.TestItem;
import ru.otus.spring.logic.TestBox;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UserIOImpl implements UserIO {

    private final ru.otus.spring.logic.TestBox testBox;

    public UserIOImpl(TestBox box) {
        this.testBox = box;
    }

    public void start()  {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Введите ФИО:");
        String FIO = in.nextLine();
        // Яйцо пасхальное обыкновенное :-)
        FIO = (FIO.equals("") ? "Христо Стоичков" : FIO);
        TestItem testItem;
        while( ( testItem = testBox.getTestItem() ) != null ) {
            System.out.println("\n----------");
            System.out.println(testItem.getQuestion()); // + "\n   " + testItem.getRightAnswer() + "\n   " + testItem.getRightAnswer());
            List<String> variants = testItem.getVariants();
            for (int i = 0; i < variants.size(); i++) System.out.printf("   %2d) %s\n", (i + 1), variants.get(i));
            System.out.println("Введите номер, соответствующий выбранному Вами ответу:");
            int response = in.nextInt();
            testBox.setAnswer(testItem, response);
        }
        System.out.println( "\n==========\nТестуемый: " + FIO );
        System.out.println( "Результат: Верно " + testBox.getRightAnsweredTestItemCount() + " из " + testBox.getTestItemCount());
        /* // Можно раскомментировать
        for( int i = 0; i < testBox.getAnsweredTestItemCount(); i++ ) {
            AnsweredTestItem answeredTestItem = testBox.getAnsweredTestItem(i);
            System.out.println("\n----------\n" + answeredTestItem.getQuestion());
            System.out.println("   Вы ответили:      " + answeredTestItem.getVariant(answeredTestItem.getUserAnswer()));
            System.out.println("   Правильный ответ: " + answeredTestItem.getVariant(answeredTestItem.getRightAnswer()));
        }
        */

        out.flush();
    }
}
