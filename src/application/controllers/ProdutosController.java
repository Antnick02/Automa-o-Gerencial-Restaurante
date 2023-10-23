package application.controllers;
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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.GerenciarProduto;
import application.models.Produto;
import application.util.Alertas;
import application.util.Verificacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProdutosController implements Initializable {

	@FXML
	private Button btAtualizar;

	@FXML
	private Button btBuscaUsuario;

	@FXML
	private Button btEditar;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btNovoProduto;

	@FXML
	private Button btVoltar;
	
	@FXML 
	private Button btRelatorios;
	
	@FXML
	private TextField idBusca;

	@FXML
	private TableColumn<Produto, String> idCol;

	@FXML
	private TableColumn<Produto, String> nomeCol;

	@FXML
	private TableColumn<Produto, String> precoCol;

	@FXML
	private TableColumn<Produto, String> vencimentoCol;

	@FXML
	private TableColumn<Produto, String> quantidadeCol;

	@FXML
	private TableView<Produto> produtos;

	private ObservableList<Produto>obsProdutos;

	/**
	 * Fun��o do bot�o de voltar para tela anterior
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVoltar(ActionEvent Event) throws IOException {
		Main m = new Main();
		m.mudarCena("/views/LogadoView.fxml");
	}

	/**
	 * Fun��o respons�vel por checar o id de busca do usu�rio e modificar a table
	 * view pela pesquisa
	 * 
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {

			int id = Integer.parseInt(idBusca.getText());

			if (Verificacoes.verificaExistenciaIdUsuario(id)) {

				int posicao;

				posicao = GerenciarProduto.buscaProduto(id, GerenciarProduto.getProdutos(),
						GerenciarProduto.getProdutos().size());
				List<Produto> produto = new ArrayList<>();
				
				
				produto.add(GerenciarProduto.getProdutos().get(posicao));

				obsProdutos = FXCollections.observableArrayList(produto);

				produtos.setItems(obsProdutos);

				carregandoColunas();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inv�lido!!", "S� � aceito apenas n�meros", AlertType.WARNING);
		}
	}

	/**
	 * Fun��o do bot�o respons�vel pela busca de um produto pelo id
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtBusca(ActionEvent Event) throws IOException {

		checarIdBusca();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		carregandoTableView();

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

	/**
	 * Fun��o do evento do bot�o atualizar, respons�vel por atualizar a tableView
	 * 
	 * @param Event
	 */
	@FXML
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableView();
	}

	/**
	 * Fun��o do bot�o ExcluirProduto respons�vel por trocar de tela para exclus�o
	 * de produto
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtExcluir(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirProdutoView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclus�o de Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}

	/**
	 * Fun��o do bot�o AdicionarProduto respons�vel por trocar de tela para adi��o
	 * de produto
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtAdicionarProduto(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/AdicionarProdutoView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cadastro de Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btNovoProduto.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}

	/**
	 * Fun��o do bot�o EditarProduto respons�vel por trocar de tela para edi��o de
	 * Produto
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtEditarProduto(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/EditarProdutoView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Edi��o de Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btEditar.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}
	
	
	@FXML 
	public void onBtRelatorios(ActionEvent Event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/RelatoriosProdutosView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Relat�rios Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btRelatorios.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}
}
