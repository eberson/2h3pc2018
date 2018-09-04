/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.categoria;

import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Categoria;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class NovaCategoriaInteractor extends BaseInteractor{

    private final NovaCategoriaView view;
    
    public NovaCategoriaInteractor(NovaCategoriaView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        Categoria categoria = new Categoria();
        categoria.setDescricao(view.getDescricao());
        
        Repository<Categoria, Long> repositorio = PersistenceUtil.getRepositorioCategoria();
        repositorio.save(categoria);
        view.showMessage(MessageType.INFO, "Categoria criada com sucesso!");
    }
    
}
