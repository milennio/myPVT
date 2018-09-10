package ru.javacore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexesAndStuff {

  public static boolean test1(String testStr){
        Pattern p = Pattern.compile("([a-zA-Z]){0,4}");
    Matcher m = p.matcher(testStr);
    return m.matches();
  }

  public static boolean test2(String testStr){
    Pattern p = Pattern.compile("(.){4}");
    Matcher m = p.matcher(testStr);
    return m.matches();
  }

  public static boolean test3(String testStr){
    Pattern p = Pattern.compile("((([a-zA-Z_0-9\\-\\.])+)(@mail.ru))");
    Matcher m = p.matcher(testStr);
    return m.matches();
  }

  public static void main(String[] args){
    String string1 = "cat";
    System.out.println(string1);
    System.out.println(test1(string1));
    System.out.println(test2(string1));
    System.out.println();
    String string2 = "++++";
    System.out.println(string2);
    System.out.println(test1(string2));
    System.out.println(test2(string2));
    System.out.println();
    System.out.println("lina.baikova_95@mail.ru : " + test3("lina.baikova_95@mail.ru"));
    System.out.println("Lina-Baikova@mail.ru : " + test3("Lina-Baikova@mail.ru"));
    System.out.println("lina+baikova@mail.ru : " + test3("lina+baikova@mail.ru"));
  }
}
