package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Cliente;
import application.models.GerenciarCliente;
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
public class ClientesController implements Initializable {

	@FXML
    private Button btAtualizar;

    @FXML
    private Button btBuscaCliente;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btNovoCliente;

    @FXML
    private Button btVoltar;

    @FXML
    private TableView<Cliente> clientes;

    @FXML
    private TableColumn<Cliente, String> cpfCol;

    @FXML
    private TableColumn<Cliente, String> emailCol;

    @FXML
    private TextField idBusca;

    @FXML
    private TableColumn<Cliente, String> idCol;

    @FXML
    private TableColumn<Cliente, String> nomeCol;

    @FXML
    private TableColumn<Cliente, String> telefoneCol;


	private ObservableList<Cliente>obsClientes;

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
	 * Função responsável por checar o id de busca do Cliente e modificar a table
	 * view pela pesquisa
	 * 
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {

			int id = Integer.parseInt(idBusca.getText());

			if (Verificacoes.verificaExistenciaIdCliente(id)) {

				int posicao;

				posicao = GerenciarCliente.buscaCliente(id, GerenciarCliente.getClientes(),
						GerenciarCliente.getClientes().size());
				
				
				List<Cliente> cliente = new ArrayList<>();
				
				cliente.add(GerenciarCliente.getClientes().get(posicao));

				obsClientes = FXCollections.observableArrayList(cliente);

				clientes.setItems(obsClientes);

				carregandoColunas();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}

	/**
	 * Função do botão responsável pela busca de um Cliente pelo id
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
		List<Cliente> listaClientes = GerenciarCliente.getClientes();
		obsClientes = FXCollections.observableArrayList(listaClientes);
		clientes.setItems(obsClientes);
		carregandoColunas();

	}

	/**
	 * Função responável por carregar Colunas
	 */
	public void carregandoColunas() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("idCliente"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nomeCliente"));
		cpfCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
		telefoneCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone")); 
		
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
	 * de usuário
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtExcluir(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirClienteView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclusão de Cliente");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}

	/**
	 * Função do botão AdicionarProduto responsável por trocar de tela para adição
	 * de usuário
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtAdicionarCliente(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/AdicionarClienteView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cadastro de Cliente");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btNovoCliente.getScene().getWindow());
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
	public void onBtEditarCliente(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/EditarClienteView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Edição de Cliente");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btEditar.getScene().getWindow());
		primaryStage.show();

		carregandoTableView();
	}
	
}
