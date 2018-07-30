public class Massives {


    public static int getN (int n) {

        if (n < 0) {
            try {
            throw new MyException();
            } catch (MyException e1) {
                System.out.println("Ошибка: " + e1.getMessage("Отрицательное число!"));
            } finally {
                System.out.println("Элемент finally выполнен");
            }
        }
        return n;
    }


    public static void getMassive(int[] getMassive) {
        if (getMassive.length == 0) {
            try {
                throw new MyException();
            } catch (MyException e2) {
                System.out.println("Ошибка: " + e2.getMessage("Массив пуст!"));
            }
        }
        for (int i = 0; i < getMassive.length; i++)
        {
            System.out.print(getMassive[i] + " ");
        }
    }

    public static void masDiv(int index, int div, int[] masDiv){

        try {
            masDiv[index] = masDiv[index]/div;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void tryTry(int[] massive){
        for (int i = 0; i < massive.length; i++)
        {
            if (massive.length <= 0)
            {
                try {

                    try{
                        if (massive.length == 0)
                            throw new MyException();

                    } catch (MyException e1) {
                        System.out.println(e1.getMessage("length = 0"));
                    } throw new MyException();
                } catch (MyException e2) {
                    System.out.println(e2.getMessage("length < 0"));
                }
            }
        }
    }

    public static void method3(int[] massive) throws MyException {
        try
        {
            throw new MyException();
        }
        catch(MyException e)
        {
            if (true)
                throw new MyException();
        }
        finally
        {
            System.out.println("inside finally");
        }
        System.out.println("after finally");
    }
}

