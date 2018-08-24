/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lojavirtual.BaseViewImpl;
import lojavirtual.domain.TipoUsuario;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class NovoUsuarioController extends BaseViewImpl implements Initializable, NovoUsuarioView {

    @FXML private Label mensagem;
    @FXML private TextField campoNome;
    @FXML private TextField campoEmail;
    @FXML private PasswordField campoSenha;
    @FXML private ComboBox<TipoUsuario> tipoUsuario;
    
    public static URL getParentURL(){
        return NovoUsuarioController.class.getResource("NovoUsuario.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoUsuario.setItems(FXCollections.observableArrayList(TipoUsuario.values()));
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
    public String getEmail() {
        return campoEmail.getText();
    }

    @Override
    public String getSenha() {
        return campoSenha.getText();
    }

    @Override
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    public void acaoSalvar(ActionEvent event){
        new NovoUsuarioInteractor(this).run();
    }

    @FXML
    @Override
    public void acaoSair(ActionEvent event) {
        super.acaoSair(event); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
