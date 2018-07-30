/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.data;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author etec
 * @param <T>
 * @param <K>
 */
public interface Repository<T, K> {
    
    public void save(T element);
    public void remove(T element);
    public T findOne(K key);
    public List<T> findAll();
    
    public interface TransactionRunnable{
        void run(EntityManager em);
    }
}
