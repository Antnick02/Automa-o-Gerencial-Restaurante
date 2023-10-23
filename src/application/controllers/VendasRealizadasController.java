package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Cliente;
import application.models.GerenciarCliente;
import application.models.GerenciarVenda;
import application.models.Prato;
import application.models.Venda;
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

public class VendasRealizadasController implements Initializable {

	@FXML
    private Button btAtualizar;

    @FXML
    private Button btBuscaDetalhe;

    @FXML
    private Button btBuscaVenda;


    @FXML
    private Button btExcluir;


    @FXML
    private Button btRelatorios;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField idBusca;

    @FXML
    private TextField idBuscaDetalhe;

    @FXML
    private TableColumn<Venda, String> idClienteCol;

    @FXML
    private TableColumn<Venda, String> idCol;

    @FXML
    private TableColumn<Prato, String> idColPrato;

    @FXML
    private Label lbFormaPgt;

    @FXML
    private Label lbId;
    
    @FXML 
    private Label lbData;

    @FXML
    private Label lbNomeCliente;

    @FXML
    private Label lbPrecoTotal;

    @FXML
    private TableColumn<Prato, String> nomeColPrato;

    @FXML
    private TableView<Prato> pratos;

    @FXML
    private TableColumn<Venda, String> precoCol;
    
    @FXML
    private TableColumn<Prato, String> precoColPrato;
    
    @FXML
    private TableView<Venda> vendas;

	private ObservableList<Prato>obsPratos;
	
	private ObservableList<Venda>obsVendas;

	/**
	 * Função do botão de voltar para tela anterior
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVoltar(ActionEvent Event) throws IOException {
		Main m = new Main();
		m.mudarCena("/views/VendasView.fxml");
	}

	/**
	 * Função responsável por checar o id de busca da Venda e modificar a table
	 * view pela pesquisa
	 * 
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {
		
			if (Verificacoes.verificaIdVenda(idBusca.getText(), GerenciarVenda.getVendas())) {
				
				int id = Integer.parseInt(idBusca.getText());
				int posicao;

				posicao = GerenciarVenda.buscaVenda(id, GerenciarVenda.getVendas(),
						GerenciarVenda.getVendas().size());
				
				Venda venda1 = GerenciarVenda.getVendas().get(posicao);
				
				List<Venda> venda = new ArrayList<>();
				
				venda.add(venda1);

				obsVendas = FXCollections.observableArrayList(venda);

				vendas.setItems(obsVendas);

				carregandoColunasVenda();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}

	/**
	 * Função do botão responsável pela busca de uma Venda pelo id
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

		carregandoTableViewVenda();

	}


	/**
	 * Função responsável por carregar a tableview das Vendas
	 */
	public void carregandoTableViewVenda() {
		List<Venda> listaVendas = GerenciarVenda.getVendas();
		obsVendas = FXCollections.observableArrayList(listaVendas);
		vendas.setItems(obsVendas);
		carregandoColunasVenda();

	} 
	
	/**
	 * Função responsável por carregar a tableview dos Pratos
	 */
	public void carregandoTableViewPrato(List<Prato> listaPratos) {
		
		obsPratos = FXCollections.observableArrayList(listaPratos);
		pratos.setItems(obsPratos);
		carregandoColunasPrato();

	}

	/**
	 * Função responável por carregar colunas venda
	 */
	public void carregandoColunasVenda() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Venda, String>("idVenda"));
		idClienteCol.setCellValueFactory(new PropertyValueFactory<Venda, String>("idCliente"));
		precoCol.setCellValueFactory(new PropertyValueFactory<Venda, String>("precoTotal"));
	
	}
	
	/**
	 * Função responável por carregar Colunas dos pratos
	 */
	public void carregandoColunasPrato() {
		
		idColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("idPrato"));
		nomeColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("nomePrato"));
		precoColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("precoPrato"));
		
	}
	
	/**
	 * Função do evento do botão atualizar, responsável por atualizar a tableView
	 * 
	 * @param Event
	 */
	@FXML
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableViewVenda();
	}

	/**
	 * Função do botão ExcluirProduto responsável por abrir a tela para exclusão
	 * de fornecedor
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtExcluir(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirVendaRealizadaView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclusão de Venda");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show();

		carregandoColunasVenda();
	}
	
	/**
	 * Função do botão Realizar que é responsável por abrir a tela para
	 * uma venda que está em aberto
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtRelatorios(ActionEvent Event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/RelatoriosVendaView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Realização de Venda");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btRelatorios.getScene().getWindow());
		primaryStage.show();

		carregandoColunasVenda();
	} 
	
	
	/**
	 * Função responsável pelo evento do botão de busca do 
	 * detalhe da Venda
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtBuscaDetalhe(ActionEvent Event) throws IOException{
		
		checarIdBuscaDetalhe();
		
	}
	
	/**
	 * Função que checa a id da busca dos detalhes da Venda
	 * e carrega os detalhes na aplicação
	 */
	public void checarIdBuscaDetalhe() {
		
		if (Verificacoes.verificaConversaoNumeroInt(idBuscaDetalhe.getText())) {

			int id = Integer.parseInt(idBuscaDetalhe.getText());

			if (Verificacoes.verificaExistenciaIdVenda(id, GerenciarVenda.getVendas())) {

				int posicao;

				posicao = GerenciarVenda.buscaVenda(id, GerenciarVenda.getVendas(),
						GerenciarVenda.getVendas().size());
				
				Venda venda1 = GerenciarVenda.getVendas().get(posicao);
				
				List<Prato> pratos1 = ListasSecundarias.listaPratoVenda(venda1);

				obsPratos = FXCollections.observableArrayList(pratos1);
				
				lbId.setText(String.valueOf(venda1.getIdVenda()));
				lbNomeCliente.setText(nomeCliente(venda1.getIdCliente()));
				lbFormaPgt.setText(venda1.getFormaDePagamento());
				lbPrecoTotal.setText(String.valueOf(venda1.getPrecoTotal()));
				lbData.setText(venda1.getData());
				pratos.setItems(obsPratos);

				carregandoTableViewPrato(pratos1);

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	} 
	
	/**
	 * Função que recebe o id de um cliente e retorna o seu nome 
	 * @param id
	 * @return
	 */
	public String nomeCliente(int id) {
		
		String nome = "";
		List<Cliente>clientes = GerenciarCliente.getClientes(); 
		
		for(Cliente cliente : clientes) {
			
			if(id == cliente.getIdCliente()) {
				nome = cliente.getNomeCliente();
			}
		}
		
		return nome;
	}
	
}
