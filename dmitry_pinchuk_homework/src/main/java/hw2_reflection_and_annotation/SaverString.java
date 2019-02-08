package hw2_reflection_and_annotation;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class SaverString {
    public static void main(String[]args){
        TextContainer obj = new TextContainer();
        Class<?> cls = obj.getClass();


      try {
          Field field = cls.getDeclaredField("s");
          if (cls.isAnnotationPresent(SaveTo.class)) {
              SaveTo sa = cls.getAnnotation(SaveTo.class);
              String z = sa.path();
                  field.setAccessible(true);
                  String text = (String)field.get(obj);
              Method[] methods = cls.getDeclaredMethods();
              for (Method method : methods) {
                  if (method.isAnnotationPresent(Saver.class)) {
                      method.invoke(obj,text, z);
                      break;
                  }
              }
          }
          }catch(Exception e){
              e.printStackTrace();

      }
              File file = new File ("c:\\act\\asd.txt");
              StringBuilder sb = new StringBuilder();
          try(Scanner sc = new Scanner(file)){
            for(;sc.hasNextLine();){
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
            System.out.println(sb.toString());
          } catch (Exception e){
          e.printStackTrace();
      }
}
}
