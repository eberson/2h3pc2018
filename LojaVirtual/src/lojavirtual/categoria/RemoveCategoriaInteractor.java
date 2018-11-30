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

/**
 *
 * @author etec
 */
public class RemoveCategoriaInteractor extends BaseInteractor{

    private final RemoveCategoriaView view;
    
    public RemoveCategoriaInteractor(RemoveCategoriaView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        try {
            //obtem uma instancia do repositorio de categorias (aquele q se comunica com a tabela de categorias no banco)
            Repository<Categoria, Long> repositorio = PersistenceUtil.getRepositorioCategoria(); 
            
            //mando o repositorio remover a categoria selecionada do banco
            repositorio.remove(view.getCategoria());
            
            //exibimos uma mensagem dizendo q conseguimos remover
            view.showMessage(MessageType.INFO, "Categoria removida com sucesso!");
        } catch (Exception e) {
            view.showMessage(MessageType.ERROR, e.getMessage());
        }
    }
}
