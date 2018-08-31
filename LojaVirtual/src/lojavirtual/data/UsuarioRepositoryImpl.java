/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.data;

import java.util.List;
import javax.persistence.TypedQuery;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class UsuarioRepositoryImpl extends BaseRepository<Usuario, Long> implements UsuarioRepository{

    public UsuarioRepositoryImpl() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> findAllByName(String nome) {
        String jpql = "select e from Usuario e where e.nome like :nome";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }
    
}
