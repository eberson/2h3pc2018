/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lojavirtual.domain.Categoria;
import lojavirtual.domain.FormaPagamento;
import lojavirtual.domain.Produto;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class PersistenceUtil {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager currentEntityManager(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("LojaVirtualPU");
        }
        
        if (em == null){
            em = emf.createEntityManager();
        }
        
        return em;
    }
    
    public static Repository<Usuario, Long> getRepositorioUsuario(){
        return new BaseRepository<>(Usuario.class);
    }
    
    public static Repository<Categoria, Long> getRepositorioCategoria(){
        return new BaseRepository<>(Categoria.class);
    }
    
    public static Repository<Produto, Long> getRepositorioProduto(){
        return new BaseRepository<>(Produto.class);
    }
    
    public static Repository<FormaPagamento, Long> getRepositorioFormaPagamento(){
        return new BaseRepository<>(FormaPagamento.class);
    }
}
