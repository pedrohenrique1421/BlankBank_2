package repository_jpa;

import factory.ContaFactory;
import jakarta.persistence.EntityManager;
import model.conta.Conta;
import model.conta.ContaCorrente;

import java.util.List;

public class ContaRepository {
    static EntityManager entityManager;

    public static void salvarContaCorrente(ContaCorrente conta){
        entityManager = ContaFactory.configFactoryConta();
        try{
            entityManager.persist(conta);
            ContaFactory.saveAndClose(entityManager);
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public static Conta getById(final int id) {
        entityManager = ContaFactory.configFactoryConta();
        return entityManager.find(Conta.class, id);
    }

    public static List<ContaCorrente> listAll(){
        entityManager = ContaFactory.configFactoryConta();

        return entityManager.createQuery("SELECT c FROM ContaCorrente c", ContaCorrente.class).getResultList();
    }
}
