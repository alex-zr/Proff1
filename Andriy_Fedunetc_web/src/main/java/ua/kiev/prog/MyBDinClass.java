package ua.kiev.prog;

import javax.servlet.ServletException;
import java.util.concurrent.ConcurrentHashMap;

public class MyBDinClass {

    public static volatile ConcurrentHashMap<String, Integer> colorMap;
    public static volatile ConcurrentHashMap<String, Integer> animalMap;


    public static synchronized void init() {
        if(colorMap == null){
            colorMap = new ConcurrentHashMap<>();

        }
        if(animalMap == null){
            animalMap = new ConcurrentHashMap<>();
            animalMap.put("dog", 4);
            animalMap.put("cat", 5);
            animalMap.put("yaguar", 2);
        }


    }
}
