package application.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarProduto;
import application.models.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 09/07/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/ 
public class ProdutosVisuController implements Initializable {

	@FXML
	private Button btVoltar;

	@FXML
	private TableColumn<Produto, String> idCol;

	@FXML
	private TableColumn<Produto, String> nomeCol;

	@FXML
	private TableColumn<Produto, String> precoCol;

	@FXML
	private TableView<Produto> produtos;

	@FXML
	private TableColumn<Produto, String> quantidadeCol;

	@FXML
	private TableColumn<Produto, String> vencimentoCol;

	private ObservableList<Produto> obsProdutos;
	
	/**
	 * Fun��o respons�vel pelo evento do bot�o voltar 
	 * em que fecha a janela atual
	 * @param event
	 */
	@FXML
	void onBtVoltar(ActionEvent event) {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
	}

	/**
	 * Fun��o respons�vel por carregar a tableview
	 */
	public void carregandoTableView() {
		List<Produto> listaProdutos = GerenciarProduto.getProdutos();
		obsProdutos = FXCollections.observableArrayList(listaProdutos);
		produtos.setItems(obsProdutos);
		carregandoColunas();

	}

	/**
	 * Fun��o respon�vel por carregar Colunas
	 */
	public void carregandoColunas() {

		idCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("idProduto"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeProduto"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("precoProduto"));
		vencimentoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
		quantidadeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("quantidadeProduto"));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregandoTableView();

	}

}
