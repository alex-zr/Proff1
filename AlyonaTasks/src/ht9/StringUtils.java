package ht9;

public class StringUtils {
    public static void main(String[] args) {
        String str = "Mother cleaned window";
        //String substr = "as";
        //findString(str, "as");
        String result = removeMiddle(str);
        System.out.println(result);
    }


    public static int findString(String task, String substr) {
        return 0;
    }

    public static String removeMiddle(String str) {
        if (str.length()==0) {
            return str;
        }
        String firstPart = str.substring(0, str.length()/2);
        String secondPart = str.substring((str.length()/2)+1);
        String finalResult = firstPart + secondPart;
        return finalResult;
    }
}
