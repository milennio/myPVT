public class MyException extends Exception {
    public String detail;

    public MyException()
    {

    }

    @Override
        public String toString()
            {
                return "Ошибка: " + detail;
            }

    @Override
    public String getMessage() {
        return detail;
    }

    public String getMessage(String s) {
        return s;
    }
}
