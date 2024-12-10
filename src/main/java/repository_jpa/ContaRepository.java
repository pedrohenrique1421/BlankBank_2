package repository_jpa;

import factory.ContaFactory;
import jakarta.persistence.EntityManager;
import model.conta.Conta;
import model.conta.ContaController;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.users.User;

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
        Conta conta = entityManager.find(Conta.class, id);
        ContaFactory.closeEntityFactory(entityManager);
        return conta;
    }

    public static List<ContaCorrente> listAllContaCorrente(){
        entityManager = ContaFactory.configFactoryConta();
        List<ContaCorrente> lista = entityManager.createQuery("SELECT c FROM ContaCorrente c", ContaCorrente.class).getResultList();
        ContaFactory.closeEntityFactory(entityManager);
        return lista;
    }

    public static Long GET_ID_USER(Conta conta){
        entityManager = ContaFactory.configFactoryConta();
        ContaController contaController = new ContaController();
        int contaId = contaController.getId(conta);
        if(conta instanceof ContaCorrente){
            ContaCorrente contaAchada = entityManager.find(ContaCorrente.class, contaId);
            return contaAchada.getUsuario().getId();
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaAchada = entityManager.find(ContaPoupanca.class, contaId);
            return contaAchada.getUsuario().getId();
        }
        ContaFactory.closeEntityFactory(entityManager);
        return -1L;
    }

    public static boolean depositarValor(Conta conta, float valor) {
        try {
            entityManager = ContaFactory.configFactoryConta();

            // Iniciar a transação
            entityManager.getTransaction().begin();

            // Atualiza o saldo
            ContaController contaController = new ContaController();
            contaController.somarSaldo(conta, valor);
            Conta response = entityManager.merge(conta);

            // Confirmar a transação
            entityManager.getTransaction().commit();

            ContaFactory.closeEntityFactory(entityManager);
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();  // Reverter em caso de erro
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<User> listAllUsers(){
        entityManager = ContaFactory.configFactoryConta();
        List<User> lista = entityManager.createQuery("SELECT u FROM model.users.User u", User.class).getResultList();
        ContaFactory.closeEntityFactory(entityManager);
        return lista;
    }
}
