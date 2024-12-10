package factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ContaFactory {
    public static EntityManagerFactory emf;

    public static EntityManager configFactoryConta(){
        emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void closeEntityFactory(EntityManager em){
        em.close();
        emf.close();
    }

    public static void saveAndClose(EntityManager em){
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
