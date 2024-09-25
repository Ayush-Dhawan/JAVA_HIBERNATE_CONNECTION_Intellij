import com.classes.Laptop;
import com.classes.Stud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop lap = new Laptop();
        lap.setLaptop_id(1);
        lap.setLaptop_name("asus tuf a15");

        Laptop lap2 = new Laptop();
        lap2.setLaptop_id(61);
        lap2.setLaptop_name("Dell vostro i3");

        Stud stud = new Stud();
        stud.setName("ayush");
        stud.setMarks(95);
        stud.setRoll_no(1);


        stud.setLaptops(Arrays.asList(lap, lap2));

        // Set the student for each laptop
//        lap.setStuds(Arrays.asList(stud));
//        lap2.setStuds(Arrays.asList(stud));

        Stud stud1 = null;

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Stud.class).addAnnotatedClass(Laptop.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();


        stud1 = (Stud)session1.get(Stud.class, 1);
        tx1.commit();
        session1.close();


        Transaction tx2 = session2.beginTransaction();
        stud1 = (Stud)session2.get(Stud.class, 1);
        System.out.println(stud1);


        tx2.commit();
        session2.close();
    }
}
