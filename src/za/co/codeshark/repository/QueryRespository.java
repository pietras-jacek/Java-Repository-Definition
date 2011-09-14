/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.codeshark.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Kenneth.Clark
 */
public interface QueryRespository<TEntity> {
    public List<TEntity> query(String namedQuery, Class<TEntity> ofType, Map<String, Object> parameters);
    public TEntity findBy(Class<TEntity> ofType, Object id) ;
}
