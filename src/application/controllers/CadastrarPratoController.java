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
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 09/07/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
	 * Fun��o do evento de apertar o bot�o cadastrar
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException {
		checarEntradas();
	}

	/**
	 * Fun��o respons�vel por checar as entradas e cadastrar um novo produto
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

					Alertas.showAlert(null, "Esse Nome j� est� sendo utilizado", null, AlertType.WARNING);

				} else {

					if (Verificacoes.verificaConversaoNumeroFloat(entradaPreco)) {

						float preco2 = Integer.parseInt(entradaPreco);
						Prato prato = new Prato(entradaNome, entradaCategoria, entradaDescricao, ingredientesPrato,
								preco2);
						GerenciarPrato.adicionarPrato(prato);

						Stage stage = (Stage) btCadastrar.getScene().getWindow();
						stage.close();

					} else {
						Alertas.showAlert(null, "Pre�o Inv�lido", "Por favor digite n�meros nesse formato 0.00",
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
	 * Fun��o Respons�vel por fechar a janela
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
	 * Fun��o respon�vel por carregar Colunas dos ingredientes
	 */
	public void carregandoColunasIngrediente() {

		idCol.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("idProduto"));
		quantidadeCol.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("quantidade"));

	}

	/**
	 * Fun��o respons�vel por carregar a tableview dos Ingredientes
	 */
	public void carregandoTableViewIngrediente(List<Ingrediente> listaIngrediente) {

		obsIngredientes = FXCollections.observableArrayList(listaIngrediente);
		ingredientes.setItems(obsIngredientes);
		carregandoColunasIngrediente();

	}

	/*
	 * Fun��o respons�vel pelo evento do bot�o adicionar e atualiza a tableview dos
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
						Alertas.showAlert(null, "Quantidade inv�lida!!",
								"Por favor apenas digite n�meros no formato 0.00", AlertType.WARNING);
					}
				} else {
					Alertas.showAlert(null, "Id inv�lido!!", "� inexistente ou inv�lido", AlertType.WARNING);
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
							Alertas.showAlert(null, "Quantidade inv�lida!!",
									"Por favor apenas digite n�meros no formato 0.00", AlertType.WARNING);
						}
					} else {
						Alertas.showAlert(null, "Id inv�lido!!",
								"� inexistente, inv�lido ou o prato j� tem esse ingrediente", AlertType.WARNING);
					}
				}else {
					Alertas.showAlert(null, null, "Preencha todos os campos para cadastrar um ingrediente", AlertType.WARNING);
				}
			}
		} 


	/**
	 * Fun��o do evento do bot�o produtos em que abre uma nova tela com os produtos
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
