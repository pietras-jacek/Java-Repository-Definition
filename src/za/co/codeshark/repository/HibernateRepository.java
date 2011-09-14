/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Kenneth.Clark
 */
public class HibernateRepository<TEntity> implements GuidKeyedRepository<TEntity> {

    private EntityManager entityManager;

    public HibernateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TEntity findBy(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(TEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void add(Collection<TEntity> entities) {
        for (TEntity item : entities) {
            entityManager.persist(item);
        }
    }

    @Override
    public void update(TEntity entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(TEntity entity) {
        entityManager.remove(entity);
    }

    @Override
    public void delete(Collection<TEntity> entities) {
        for (TEntity item : entities) {
            entityManager.remove(item);
        }
    }

    @Override
    public List<TEntity> query(String query, Class<TEntity> ofType, Map<String, Object> parameters) {
        try {
            Query namedQuery = entityManager.createNamedQuery(query, ofType);

            Iterator iter = parameters.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                namedQuery.setParameter(entry.getKey().toString(), entry.getValue());
            }

            return namedQuery.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<TEntity>();
        }
    }

    @Override
    public TEntity findBy(Class<TEntity> ofType, Object id) {
        try {
            return entityManager.find(ofType, id);
        } catch (NoResultException e) {
            return null;
        }

    }
}
