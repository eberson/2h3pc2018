/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.produto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lojavirtual.BaseViewImpl;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class NovoProdutoController extends BaseViewImpl implements Initializable, NovoProdutoView {
    
    @FXML private Label mensagem;
    
    @FXML private TextField campoNome;
    @FXML private TextArea campoDescricao;
    @FXML private TextField campoEstoque;

    public static URL getParentURL() throws Exception{
        return NovoProdutoController.class.getResource("NovoProduto.fxml");
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

    @Override
    public String getDescricao() {
        return campoDescricao.getText();
    }

    @Override
    public double getEstoque() {
        return Double.parseDouble(campoEstoque.getText());
    }
    
    @Override
    public void acaoSair(ActionEvent event) {
        super.acaoSair(event);
    }
    
    public void acaoSalvar(ActionEvent event){
        new NovoProdutoInteractor(this).run();
    }
}
