/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lojavirtual.BaseViewImpl;
import lojavirtual.MessageType;
import lojavirtual.ViewListener;
import lojavirtual.domain.Usuario;
import lojavirtual.util.StageUtil;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class ListaUsuariosController extends BaseViewImpl implements Initializable, ListaUsuariosView, ViewListener {
    
    @FXML private Label labelMessage;
    @FXML private TextField campoPesquisa;
    
    @FXML private TableView<Usuario> tabela;
    @FXML private TableColumn<Usuario, Long> colunaCodigo;
    @FXML private TableColumn<Usuario, String> colunaNome;
    @FXML private TableColumn<Usuario, String> colunaEmail;
    
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
        ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
        
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tabela.setItems(listaUsuarios);
    }    

    @Override
    protected Label currentLabelForMessage() {
        return labelMessage;
    }
    
    public void acaoOk(ActionEvent event){
        StageUtil.openNewStage(NovoUsuarioController.getParentURL());
    }
    
    private void updateData(){
        new ListaUsuariosInteractor(this).run();
    }

    @Override
    public void registerEvents(Stage stage) {
        stage.setOnShown((WindowEvent event) -> updateData());
    }

    @Override
    public String getNomeUsuarioPesquisa() {
        return campoPesquisa.getText();
    }
    
    public void acaoClicarNoCampoDePesquisa(KeyEvent event){
        String pesquisa = campoPesquisa.getText();
        
        if (pesquisa.length() >= 3 || pesquisa.trim().isEmpty()){
            new ListaUsuariosInteractor(this).run();
        }
    }

    @Override
    public void showUsuarios(List<Usuario> usuarios) {
        ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList(usuarios);
        tabela.setItems(listaUsuarios);
    }
}
