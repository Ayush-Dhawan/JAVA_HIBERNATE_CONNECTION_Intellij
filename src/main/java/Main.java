import com.classes.Alien;
import com.classes.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {

        AlienName an = new AlienName("Ayush", "Dhawan", "Vishal");
        Alien dhawan = new Alien();
        dhawan.setColor("blue");
        dhawan.setId(101);
        dhawan.setName(an);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(dhawan);
        tx.commit();

        System.out.println(dhawan);
    }
}
