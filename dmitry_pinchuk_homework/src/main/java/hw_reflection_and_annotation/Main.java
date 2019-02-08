package hw_reflection_and_annotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args){

      try {
          Class<?> cls = Homework1.class;

          Homework1 obj = new Homework1();
          Method[] methods = cls.getMethods();
          for (Method method : methods) {
              if (method.isAnnotationPresent(MyAnnotationTest.class)) {
                  MyAnnotationTest ant = method.getAnnotation(MyAnnotationTest.class);
                  int x = (Integer) method.invoke(obj, ant.a(), ant.b());
                  System.out.println(x);
                  //or
                  //
                  //System.out.println(obj.testmethod(ant.a(),ant.b()));
              }
          }
      } catch (Exception e){
          e.printStackTrace();
      }
    }
}

