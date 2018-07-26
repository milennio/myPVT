import java.lang.StringBuffer;
import java.lang.StringBuilder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class HomeTask11 {
    public static int k = 5;
    public static void main(String[] args)
    {
        StringBuffer str1 = new StringBuffer("Котики-наркотики лежат на животике и кушают траву");
        str1.insert(k, "DRUGZ");
        System.out.println(str1);
        System.out.println();

        String string3 = "Мыши плакали, кололись, но продолжали жрать кактус.";
        int n = 0;
        if (n == 0)
        {
            System.out.println(string3.replace('л','#'));
        }
        if (n == 1)
        {
            StringBuilder string = new StringBuilder(string3);
            System.out.println(string.insert(k, 'л'));
        }
        System.out.println();

        String string4 = "  ---sUEbcJN 789e0dc00///*+ + ";
        String regexe = "\\W";
        String replacement = "";
        Pattern pattern = Pattern.compile(regexe);
        Matcher matcher = pattern.matcher(string4);
        System.out.println(matcher.replaceAll(replacement));
        System.out.println();

        String string5 = "Котики (наркотики) лежат на животике";
        System.out.println(string5.replaceAll("\\([^)]+\\)", ""));
        System.out.println();

        String string6 = "Коты котам по утрам по ногам ходят не спеша";
        System.out.println(string6);
        String regexe2 = "по";
        Pattern pattern2 = Pattern.compile(regexe2);
        Matcher matcher2 = pattern2.matcher(string6);
        int count = 0;
        while (matcher2.find()) count++;
        System.out.println("matcher.find() found " + count + " regexe(s)");
        System.out.println();


    }

}
