/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etec
 */
public class WishList implements Serializable{
    
    private Long id;
    private Usuario usuario;
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getProdutos() {
        if (produtos == null){
            produtos = new ArrayList<>();
        }
        
        return produtos;
    }
    
    public WishList addProduto(Produto produto){
        getProdutos().add(produto);
        return this;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
