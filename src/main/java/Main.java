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

//        stud.setLaptops(Arrays.asList(lap, lap2));

        // Set the student for each laptop
        lap.setStud(stud);
        lap2.setStud(stud);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Stud.class).addAnnotatedClass(Laptop.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(lap);
        session.save(lap2);
        session.save(stud);

        tx.commit();
    }
}
