/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.categoria;

import java.util.List;
import java.util.stream.Collectors;
import lojavirtual.BaseInteractor;
import lojavirtual.BaseView;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Categoria;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class ListaCategoriaInteractor extends BaseInteractor{

    private final ListaCategoriaView view;
    
    public ListaCategoriaInteractor(ListaCategoriaView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        String descricaoPraPesquisa = view.getNomeCategoriaPesquisada();
        
        Repository<Categoria, Long> repositorio = PersistenceUtil.getRepositorioCategoria();
        List<Categoria> resultadoPesquisa;
        
        if (descricaoPraPesquisa != null && !descricaoPraPesquisa.isEmpty()){
            resultadoPesquisa = repositorio.findAll()
                                           .stream()
                                           .filter(u -> preparaTexto(u.getDescricao()).startsWith(preparaTexto(descricaoPraPesquisa)))
                                           .collect(Collectors.toList());
        }
        else{
            resultadoPesquisa = repositorio.findAll();
        }
        
        view.showCategorias(resultadoPesquisa);
        view.showMessage(MessageType.INFO, String.format("Foram encontrado(s) %d categoria(s)", resultadoPesquisa.size()));
    }
    
}
