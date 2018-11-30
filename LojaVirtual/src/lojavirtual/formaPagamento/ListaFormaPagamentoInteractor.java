/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.formaPagamento;

import java.util.List;
import java.util.stream.Collectors;
import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.FormaPagamento;

/**
 *
 * @author etec
 */
public class ListaFormaPagamentoInteractor extends BaseInteractor {

    public final ListaFormaPagamentoView view;

    public ListaFormaPagamentoInteractor(ListaFormaPagamentoView view) {
        super(view);
        this.view = view;
    }
            
    @Override
    protected void runImpl() {
        String descricaoPraPesquisa = view.getNomeFormaPagamentoPesquisado();
        
        Repository<FormaPagamento, Long> repositorio = PersistenceUtil.getRepositorioFormaPagamento();
        List<FormaPagamento> resultadoPesquisa;
        
        if (descricaoPraPesquisa != null && !descricaoPraPesquisa.isEmpty()){
            resultadoPesquisa = repositorio.findAll()
                                           .stream()
                                           .filter(u -> preparaTexto(u.getNome()).startsWith(preparaTexto(descricaoPraPesquisa)))
                                           .collect(Collectors.toList());
        }
        else{
            resultadoPesquisa = repositorio.findAll();
        }
        
        view.showFormaPagamento(resultadoPesquisa);
        view.showMessage(MessageType.INFO, String.format("Foram encontrado(s) %d Forma(s) de Pagamento", resultadoPesquisa.size()));
    }
    
}
