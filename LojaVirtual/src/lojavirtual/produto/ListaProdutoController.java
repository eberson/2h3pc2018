/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.produto;

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
import lojavirtual.ViewListener;
import lojavirtual.domain.Categoria;
import lojavirtual.domain.Produto;
import lojavirtual.util.StageUtil;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class ListaProdutoController extends BaseViewImpl implements Initializable, ViewListener, ListaProdutosView {

    @FXML private Label mensagem;
    @FXML private TextField nomeProdutoPesquisa;
    
    @FXML private TableView<Produto> tabela;
    @FXML private TableColumn<Produto, Long> colunaID;
    @FXML private TableColumn<Produto, String> colunaNome;
    @FXML private TableColumn<Produto, String> colunaDescricao;
    @FXML private TableColumn<Produto, Double> colunaEstoque;
    @FXML private TableColumn<Produto, Categoria> colunaCategoria;
    
    public static URL getParentURL() throws Exception{
        return ListaProdutoController.class.getResource("ListaProduto.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Produto> lista = FXCollections.observableArrayList();
        
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        
        tabela.setItems(lista);
    }    

    @Override
    protected Label currentLabelForMessage() {
        return mensagem;
    }

    private void updateData(){
        new ListaProdutoInteractor(this).run();
    }

    @Override
    public void registerEvents(Stage stage) {
        stage.setOnShown((event) -> updateData());
    }
    
    public void acaoNovoProduto(ActionEvent event) throws Exception{
        StageUtil.openNewStage(NovoProdutoController.getParentURL());
    }
    
    public void acaoClicarNoCampoDePesquisa(KeyEvent event){
        String pesquisa = nomeProdutoPesquisa.getText();
        
        if (pesquisa.length() >= 3 || pesquisa.trim().isEmpty()){
            updateData();
        }
    }

    @Override
    public String getNomeProdutoPesquisado() {
        return nomeProdutoPesquisa.getText();
    }

    @Override
    public void showProdutos(List<Produto> produtos) {
        ObservableList<Produto> lista = FXCollections.observableArrayList(produtos);
        tabela.setItems(lista);
    }
}
