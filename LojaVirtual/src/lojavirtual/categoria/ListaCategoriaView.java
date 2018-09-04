/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.categoria;

import java.util.List;
import lojavirtual.BaseView;
import lojavirtual.domain.Categoria;

/**
 *
 * @author etec
 */
public interface ListaCategoriaView extends BaseView{
    
    String getNomeCategoriaPesquisada();
    
    void showCategorias(List<Categoria> categorias);
}
