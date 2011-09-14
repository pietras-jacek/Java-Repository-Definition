/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

/**
 *
 * @author Kenneth.Clark
 */
public interface GuidKeyedRepository<TEntity> extends Repository<TEntity> {
    TEntity findBy(String id);
}
