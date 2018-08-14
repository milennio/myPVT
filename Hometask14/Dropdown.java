package com.allTasks.Hometask14;

import com.allTasks.ClassWork.Task14.Task14_person;

import java.util.List;

public class Dropdown implements Comparable {

    private List<String> options;
    private boolean isSelected;
    private String name;

    public Dropdown(List<String> options, boolean isSelected, String name) {
        this.options = options;
        this.isSelected = isSelected;
        this.name = name;
    }

    @Override
    public int compareTo(Object obj)
    {
        Dropdown objectToCompare = (Dropdown) obj;
        int result = name.compareTo(objectToCompare.name);
        if (result != 0){
            return result;
        }
        result = (isSelected == objectToCompare.isSelected) ? 0 : -1;
        if (result != 0) {
            return result;
        }

        for (int i = 0; i < options.size(); i++){
            result = options.get(i).compareTo(objectToCompare.options.get(i));
            if (result != 0){
                return result;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Dropdown{" +
                "options=" + options +
                ", isSelected=" + isSelected +
                ", name='" + name + '\'' +
                '}';
    }
}
