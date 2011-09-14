/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

import javax.persistence.EntityManager;

/**
 *
 * @author Kenneth.Clark
 */
public interface UnitOfWork {
    EntityManager getEntityManager();
    void commit();
    void rollback();
}
