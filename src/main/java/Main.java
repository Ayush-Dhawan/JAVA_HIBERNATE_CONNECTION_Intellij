import com.classes.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien dhawan = new Alien();
        dhawan.setName("Ayush");
        dhawan.setId(101);
        dhawan.setColor("Green");

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(dhawan);

        tx.commit();
    }
}
