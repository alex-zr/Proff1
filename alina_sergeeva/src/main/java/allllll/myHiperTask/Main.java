package allllll.myHiperTask;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[]args){
        try{
            emf= Persistence.createEntityManagerFactory("HiberTask");
            em=emf.createEntityManager();
            em.getTransaction().begin();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            em.persist(new Laptop("GX700VO", "ASUS",20000,false, new Date(80-0-1)));
          em.persist(new Laptop("Predator G9", "Acer",10000,false, new Date(80-1-2)));
            em.persist(new Laptop("Legion Y 520", "LENOVO",8000,true, new Date(90-1-3)));
            em.persist(new Laptop("MacBook Pro MLUQ2RU/A", "Aple",45000,false, new Date(99-12-22)));
            em.persist(new Laptop("HP 250 G5", "HP",18000,false, new Date(2011-11-10)));
            em.getTransaction().commit();


            em.createQuery("FROM Laptop").getResultList().stream()
                    .forEach(System.out::println);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }finally {
            em.close();
            emf.close();
    }
}
//    public void viewLaptops(){
//        Query query = em.createQuery("FROM laptops c",Laptop.class);
//        List<Laptop> list = (List<Laptop>) query.getResultList();
//
//        for (Laptop c : list)
//            System.out.println(c);
//
//    }
//    public void menu(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        try {
//            // create connection
//            emf = Persistence.createEntityManagerFactory("myHiperTask");
//            em = emf.createEntityManager();
//            try {
//                while (true) {
//                    System.out.println("1: показать все ноутбуки");
//                    System.out.print("-> ");
//                    String s = sc.nextLine();
//                    switch (s) {
//                        case "1":
//                            viewLaptops();
//                            break;
//                        default:
//                            return;
//                    }
//                }
//            } finally {
//                sc.close();
//                em.close();
//                emf.close();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return;
//        }
//    }


}
