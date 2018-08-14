package com.allTasks.Hometask14;

public class MyExeption1 extends MyExeption {
    private  String details;
//    public MyExeption1(String details) {
//        super(details);
//        this.details = details;
//    }
    public MyExeption1() {
;
    }

    @Override
    public String getMessage() {
        return "MyExeption1: Ты тормоз? У тебя опять исключение :)";
    }
}
