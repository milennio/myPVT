package com.allTasks.Hometask14;

public class MyExeption2 extends MyExeption {
    private  String details;
//    public MyExeption2(String details) {
//        super(details);
//        this.details = details;
//    }
    public MyExeption2() {
    }

    @Override
    public String getMessage() {
        return "У тебя исключение MyExeption2, ты обложался :)";
    }

}
