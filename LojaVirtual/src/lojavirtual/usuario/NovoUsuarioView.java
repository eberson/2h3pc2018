/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import lojavirtual.BaseView;
import lojavirtual.domain.TipoUsuario;

/**
 *
 * @author etec
 */
public interface NovoUsuarioView extends BaseView{
    
    String getNome();
    String getEmail();
    String getSenha();
    TipoUsuario getTipoUsuario();
    
}
