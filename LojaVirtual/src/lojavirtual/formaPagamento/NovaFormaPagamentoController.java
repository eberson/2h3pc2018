/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.formaPagamento;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lojavirtual.BaseViewImpl;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class NovaFormaPagamentoController extends BaseViewImpl implements Initializable, NovaFormaPagamentoView {

    @FXML private Label mensagem;
    @FXML private TextField campoNome;
    
    public static URL getParentURL(){
        return NovaFormaPagamentoController.class.getResource("NovaFormaPagamento.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    protected Label currentLabelForMessage() {
        return mensagem;
    }

    @Override
    public String getNome() {
        return campoNome.getText();
    }
    
    @FXML
    public void acaoSalvar(ActionEvent event){
        new NovaFormaPagamentoInteractor(this).run();
    }

    @FXML
    @Override
    public void acaoSair(ActionEvent event) {
        super.acaoSair(event); //To change body of generated methods, choose Tools | Templates.
    }    
}
