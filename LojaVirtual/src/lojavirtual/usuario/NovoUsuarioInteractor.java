/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class NovoUsuarioInteractor extends BaseInteractor{
    
    private final NovoUsuarioView view;

    public NovoUsuarioInteractor(NovoUsuarioView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(view.getNome());
            usuario.setEmail(view.getEmail());
            usuario.setSenha(view.getSenha());
            usuario.setTipo(view.getTipoUsuario());

            Repository<Usuario, Long> repositorio = PersistenceUtil.getRepositorioUsuario();
            repositorio.save(usuario);
            view.showMessage(MessageType.INFO, "Usuário criado com sucesso!");
        } catch (Exception e) {
            view.showMessage(MessageType.ERROR, e.getMessage());
        }
    }
}
