package ht9;
/*написать метод который ищет подстроку в строке и находит её первое вхождение с конца(последнее)
 */
//ascii
public class Task3 {
    public static void main(String[] args) {
//        for (int i = 0; i < 200; i++) {
//            System.out.println((char) i);
//        }

        String words = "Mom is Mom is Mom gh";
        System.out.println(findIndex(words, "Mom"));

    }

    public static int findIndex(String text, String word) {
        int index = 0;
        int i = 0;
        //return text.indexOf(word, 0);
        while ((index = text.indexOf(word, i++)) >= 0) {
            //index =
        }
        return index;
    }

}
