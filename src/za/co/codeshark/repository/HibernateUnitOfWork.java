/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

/**
 *
 * @author Kenneth.Clark
 */
public class HibernateUnitOfWork implements UnitOfWork {
    
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction transaction;
    private EntityManager entityManager;
    
    public HibernateUnitOfWork(EntityManagerFactory entityManagerFactory){
        if(entityManagerFactory  == null)
            throw new RuntimeException("HibernateUnitOfWork.const : EntityManagerFactory cannot be null");
        
       this.entityManagerFactory = entityManagerFactory;
       this.entityManager = this.entityManagerFactory.createEntityManager();
       this.entityManager.setFlushMode(FlushModeType.AUTO);
       this.transaction = entityManager.getTransaction();
       this.transaction.begin();
    }
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void commit() {
        if(!transaction.isActive())
            throw new RuntimeException("HibernateUnitOfWork.commit : Ths transaction is not active");
        
        transaction.commit();
        this.end();
    }

    @Override
    public void rollback() {
        if(transaction.isActive())
            transaction.rollback();
        
        this.end();
    }
    
    private void end(){
        if(entityManager.isOpen())
            entityManager.close();
        
        if(entityManagerFactory.isOpen())
            entityManagerFactory.close();
    }
    
}
