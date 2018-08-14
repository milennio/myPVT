package com.allTasks.Hometask14;

public class Field {
    private int id;
    private String value;

    public Field(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
public String toString (){
        return  "ID поля: " + id + " Value поля: " + value;
    }

}
