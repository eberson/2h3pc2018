/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.principal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lojavirtual.usuario.ListaUsuariosController;
import lojavirtual.util.StageUtil;

/**
 *
 * @author etec
 */
public class PrincipalController implements Initializable {
    
    public static Parent getRootParent() throws Exception{
        return FXMLLoader.load(PrincipalController.class.getResource("Principal.fxml"));
    }
    
    public void acaoSair(ActionEvent event){
        Platform.exit();
    }
    
    public void acaoUsuarios(ActionEvent event) throws Exception{
        StageUtil.openNewStage(ListaUsuariosController.getRootParent());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
