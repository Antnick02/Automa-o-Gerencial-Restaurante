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
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Fornecedor;
import application.models.GerenciarFornecedor;
import application.models.GerenciarProduto;
import application.models.Produto;
import application.util.Alertas;
import application.util.ListasSecundarias;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FornecedorController implements Initializable {

	@FXML
    private Button btAtualizar;

    @FXML
    private Button btBuscaDetalhe;

    @FXML
    private Button btBuscaFornecedor;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btNovoFornecedor;

    @FXML
    private Button btRelatorios;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField idBusca;

    @FXML
    private TextField idBuscaDetalhe;

    @FXML
    private TableColumn<Fornecedor, String> idCol;

    @FXML
    private TableColumn<Produto, String> idColProduto;

    @FXML
    private Label lbCnpj;

    @FXML
    private Label lbEndereco;

    @FXML
    private Label lbId;

    @FXML
    private Label lbNome;

    @FXML
    private TableColumn<Fornecedor, String> nomeCol;

    @FXML
    private TableColumn<Produto, String> nomeColProduto;

    @FXML
    private TableColumn<Fornecedor, String> cnpjCol;

    @FXML
    private TableView<Produto> produtos; 
    
    @FXML 
    private TableView<Fornecedor> fornecedores;

	private ObservableList<Produto>obsProdutos;
	
	private ObservableList<Fornecedor>obsFornecedores;

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
	 * Fun��o respons�vel por checar o id de busca do Fornecedor e modificar a table
	 * view pela pesquisa
	 * 
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {
		
			if (Verificacoes.verificaIdFornecedor(idBusca.getText())) {
				
				int id = Integer.parseInt(idBusca.getText());
				int posicao;

				posicao = GerenciarFornecedor.buscaFornecedor(id, GerenciarFornecedor.getFornecedores(),
						GerenciarFornecedor.getFornecedores().size());
				
				Fornecedor fornecedor1 = GerenciarFornecedor.getFornecedores().get(posicao);
				
				List<Fornecedor> fornecedor = new ArrayList<>();
				
				fornecedor.add(fornecedor1);

				obsFornecedores = FXCollections.observableArrayList(fornecedor);

				fornecedores.setItems(obsFornecedores);

				carregandoColunasFornecedor();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inv�lido!!", "S� � aceito apenas n�meros", AlertType.WARNING);
		}
	}

	/**
	 * Fun��o do bot�o respons�vel pela busca de um fornecedor pelo id
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

		carregandoTableViewFornecedor();

	}


	/**
	 * Fun��o respons�vel por carregar a tableview dos Fornecedores
	 */
	public void carregandoTableViewFornecedor() {
		List<Fornecedor> listaFornecedores = GerenciarFornecedor.getFornecedores();
		obsFornecedores = FXCollections.observableArrayList(listaFornecedores);
		fornecedores.setItems(obsFornecedores);
		carregandoColunasFornecedor();

	} 
	
	/**
	 * Fun��o respons�vel por carregar a tableview dos Produtos
	 */
	public void carregandoTableViewProduto(List<Produto> listaProdutos) {
		
		obsProdutos = FXCollections.observableArrayList(listaProdutos);
		produtos.setItems(obsProdutos);
		carregandoColunasProduto();

	}

	/**
	 * Fun��o respon�vel por carregar Colunas dos Fornecedores
	 */
	public void carregandoColunasFornecedor() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("idFornecedor"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nomeFornecedor"));
		cnpjCol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
	
	}
	
	/**
	 * Fun��o respon�vel por carregar Colunas dos produtos
	 */
	public void carregandoColunasProduto() {
		
		idColProduto.setCellValueFactory(new PropertyValueFactory<Produto, String>("idProduto"));
		nomeColProduto.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeProduto"));
		
	}
	
	/**
	 * Fun��o do evento do bot�o atualizar, respons�vel por atualizar a tableView
	 * 
	 * @param Event
	 */
	@FXML
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableViewFornecedor();
	}

	/**
	 * Fun��o do bot�o ExcluirProduto respons�vel por abrir a tela para exclus�o
	 * de fornecedor
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtExcluir(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirFornecedorView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclus�o de Fornecedor");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show();

		carregandoColunasFornecedor();
	}

	/**
	 * Fun��o do bot�o AdicionarFornecedor respons�vel por abrir a tela para adi��o
	 * de fornecedor
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtAdicionarFornecedor(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/AdicionarFornecedorView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cadastro de Fornecedor");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btNovoFornecedor.getScene().getWindow());
		primaryStage.show();

		carregandoColunasFornecedor();
	}

	/**
	 * Fun��o do bot�o EditarFornecedor respons�vel por abrir a tela para edi��o de
	 * fornecedor
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtEditarFornecedor(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/EditarFornecedorView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Edi��o de Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btEditar.getScene().getWindow());
		primaryStage.show();

		carregandoColunasFornecedor();
	}
	
	
	/**
	 * Fun��o do bot�o Relat�rios que � respons�vel por abrir a tela de 
	 * relat�rios dos fornecedores
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtRelatorios(ActionEvent Event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/RelatoriosFornecedorView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Relat�rios Produto");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btRelatorios.getScene().getWindow());
		primaryStage.show();

		carregandoColunasFornecedor();
	} 
	
	
	/**
	 * Fun��o respons�vel pelo evento do bot�o de busca do 
	 * detalhe do fornecedor
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtBuscaDetalhe(ActionEvent Event) throws IOException{
		
		checarIdBuscaDetalhe();
		
	}
	
	/**
	 * Fun��o que checa a id da busca dos detalhes do fornecedor 
	 * e carrega os detalhes na aplica��o
	 */
	public void checarIdBuscaDetalhe() {
		if (Verificacoes.verificaConversaoNumeroInt(idBuscaDetalhe.getText())) {

			int id = Integer.parseInt(idBuscaDetalhe.getText());

			if (Verificacoes.verificaExistenciaIdFornecedor(id)) {

				int posicao;

				posicao = GerenciarFornecedor.buscaFornecedor(id, GerenciarFornecedor.getFornecedores(),
						GerenciarFornecedor.getFornecedores().size());
				
				Fornecedor fornecedor1 = GerenciarFornecedor.getFornecedores().get(posicao);
				
				List<Produto> produtos1 = ListasSecundarias.listaFornecedorProdutos(fornecedor1);

				obsProdutos = FXCollections.observableArrayList(produtos1);
				
				lbId.setText(String.valueOf(fornecedor1.getIdFornecedor()));
				lbNome.setText(fornecedor1.getNomeFornecedor());
				lbCnpj.setText(String.valueOf(fornecedor1.getCnpj()));
				lbEndereco.setText(fornecedor1.getEndereco());
				produtos.setItems(obsProdutos);

				carregandoTableViewProduto(produtos1);

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inv�lido!!", "S� � aceito apenas n�meros", AlertType.WARNING);
		}
	}
	
}
