package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Fornecedor;
import application.models.GerenciarFornecedor;
import application.models.GerenciarPrato;
import application.models.Ingrediente;
import application.models.Prato;
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
public class PratoVisuController implements Initializable {
	
	@FXML
    private TableColumn<Ingrediente, String> quantidadeColProduto;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btBuscaDetalhe;

    @FXML
    private Button btBuscaPrato;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btNovoPrato;

    @FXML
    private Button btVoltar;

    @FXML
    private TableColumn<Prato, String> categoriaCol;

    @FXML
    private TextField idBusca;

    @FXML
    private TextField idBuscaDetalhe;

    @FXML
    private TableColumn<Prato, String> idCol;

    @FXML
    private TableColumn<Ingrediente, String> idColIdProduto;

    @FXML
    private TableView<Ingrediente> ingredientes;

    @FXML
    private Label lbCategoria;

    @FXML
    private Label lbDescricao;

    @FXML
    private Label lbId;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbPreco;

    @FXML
    private TableColumn<Prato, String> nomeCol;

    @FXML
    private TableView<Prato> pratos;

	private ObservableList<Ingrediente>obsIngredientes;
	
	private ObservableList<Prato>obsPratos;

	/**
	 * Função do botão de voltar para tela anterior
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVoltar(ActionEvent Event) throws IOException {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
		
	}

	/**
	 * Função responsável por checar o id de busca do Prato e modificar a table
	 * view pela pesquisa
	 * 
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {
			
			

			if (Verificacoes.verificaIdPrato(idBusca.getText())) {
				
				int id = Integer.parseInt(idBusca.getText());
				int posicao;

				posicao = GerenciarPrato.buscaPrato(id, GerenciarPrato.getPratos(),
						GerenciarPrato.getPratos().size());
				
				Prato prato1 = GerenciarPrato.getPratos().get(posicao);
				
				List<Prato> prato = new ArrayList<>();
				
				
				prato.add(prato1);

				obsPratos = FXCollections.observableArrayList(prato);

				pratos.setItems(obsPratos);

				carregandoColunasPrato();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}

	/**
	 * Função do botão responsável pela busca de 
	 * um Prato pelo id
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtBusca(ActionEvent Event) throws IOException {

		checarIdBusca();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		carregandoTableViewPrato();

	}


	/**
	 * Função responsável por carregar a tableview dos Pratos
	 */
	public void carregandoTableViewPrato() {
		
		List<Prato> listaPratos = GerenciarPrato.getPratos();
		obsPratos = FXCollections.observableArrayList(listaPratos);
		pratos.setItems(obsPratos);
		carregandoColunasPrato();

	} 
	
	/**
	 * Função responsável por carregar a tableview dos Produtos
	 */
	public void carregandoTableViewIngrediente(List<Ingrediente> listaIngrediente) {
		
		obsIngredientes = FXCollections.observableArrayList(listaIngrediente);
		ingredientes.setItems(obsIngredientes);
		carregandoColunasIngrediente();

	}

	/**
	 * Função responável por carregar Colunas dos pratos
	 */
	public void carregandoColunasPrato() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Prato, String>("idPrato"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Prato, String>("nomePrato"));
		categoriaCol.setCellValueFactory(new PropertyValueFactory<Prato, String>("categoria"));
	
	}
	
	/**
	 * Função responável por carregar Colunas dos ingredientes
	 */
	public void carregandoColunasIngrediente() {
		
		idColIdProduto.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("idProduto"));
		quantidadeColProduto.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("quantidade"));
		
	}
		
	
	/**
	 * Função responsável pelo evento do botão de busca do 
	 * detalhe do prato
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtBuscaDetalhe(ActionEvent Event) throws IOException{
		
		checarIdBuscaDetalhe();
		
	}
	
	/**
	 * Função que checa a id da busca dos detalhes do prato
	 * e carrega os detalhes na aplicação
	 */
	public void checarIdBuscaDetalhe() {
		
		if (Verificacoes.verificaConversaoNumeroInt(idBuscaDetalhe.getText())) {

			int id = Integer.parseInt(idBuscaDetalhe.getText());

			if (Verificacoes.verificaExistenciaIdPrato(id)) {

				int posicao;

				posicao = GerenciarPrato.buscaPrato(id, GerenciarPrato.getPratos(),
						GerenciarPrato.getPratos().size());
				
				Prato prato1 = GerenciarPrato.getPratos().get(posicao);
				
				List<Ingrediente> ingrediente1 = prato1.getComposicao();

				obsIngredientes = FXCollections.observableArrayList(ingrediente1);
				
				lbId.setText(String.valueOf(prato1.getIdPrato()));
				lbNome.setText(prato1.getNomePrato());
				lbCategoria.setText(prato1.getCategoria());
				lbDescricao.setText(prato1.getDescricao()); 
				lbPreco.setText(String.valueOf(prato1.getPrecoPrato()));
				ingredientes.setItems(obsIngredientes);

				carregandoTableViewIngrediente(ingrediente1);

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}
	
}
