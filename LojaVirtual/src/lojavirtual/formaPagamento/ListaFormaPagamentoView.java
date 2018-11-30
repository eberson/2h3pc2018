/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.formaPagamento;

import java.util.List;
import lojavirtual.BaseView;
import lojavirtual.domain.FormaPagamento;

/**
 *
 * @author etec
 */
public interface ListaFormaPagamentoView extends BaseView {
    
    String getNomeFormaPagamentoPesquisado();

    void showFormaPagamento(List<FormaPagamento> formasPagamento);
}
