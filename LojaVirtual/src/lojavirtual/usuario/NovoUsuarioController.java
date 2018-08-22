/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lojavirtual.BaseViewImpl;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class NovoUsuarioController extends BaseViewImpl implements Initializable, NovoUsuarioView {

    public static URL getParentURL(){
        return NovoUsuarioController.class.getResource("NovoUsuario.fxml");
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
        return null;
    }
    
}
