package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarPrato;
import application.models.Ingrediente;
import application.models.Prato;
import application.util.Alertas;
import application.util.Buscas;
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
public class CadastrarPratoController implements Initializable {

	@FXML
	private Button adicionar;

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btProdutos;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField categoria;

	@FXML
	private TextField descricao;

	@FXML
	private TableColumn<Ingrediente, String> idCol;

	@FXML
	private TextField idProduto;

	@FXML
	private TableView<Ingrediente> ingredientes;

	@FXML
	private TextField nome;

	@FXML
	private TableColumn<Ingrediente, String> quantidadeCol;

	@FXML
	private TextField preco;

	@FXML
	private TextField quantidade;

	private ObservableList<Ingrediente> obsIngredientes;

	private List<Ingrediente> ingredientesPrato = new ArrayList<>();

	/**
	 * Função do evento de apertar o botão cadastrar
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException {
		checarEntradas();
	}

	/**
	 * Função responsável por checar as entradas e cadastrar um novo produto
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaCategoria = categoria.getText();
		String entradaDescricao = descricao.getText();
		String entradaPreco = preco.getText();
		
		if ((entradaNome != "") && (entradaCategoria != "") && (entradaDescricao != "") && (entradaPreco != "")) {

			Integer tamanhoIngredientes = ingredientesPrato.size();

			if (!(tamanhoIngredientes.equals(0))) {

				if (Buscas.buscaNomePrato(entradaNome)) {

					Alertas.showAlert(null, "Esse Nome já está sendo utilizado", null, AlertType.WARNING);

				} else {

					if (Verificacoes.verificaConversaoNumeroFloat(entradaPreco)) {

						float preco2 = Integer.parseInt(entradaPreco);
						Prato prato = new Prato(entradaNome, entradaCategoria, entradaDescricao, ingredientesPrato,
								preco2);
						GerenciarPrato.adicionarPrato(prato);

						Stage stage = (Stage) btCadastrar.getScene().getWindow();
						stage.close();

					} else {
						Alertas.showAlert(null, "Preço Inválido", "Por favor digite números nesse formato 0.00",
								AlertType.WARNING);
					}
				}
			} else {
				Alertas.showAlert(null, "Adicione pelo menos um ingrediente para cadastrar prato", null,
						AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Preencha todos os campos para cadastrar um prato", null, AlertType.WARNING);
		}
	}

	/**
	 * Função Responsável por fechar a janela
	 */
	@FXML
	public void onBtVoltar() {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	/**
	 * Função responável por carregar Colunas dos ingredientes
	 */
	public void carregandoColunasIngrediente() {

		idCol.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("idProduto"));
		quantidadeCol.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("quantidade"));

	}

	/**
	 * Função responsável por carregar a tableview dos Ingredientes
	 */
	public void carregandoTableViewIngrediente(List<Ingrediente> listaIngrediente) {

		obsIngredientes = FXCollections.observableArrayList(listaIngrediente);
		ingredientes.setItems(obsIngredientes);
		carregandoColunasIngrediente();

	}

	/*
	 * Função responsável pelo evento do botão adicionar e atualiza a tableview dos
	 * ingredientes do prato
	 */
	@FXML
	public void onBtAdicionar(ActionEvent Event) throws IOException {

		String entradaId = idProduto.getText();
		String entradaQuantidade = quantidade.getText();

		if (ingredientesPrato == null) {

			if ((entradaId != "") && (entradaQuantidade != "")) {
				
				if (Verificacoes.verificaIdProduto(entradaId)) {
					
					int idProdutoFornecedor = Integer.parseInt(entradaId);
					
					if (Verificacoes.verificaConversaoNumeroDouble(entradaQuantidade)) {
						
						System.out.println("entrou2");
						Double quantidade1 = Double.parseDouble(entradaQuantidade);
						Ingrediente ingrediente = new Ingrediente(idProdutoFornecedor, quantidade1);

						ingredientesPrato.add(ingrediente);

						carregandoTableViewIngrediente(ingredientesPrato);

					} else {
						Alertas.showAlert(null, "Quantidade inválida!!",
								"Por favor apenas digite números no formato 0.00", AlertType.WARNING);
					}
				} else {
					Alertas.showAlert(null, "Id inválido!!", "È inexistente ou inválido", AlertType.WARNING);
				}
			}else {
				Alertas.showAlert(null, null, "Preencha todos os campos para cadastrar um ingrediente", AlertType.WARNING);
			}

			} else {
				
				if ((entradaId != "") && (entradaQuantidade != "")) {
					
					if (Verificacoes.verificaAdicaoIdProdutoIngrediente(entradaId, ingredientesPrato)) {
						int idProdutoFornecedor = Integer.parseInt(entradaId);
						if (Verificacoes.verificaConversaoNumeroDouble(entradaQuantidade)) {
							Double quantidade1 = Double.parseDouble(entradaQuantidade);
							Ingrediente ingrediente = new Ingrediente(idProdutoFornecedor, quantidade1);

							ingredientesPrato.add(ingrediente);

							carregandoTableViewIngrediente(ingredientesPrato);

						} else {
							Alertas.showAlert(null, "Quantidade inválida!!",
									"Por favor apenas digite números no formato 0.00", AlertType.WARNING);
						}
					} else {
						Alertas.showAlert(null, "Id inválido!!",
								"È inexistente, inválido ou o prato já tem esse ingrediente", AlertType.WARNING);
					}
				}else {
					Alertas.showAlert(null, null, "Preencha todos os campos para cadastrar um ingrediente", AlertType.WARNING);
				}
			}
		} 


	/**
	 * Função do evento do botão produtos em que abre uma nova tela com os produtos
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtProdutos(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/ProdutosVisuView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Produtos");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btProdutos.getScene().getWindow());
		primaryStage.show();
	}

}
