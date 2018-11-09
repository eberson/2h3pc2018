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
public class NovaFormaPagamentoInteractor extends BaseInteractor {
    
    private final NovaFormaPagamentoView view;

    public NovaFormaPagamentoInteractor(NovaFormaPagamentoView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        try {
            FormaPagamento fp = new FormaPagamento();
            fp.setNome(view.getNome());

            Repository<FormaPagamento, Long> repositorio = PersistenceUtil.getRepositorioFormaPagamento();
            repositorio.save(fp);
            view.showMessage(MessageType.INFO, "Forma de pagamento criada com sucesso!");
        } catch (Exception e) {
            view.showMessage(MessageType.ERROR, e.getMessage());
        }
    }  
}
