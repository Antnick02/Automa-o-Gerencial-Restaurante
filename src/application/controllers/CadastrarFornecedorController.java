package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.models.Fornecedor;
import application.models.GerenciarFornecedor;
import application.models.Produto;
import application.util.Alertas;
import application.util.Buscas;
import application.util.ListasSecundarias;
import application.util.Verificacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class CadastrarFornecedorController implements Initializable {

	@FXML
	private TableColumn<Produto, String> idCol;

	@FXML
	private TextField IdProduto;

	@FXML
	private TableColumn<Produto, String> nomeCol;

	@FXML
	private Button btProdutos;

	@FXML
	private Button adicionar;

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField cnpj;

	@FXML
	private TextField endereco;

	@FXML
	private TextField nome;

	@FXML
	private TableView<Produto> produtos;

	private ObservableList<Produto> obsProdutos;

	private List<Produto> produtos1;

	private List<Integer> produtosFornecedor;

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
	 * Fun��o respons�vel por checar as entradas e cadstrar um novo produto
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaCnpj = cnpj.getText();
		String entradaEndereco = endereco.getText();

		if (produtosFornecedor != null) {
			if ((entradaNome != "") && (entradaCnpj != "") && (entradaEndereco != "")) {

				if (Buscas.buscaNomeFornecedor(entradaNome)) {

					Alertas.showAlert(null, "Esse Nome j� est� sendo utilizado", null, AlertType.WARNING);

				} else {

					if (Verificacoes.verificaConversaoNumeroInt(entradaCnpj)) {

						int cnpj2 = Integer.parseInt(entradaCnpj);
						produtosFornecedor = ListasSecundarias.listaProdutosFornecedorId(produtos1);
						Fornecedor fornecedor = new Fornecedor(entradaNome, cnpj2, entradaEndereco, produtosFornecedor);
						GerenciarFornecedor.adicionarFornecedor(fornecedor);

						Stage stage = (Stage) btCadastrar.getScene().getWindow();
						stage.close();

					} else {
						Alertas.showAlert(null, "Cnpj Inv�lido", "Por favor digite apenas n�meros inteiros",
								AlertType.WARNING);
					}
				}
			} else {
				Alertas.showAlert(null, "Preencha todos os campos para cadastrar um fornecedor", null,
						AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "N�o � possivel cadastrar este fornecedor",
					"Para cadastrar o fornecedor � necess�rio a exist�ncia de pelo menos um produto para anexar a ele",
					AlertType.WARNING);
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
	 * Fun��o respon�vel por carregar Colunas dos produtos
	 */
	public void carregandoColunasProduto() {

		idCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("idProduto"));
		nomeCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nomeProduto"));

	}

	/**
	 * Fun��o respons�vel por carregar a tableview dos Produtos
	 */
	public void carregandoTableViewProduto(List<Produto> listaProdutos) {

		obsProdutos = FXCollections.observableArrayList(listaProdutos);
		produtos.setItems(obsProdutos);
		carregandoColunasProduto();

	}

	/*
	 * Fun��o respons�vel pelo evento do bot�o adicionar e atualiza a tableview dos
	 * produtos do fornecedor
	 */
	@FXML
	public void onBtAdicionar(ActionEvent Event) throws IOException {

		String entradaId = IdProduto.getText();
		produtosFornecedor = ListasSecundarias.listaProdutosFornecedorId(produtos1);

		if (produtosFornecedor != null) {
			if (Verificacoes.verificaAdicaoIdProdutoFornecedor(entradaId, produtosFornecedor)) {

				int idProdutoFornecedor = Integer.parseInt(entradaId);

				produtosFornecedor.add(idProdutoFornecedor);

				produtos1 = ListasSecundarias.listaProdutosFornecedor(produtosFornecedor);

				carregandoTableViewProduto(produtos1);

			} else {
				Alertas.showAlert(null, "Id inv�lido!!",
						"� inexistente, inv�lido ou o fornecedor j� fornece esse produto", AlertType.WARNING);
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
