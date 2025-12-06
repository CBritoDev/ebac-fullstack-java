package br.com.carlosbrito.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public class JPAUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("CursoJPA");

    private JPAUtil(){

    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return ENTITY_MANAGER_FACTORY;
    }

    public static void shutdown() {
        if (ENTITY_MANAGER_FACTORY != null && ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
            System.out.println("EntityManagerFactory fechada com sucesso.");
        }
    }

}
