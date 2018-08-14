package com.allTasks.Hometask14;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        // создали 2 объекта
        Page page1 = new Page();
        Page page2 = new Page();

        System.out.println("Метод 1: проверку, содержится ли кнопка в списке. возвращает boolean");
        // создаем на странице кнопку
        page1.setButton(new Button("Proceed", "click"));
        page1.checkButtonExists();  // вернет true
        // еще раз для второй страницы
        page2.checkButtonExists(); // вернет false


        System.out.println("Метод 2: вернуть первый элемент field, если его нет - выбросить собственное исключение");
        // создаем на странице Поле
        page1.setField(new Field(1, "email"));

        try {
            // метод 2 - print через toString
            page1.getFirstField();
            // еще раз, тут выкинет исключение
            page2.getFirstField();
        } catch (MyExeption myExeption) {
            System.out.println(myExeption.getMessage());
        }

        System.out.println("Метод 3: вернуть последний элемент field, если его нет - выбросить собственное исключение");
        try {

            // создаем на странице  еще одно Поле
            page1.setField(new Field(2, "phoneNumber"));
            // метод 3 - print через toString
            page1.getLastField();
            // тут выкинет исключение
            page2.getLastField();
        } catch (MyExeption1 myExeption) {
            System.out.println(myExeption.getMessage());
        }


        System.out.println("Метод 4: принимает массив labels, вносит в HashSet класса и возвращает HashSet<Label>");
        // массив с labels
        Label [] labelArray = {new Label("label_1"),new Label("label_2"),new Label("label_3") };
        // метод, сетить один label
        page1.setLabel(new Label("page1_lable0"));
        // метод 4 - print внутри метода через итератор
        page1.setHashSetLabel(labelArray);



        System.out.println("Метод 5: Принимает список ArrayList<Label>, вносит его в TreeSet<Dropdowns>. Если это невозможно - выбросить собственное исключение.");
        //создаем ArrayList Label
        ArrayList <Label> labelArrayList = new ArrayList<>();
        labelArrayList.add(new Label("label_5_1"));
        labelArrayList.add(new Label("label_5_2"));
        labelArrayList.add(new Label("label_5_3"));
        // метод 5 , сетим ArrayList label (добавили compareTo в Dropdown)
        page1.setTreeSetDropdown(labelArrayList, true, "First");
        // убедимся что сравнивает корректно, и не добовляет еще раз в Set
        page1.setTreeSetDropdown(labelArrayList, true, "First");
        //еще раз
        ArrayList <Label> labelArrayList1 = new ArrayList<>();
        labelArrayList1.add(new Label("label2_5_1"));
        labelArrayList1.add(new Label("label_35_2"));
        page1.setTreeSetDropdown(labelArrayList1, false, "Second");
        // читаем в консаоли содержание Dropdown,
        Iterator <Dropdown> iterator3 = page1.getTreeSetDropdown().iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

        System.out.println("Метод 6: принимает 2 объекта label, используя переопределенный compareTo возвращает результат сравнения (-1, 0, 1).");
        page1.labelComparator(new Label("Max"),new Label("Max"));
        page1.labelComparator(new Label("Max1"),new Label("Max"));
        page1.labelComparator(new Label("Max"),new Label("Max1"));

        System.out.println("Метод 7: метод, который выведет на экран 3-й элемент Dropdowns и вернет LinkedHashSet <Dropdowns>, если его нет - выбросить собственное исключение.");
        try {
            //Метод 7: перобразуем TreeSet в LinkedHashSet
            // выводим
            page1.getDropdownLinkedHashSet(1);
            //тут выподет исключение
            page1.getDropdownLinkedHashSet(3);
        } catch (MyExeption2 myExeption) {
            System.out.println(myExeption.getMessage());
        }








    }
}
