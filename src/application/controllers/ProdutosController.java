package application.controllers;
/*
Autor: Antonio Nicassio Santos Lima
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
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
	 * Função do botão de voltar para tela anterior
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
	 * Função responsável por checar o id de busca do usuário e modificar a table
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
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}

	/**
	 * Função do botão responsável pela busca de um produto pelo id
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
	 * Função responsável por carregar a tableview
	 */
	public void carregandoTableView() {
		List<Produto> listaProdutos = GerenciarProduto.getProdutos();
		obsProdutos = FXCollections.observableArrayList(listaProdutos);
		produtos.setItems(obsProdutos);
		carregandoColunas();

	}

	/**
	 * Função responável por carregar Colunas
	 */
	public void carregandoColunas() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("idProduto"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeProduto"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("precoProduto"));
		vencimentoCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
		quantidadeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("quantidadeProduto")); 
		
	}

	/**
	 * Função do evento do botão atualizar, responsável por atualizar a tableView
	 * 
	 * @param Event
	 */
	@FXML
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableView();
	}

	/**
	 * Função do botão ExcluirProduto responsável por trocar de tela para exclusão
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
		primaryStage.setTitle("Exclusão de Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}

	/**
	 * Função do botão AdicionarProduto responsável por trocar de tela para adição
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
	 * Função do botão EditarProduto responsável por trocar de tela para edição de
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
		primaryStage.setTitle("Edição de Produto");
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
		primaryStage.setTitle("Relatórios Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btRelatorios.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}
}
