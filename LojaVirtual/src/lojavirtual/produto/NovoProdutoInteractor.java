/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.produto;

import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Produto;

/**
 *
 * @author etec
 */
public class NovoProdutoInteractor extends BaseInteractor{

    private final NovoProdutoView view;

    public NovoProdutoInteractor(NovoProdutoView view) {
        super(view);
        this.view = view;
    }
    
    @Override
    protected void runImpl() {
        try {
            Produto produto = new Produto();
            produto.setDescricao(view.getDescricao());
            produto.setNome(view.getNome());
            produto.setEstoque(view.getEstoque());
            
            Repository<Produto, Long> repositorio = PersistenceUtil.getRepositorioProduto();
            repositorio.save(produto);
            
            view.showMessage(MessageType.INFO, "Produto salvo com sucesso!");
        } catch (Exception e) {
            view.showMessage(MessageType.ERROR, String.format("Ocorreu um erro ao tentar salvar o produto (%s)", e.getMessage()));
        }
    }
    
}
