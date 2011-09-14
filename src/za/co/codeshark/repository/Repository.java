/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

import java.util.Collection;

/**
 *
 * @author Kenneth.Clark
 */
public interface Repository<TEntity> extends QueryRespository<TEntity> {
    public void add(TEntity entity);
    public void add(Collection<TEntity> entities);
    public void update(TEntity entity);
    public void delete(TEntity entity);
    public void delete(Collection<TEntity> entities);
}
