package hw_reflection_and_annotation;

public class Homework1 {

    @MyAnnotationTest(a=13,b=17)
    public int testmethod(int a,int b){
        return a+b;
    }
}
