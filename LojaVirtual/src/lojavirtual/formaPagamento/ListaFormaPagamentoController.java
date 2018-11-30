/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.formaPagamento;

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
import javafx.stage.Stage;
import lojavirtual.BaseViewImpl;
import lojavirtual.MessageType;
import lojavirtual.ViewListener;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.FormaPagamento;
import lojavirtual.util.StageUtil;

/**
 * FXML Controller class
 *
 * @author etec
 */
public class ListaFormaPagamentoController extends BaseViewImpl implements Initializable, ViewListener, ListaFormaPagamentoView, RemoveFormaPagamentoView {

    @FXML private Label mensagem;
    
    @FXML private TextField nomeFormaPagamentoPesquisa;
    @FXML private TableView<FormaPagamento> tabela;
    @FXML private TableColumn<FormaPagamento, Long> colunaId;
    @FXML private TableColumn<FormaPagamento, String> colunaDescricao;
    
    private FormaPagamento formaPagamento;
    
    public static URL getParentURL(){
        return ListaFormaPagamentoController.class.getResource("ListaFormaPagamento.fxml");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        Repository<FormaPagamento, Long> repositorio = PersistenceUtil.getRepositorioFormaPagamento();
        tabela.setItems(FXCollections.observableArrayList(repositorio.findAll()));
    }    

    @Override
    protected Label currentLabelForMessage() {
        return mensagem;
    }

    @Override
    public void registerEvents(Stage stage) {
        
    }
    
    @Override
    public FormaPagamento getFormaPagamento(){
        return formaPagamento;
    }
    
    public void acaoRemover(ActionEvent event) throws Exception{
        formaPagamento = tabela.getSelectionModel().getSelectedItem();
        
        if (formaPagamento == null) {
            showMessage(MessageType.ERROR, "Uma forma de pagamento deve ser selecionada.");
            return;
        }
        
        new RemoveFormaPagamentoInteractor(this).run();
        updateData();
    }
    
    public void acaoNovaFormaPagamento(ActionEvent event) throws Exception{
        StageUtil.openNewStage(NovaFormaPagamentoController.getParentURL());
    }

    @Override
    public String getNomeFormaPagamentoPesquisado() {
        //return formaPagamento.getText();
        return "";
    }

    @Override
    public void showFormaPagamento(List<FormaPagamento> formasPagamento) {
        ObservableList<FormaPagamento> lista = FXCollections.observableArrayList(formasPagamento);
        tabela.setItems(lista);
    }

    private void updateData() {
        new ListaFormaPagamentoInteractor(this).run();
    }
}