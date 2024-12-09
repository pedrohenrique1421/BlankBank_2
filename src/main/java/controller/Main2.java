package controller;

import model.users.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        // Criação do EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

        // Criação do EntityManager
        EntityManager em = emf.createEntityManager();

        // Testando a persistência de dados
        em.getTransaction().begin();
        User user = new User(12, "Pedro", "231213132-12");
        em.persist(user);
        em.getTransaction().commit();

        // Fechando a conexão
        em.close();
        emf.close();
    }
}
