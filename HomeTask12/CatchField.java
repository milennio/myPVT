import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CatchField {
    public static void main(String[] args) throws MyException {

        Scanner sc = new Scanner(System.in);
        int[] mas = new int[Massives.getN(3)];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < mas.length; i++)
        {
            mas[i] = sc.nextInt();
        }
        System.out.println("Массив состоит из следующих элементов:");
//        Massives.getMassive(mas);
//        if (mas.length > 4) {
//            System.out.println("\nРазделить элемент массива под индексом = ");
//            int index = sc.nextInt();
//            System.out.println("\nРазделить каждый элемент массива на число = ");
//            int div = sc.nextInt();
//            System.out.println("Деление элемента массива с индексом " + index + " на число " + div + ":");
//            Massives.masDiv(index, div, mas);
//            Massives.getMassive(mas);
//        } else { Massives.method3(mas); }
        Massives.tryTry(mas);


    }
}
