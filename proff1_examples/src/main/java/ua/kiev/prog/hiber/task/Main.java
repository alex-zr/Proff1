package ua.kiev.prog.hiber.task;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/*
Создать ноутбук (id, model, brand, price, isUsed, date)
    java time
    java time example
    java time example hibernate jpa
сохранить 5 ноутбуков
Вычитать все ноутбуки и вывести на экран
Задание сделать в своём модуле
И запушить в мастер

1. Создание сущности
2. Пишем класс задания
3. Создать персистент юнит
4. Выложить в гит
 */
public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        try {
            emf = Persistence.createEntityManagerFactory("HiberTask");
            em = emf.createEntityManager();

            LocalDate parse = LocalDate.parse("2018-12-27");

            em.getTransaction().begin();
            em.persist(new Notebook("Dell"));
            em.persist(new Notebook("Mac"));
            em.persist(new Notebook("HP"));
            em.persist(new Notebook("Xiaomi"));
            em.persist(new Notebook("Asus"));
            em.getTransaction().commit();

            em.createQuery("FROM Notebook").getResultList().stream()
                    .forEach(System.out::println);

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
