package com.allTasks.Hometask14;

public class MyExeption extends Exception {
    private  String details;
//    public MyExeption(String details) {
//        this.details = details;
//
//    }
        public MyExeption() {

    }

    @Override
    public String getMessage() {
        return "MyExeption: У тебя исключение, ты обложался :)" ;
    }
}
