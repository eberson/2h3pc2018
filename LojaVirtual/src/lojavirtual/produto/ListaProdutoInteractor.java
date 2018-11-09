/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.produto;

import java.util.List;
import java.util.stream.Collectors;
import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Produto;

/**
 *
 * @author etec
 */
public class ListaProdutoInteractor extends BaseInteractor{

    private final ListaProdutosView view;
    
    public ListaProdutoInteractor(ListaProdutosView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        String descricaoPraPesquisa = view.getNomeProdutoPesquisado();
        
        Repository<Produto, Long> repositorio = PersistenceUtil.getRepositorioProduto();
        List<Produto> resultadoPesquisa;
        
        if (descricaoPraPesquisa != null && !descricaoPraPesquisa.isEmpty()){
            resultadoPesquisa = repositorio.findAll()
                                           .stream()
                                           .filter(u -> preparaTexto(u.getDescricao()).startsWith(preparaTexto(descricaoPraPesquisa)))
                                           .collect(Collectors.toList());
        }
        else{
            resultadoPesquisa = repositorio.findAll();
        }
        
        view.showProdutos(resultadoPesquisa);
        view.showMessage(MessageType.INFO, String.format("Foram encontrado(s) %d produto(s)", resultadoPesquisa.size()));
    }
    
}
