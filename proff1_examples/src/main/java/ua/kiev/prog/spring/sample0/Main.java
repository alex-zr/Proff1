package ua.kiev.prog.spring.sample0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car = ctx.getBean("car1", Car.class);
        Car car1 = ctx.getBean("car2", Car.class);
        System.out.println(car);
        System.out.println(car1);
    }
}
