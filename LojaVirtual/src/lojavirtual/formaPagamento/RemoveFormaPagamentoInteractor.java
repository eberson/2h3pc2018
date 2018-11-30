/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.formaPagamento;

import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.FormaPagamento;

/**
 *
 * @author etec
 */
public class RemoveFormaPagamentoInteractor extends BaseInteractor{
    
    private final RemoveFormaPagamentoView view;
    
    public RemoveFormaPagamentoInteractor(RemoveFormaPagamentoView view){
        super(view);
        this.view = view;
    }
    
    @Override
    protected void runImpl(){
        try {
            Repository<FormaPagamento, Long> repositorio = PersistenceUtil.getRepositorioFormaPagamento();
            
            repositorio.remove(view.getFormaPagamento());
            
            view.showMessage(MessageType.INFO, "Forma de pagamento removida com sucesso");
        } catch (Exception e) {
            view.showMessage(MessageType.ERROR, e.getMessage()); 
        }
    }
}
