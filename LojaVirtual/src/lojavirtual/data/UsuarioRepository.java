/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.data;

import java.util.List;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public interface UsuarioRepository extends Repository<Usuario, Long>{
    
    List<Usuario> findAllByName(String nome);
    
}
