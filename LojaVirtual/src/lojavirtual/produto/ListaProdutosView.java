/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.produto;

import java.util.List;
import lojavirtual.BaseView;
import lojavirtual.domain.Produto;

/**
 *
 * @author etec
 */
public interface ListaProdutosView extends BaseView{

    String getNomeProdutoPesquisado();

    void showProdutos(List<Produto> produtos);
}
