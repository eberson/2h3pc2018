/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.data;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lojavirtual.domain.Entidade;

/**
 *
 * @author etec
 * @param <T>
 * @param <K>
 */
@SuppressWarnings("LocalVariableHidesMemberVariable")
class BaseRepository<T extends Entidade, K> implements Repository<T, K>{
    
    protected final EntityManager em;
    private final Class<T> type;

    public BaseRepository(Class<T> type) {
        em = PersistenceUtil.currentEntityManager();
        this.type = type;
    }
    
    protected void runOnTransaction(TransactionRunnable runnable){
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            runnable.run(em);
            transaction.commit();
        } catch (ConstraintViolationException e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            
            StringBuilder message = new StringBuilder();
            
            e.getConstraintViolations().stream().forEach((v) -> message.append(String.format("%s %s.", v.getPropertyPath(), v.getMessage())));
            
            throw new RuntimeException(message.toString());            
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Erro ao executar transação", e);
            
            if (transaction.isActive()){
                transaction.rollback();
            }
            
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void save(T element) {
        runOnTransaction((EntityManager em) -> {
            if (element.getKey() == null) {
                em.persist(element);
            } else {
                em.merge(element);
            }
        });
    }

    @Override
    public void remove(T element) {
        runOnTransaction((EntityManager em) -> {
            em.remove(element);
        });
    }

    @Override
    public T findOne(K key) {
        return em.find(type, key);
    }

    @Override
    public List<T> findAll() {
        String query = String.format(
                "select e from %s e", 
                type.getSimpleName()
        );
        
        return em.createQuery(query, type).getResultList();
    }
    
}
