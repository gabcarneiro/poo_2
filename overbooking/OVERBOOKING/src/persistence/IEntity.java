/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;

/**
 *
 * @author notrealgabu
 */
public interface IEntity <E>{
    
    void save(E entity);
    void delete(E entity);
    E find(Long id);
    void update(E entity);
    List<E> findAll();
    
    
}
