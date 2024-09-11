import com.classes.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {

        Alien dhawan = new Alien();
//        dhawan.setName("Snake");
//        dhawan.setId(102);
//        dhawan.setColor("Green");

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        dhawan = (Alien) session.get(Alien.class, 102); //gets alien of id 102
        tx.commit();
        System.out.println(dhawan);
    }
}
