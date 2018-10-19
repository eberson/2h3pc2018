/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.categoria;

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
public class NovaCategoriaController extends BaseViewImpl implements Initializable, NovaCategoriaView {

    @FXML private Label labelForMessage;
    
    @FXML private TextField campoDescricao;
    
    public static URL getParentURL() throws Exception{
        return NovaCategoriaController.class.getResource("NovaCategoria.fxml");
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
        return labelForMessage;
    }

    @Override
    public String getDescricao() {
        return campoDescricao.getText();
    }
    
    @FXML
    public void acaoSalvar(ActionEvent event){
        new NovaCategoriaInteractor(this).run();
    }
    
     @FXML
    @Override
    public void acaoSair(ActionEvent event) {
        super.acaoSair(event); //To change body of generated methods, choose Tools | Templates.
    }
}
