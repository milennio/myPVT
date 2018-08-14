package com.java.hometask15;

public class Massive {
  private int i;
  private final int n = 5;
  public double[] getMas()
  {
    double[] mas = new double[n];
    for (i = 0; i < mas.length; i++)
    {
      mas[i] = Math.round((Math.random()*20)-8);
    }
    return mas;
  }

  public double[] printRevMas(double[] mas){
    System.out.println("Прямой порядок:");
    for (i = 0; i < mas.length; i++){
      System.out.print(mas[i] + " ");
    }
    System.out.println("\nОбратный порядок:");
    for (i = mas.length-1; i >= 0; i--){
      System.out.print(mas[i] + " ");
    }
    return mas;
  }

  public double[] bubbleSort(double[] mas){
    System.out.println("Прямой порядок:");
    for (i = 0; i < mas.length; i++){
      System.out.print(mas[i] + " ");
    }
    System.out.println("\nОтсортированный глупым пузырьком порядок:");
    for (int out = mas.length-1; out >= 0; out--){
      for (i = 0; i < mas.length-1; i++){
        if (mas[i] > mas[i+1]){
          double temp = mas[i];
          mas[i] = mas[i+1];
          mas[i+1] = temp;
        }
      }
    }
    for (i = 0; i < mas.length; i++){
      System.out.print(mas[i] + " ");
    }
    return mas;
  }

  public double[] makeSomeDivs(double[] dividedMas, int div) throws SomeException {
    System.out.println("Прямой порядок:");
    for (i = 0; i < dividedMas.length; i++){
      System.out.print(dividedMas[i] + " ");
    }
    System.out.println("\nПокрошенный порядок:");
    for (i = 0; i < dividedMas.length; i++) {
      if (div != 0) {
        double temp = dividedMas[i] * i / div;
        System.out.print(Math.round(temp) + " ");
      } else throw new SomeException();
    }
    return dividedMas;
  }

  public double[] printEvens(double[] evenMas){
    System.out.println("Прямой порядок:");
    for (i = 0; i < evenMas.length; i++){
      System.out.print(evenMas[i] + " ");
    }
    System.out.println("\nЧетный порядок:");
    for (i = 0; i < evenMas.length; i++){
      if (evenMas[i] % 2 == 0)
        System.out.print(evenMas[i] + " ");
      else System.out.print("---" + " ");
    }
    return evenMas;
  }

  public static void main(String[] args)
  {
    Massive massive = new Massive();
    massive.printRevMas(massive.getMas());
    System.out.println("\n--*--*--*--*--*--*--*--*--*--*--*--");
    massive.bubbleSort(massive.getMas());
    System.out.println("\n--*--*--*--*--*--*--*--*--*--*--*--");
    try {
      massive.makeSomeDivs(massive.getMas(), 0);
      } catch (SomeException e1) {
      System.out.println(e1.asString("ERROR! Бесконечно малый делитель"));
    }
    System.out.println("\n--*--*--*--*--*--*--*--*--*--*--*--");
    massive.printEvens(massive.getMas());
  }
}

