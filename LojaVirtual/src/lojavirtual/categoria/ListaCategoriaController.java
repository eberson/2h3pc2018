/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.categoria;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lojavirtual.BaseViewImpl;
import lojavirtual.MessageType;
import lojavirtual.ViewListener;
import lojavirtual.domain.Categoria;
import lojavirtual.domain.Usuario;
import lojavirtual.usuario.NovoUsuarioController;
import lojavirtual.util.StageUtil;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class ListaCategoriaController extends BaseViewImpl implements Initializable, ViewListener, ListaCategoriaView, RemoveCategoriaView {
    
    @FXML private Label labelMensagem;
    
    @FXML private TextField campoPesquisa;
    
    @FXML private TableView<Categoria> tabela;
    @FXML private TableColumn<Categoria, Long> colunaId;
    @FXML private TableColumn<Categoria, String> colunaDescricao;
    
    private Categoria categoria;

    public static URL getParentURL() throws Exception{
        return ListaCategoriaController.class.getResource("ListaCategoria.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Categoria> lista = FXCollections.observableArrayList();
        
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        
        tabela.setItems(lista);
    }

    public void acaoNovaCategoria(ActionEvent event) throws Exception{
        StageUtil.openNewStage(NovaCategoriaController.getParentURL());
    }    

    @Override
    protected Label currentLabelForMessage() {
        return labelMensagem;
    }
    
    private void updateData(){
        new ListaCategoriaInteractor(this).run();
    }

    @Override
    public void registerEvents(Stage stage) {
        stage.setOnShown((event) -> updateData());
        
    }
    
    public void acaoClicarNoCampoDePesquisa(KeyEvent event){
        String pesquisa = campoPesquisa.getText();
        
        if (pesquisa.length() >= 3 || pesquisa.trim().isEmpty()){
            new ListaCategoriaInteractor(this).run();
        }
    }

    @Override
    public String getNomeCategoriaPesquisada() {
        return campoPesquisa.getText();
    }

    @Override
    public void showCategorias(List<Categoria> categorias) {
        ObservableList<Categoria> lista = FXCollections.observableArrayList(categorias);
        tabela.setItems(lista);
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void acaoRemover(ActionEvent event) throws Exception{
        categoria = tabela.getSelectionModel().getSelectedItem();
        
        if (categoria == null){
            showMessage(MessageType.ERROR, "Uma categoria deve ser selecionada para remoção");
            return;
        }
        
        new RemoveCategoriaInteractor(this).run();
        updateData();
    }
    
    
    
}
