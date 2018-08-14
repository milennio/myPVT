package com.allTasks.Hometask14;

import com.allTasks.ClassWork.Task14.Task14_person;

import java.util.*;

public class Page {
    private ArrayList<Button> arrayListButton;
    private LinkedList<Field> linkedListField;
    private HashSet<Label> hashSetLabel;
    private TreeSet<Dropdown> treeSetDropdown;
    private float id;
    private String title;

    public Page() {
        this.arrayListButton = new ArrayList<>();
        this.linkedListField = new LinkedList<>();
        this.hashSetLabel = new HashSet<>();
        this.treeSetDropdown = new TreeSet<>();
        this.id = 0;
        this.title = "";
    }


    //1. проверку, содержится ли кнопка в списке. возвращает boolean
    public  boolean checkButtonExists (){
        boolean buttonExists =  (!arrayListButton.isEmpty());
        System.out.println("Есть на странице кнопка? - " + buttonExists);
        return buttonExists;
    }
    //2. вернуть первый элемент field, если его нет - выбросить собственное исключение
    public Field getFirstField ()  throws MyExeption {
        if (this.linkedListField.size() == 0){
            throw new MyExeption();
        }
        else{
            System.out.println(linkedListField.getFirst());
            return linkedListField.getFirst();
        }
    }
    //3. вернуть последний элемент field, если его нет - выбросить собственное исключение
    public Field getLastField ()  throws MyExeption1 {
        if (this.linkedListField.size() == 0){
            throw new MyExeption1();
        }
        else{
            System.out.println(linkedListField.getLast());
            return linkedListField.getLast();
        }
    }

    //4. принимает массив labels, вносит в HashSet класса и возвращает HashSet<Label>
    public HashSet<Label> setHashSetLabel (Label [] labels){
        this.hashSetLabel.addAll(Arrays.asList(labels));
        // итератор для вывода на консоль (через toString())
        Iterator <Label> iterator = this.hashSetLabel.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return this.hashSetLabel;
    }
    // 5. Принимает список ArrayList<Label>, вносит его в TreeSet<Dropdowns>. Если это невозможно - выбросить собственное исключение.

    public TreeSet<Dropdown> setTreeSetDropdown (ArrayList<Label> labels, boolean isSelected, String name){
        ArrayList <String> lablesTostring = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++ ){
            lablesTostring.add(labels.get(i).asString());
        }
        this.treeSetDropdown.add(new Dropdown(lablesTostring, isSelected, name));
        return  this.treeSetDropdown;
    }

    // 6 принимает 2 объекта label, используя переопределенный compareTo возвращает результат сравнения (-1, 0, 1).
    public int labelComparator (Label label_1, Label label_2){
        System.out.println(label_1.compareTo(label_2));
        return label_1.compareTo(label_2);
    }

    //7. метод, который выведет на экран 3-й элемент Dropdowns и вернет LinkedHashSet <Dropdowns>, если его нет - выбросить собственное исключение.
    public LinkedHashSet <Dropdown> getDropdownLinkedHashSet (int number)throws MyExeption2{
        if (number > treeSetDropdown.size()){
            throw new MyExeption2();
        }
        LinkedHashSet<Dropdown> linkedHashSet = new LinkedHashSet<>(treeSetDropdown);
        int i = 0;
        for (Dropdown d : linkedHashSet) {
            if (i == number-1) {
                System.out.println(d);
                break;
            }
            i++;
        }
        return linkedHashSet;
    }




    // сеттеры для заполнения по 1 наименованию
    public void setButton(Button button) {
        this.arrayListButton.add(button);
    }

    public void setField(Field field) {
        this.linkedListField.add(field);
    }

    public void setLabel(Label label) {
        this.hashSetLabel.add(label);
    }

    public void setDropdown(Dropdown dropdown) {
        this.treeSetDropdown.add(dropdown);
    }
    public void setId ( float id){
        this.id = id;
    }

    public void setTitle (String title){
        this.title = title;
    }


    public TreeSet<Dropdown> getTreeSetDropdown() {
        return treeSetDropdown;
    }
}