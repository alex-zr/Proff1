package ht9;
/*написать метод который возвращает количество искомых слов в тексте
 */

import java.util.Arrays;

public class StrEx {
    public static void main(String[] args) {
        int result = countWords("Mother:cleaned,window", "Mother");
        System.out.println(result);
    }

    public static int countWords (String str, String word) {
        String[] words = str.split("[ ,.;:!?]+");
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == (word)) {
                result++;
            }
        }
        return result;
    }
}
