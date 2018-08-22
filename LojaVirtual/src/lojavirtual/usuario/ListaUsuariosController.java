/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lojavirtual.BaseViewImpl;
import lojavirtual.MessageType;
import lojavirtual.ViewListener;
import lojavirtual.util.StageUtil;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class ListaUsuariosController extends BaseViewImpl implements Initializable, ListaUsuariosView, ViewListener {
    
    @FXML private Label labelMessage;
    
    public static Parent getRootParent() throws Exception{
        return FXMLLoader.load(ListaUsuariosController.class.getResource("ListaUsuarios.fxml"));
    }
    
    public static URL getParentURL() throws Exception{
        return ListaUsuariosController.class.getResource("ListaUsuarios.fxml");
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
        return labelMessage;
    }
    
    public void acaoOk(ActionEvent event){
        StageUtil.openNewStage(NovoUsuarioController.getParentURL());
    }
    
    private void updateData(){
        showMessage(MessageType.INFO, "Deveria carregar os dados na tabela...");
    }

    @Override
    public void registerEvents(Stage stage) {
        stage.setOnShown((WindowEvent event) -> updateData());
    }
    
}
