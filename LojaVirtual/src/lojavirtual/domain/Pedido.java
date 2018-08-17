/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author etec
 */
public class Pedido implements Serializable{
    
    private Long numero;
    private Date data;
    private double total;
    private StatusPedido status;
    private FormaEnvio formaEnvio;
    private Usuario usuario;
    private List<ItemPedido> itens;

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FormaEnvio getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(FormaEnvio formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  
    
    
    
}
