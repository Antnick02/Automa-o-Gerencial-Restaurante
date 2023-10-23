package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarVenda;
import application.models.Prato;
import application.models.Venda;
import application.util.Alertas;
import application.util.Calcula;
import application.util.ControleEstoque;
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
public class CadastrarVendaAbertoController implements Initializable {

	@FXML
	private TextField IdPrato;

	@FXML
	private Button adicionar;

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btPratos;

	@FXML
	private Button btVoltar;

	@FXML
	private TableColumn<Prato, String> idColPrato;

	@FXML
	private TextField idCliente;

	@FXML
	private TableColumn<Prato, String> nomeColPrato;

	@FXML
	private TextField opcao;

	@FXML
	private TableView<Prato> pratos;

	@FXML
	private TableColumn<Prato, String> precoColPrato;

	private ObservableList<Prato> obsPratos;

	private List<Prato> pratos1;

	private List<Integer> pratosVenda;

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
	 * Fun��o respons�vel por checar as entradas e cadstrar uma nova venda
	 */
	private void checarEntradas() {

		String entradaIdCliente = idCliente.getText();
		String entradaOpcao = opcao.getText();

		if (pratos1 != null) {
			if ((entradaIdCliente != "") && (entradaOpcao != "")) {

				if (!(Verificacoes.verificaIdCliente(entradaIdCliente))) {

					Alertas.showAlert(null, "Id inv�lido", "id inv�lido ou inexistente", AlertType.WARNING);

				} else {
					int idCliente1 = Integer.parseInt(entradaIdCliente);

					if (entradaOpcao.equals("1") || entradaOpcao.equals("2") || entradaOpcao.equals("3")
							|| entradaOpcao.equals("4")) {
						String forma = null;
						float precoTotal;

						if (entradaOpcao.equals("1")) {
							forma = "Dinheiro";

						} else if (entradaOpcao.equals("2")) {
							forma = "Pix";

						} else if (entradaOpcao.equals("3")) {
							forma = "Cart�o cr�dito";

						} else if (entradaOpcao.equals("4")) {
							forma = "Cart�o d�bito";

						}

						pratosVenda = ListasSecundarias.listaVendaPratosId(pratos1);
						precoTotal = Calcula.calculaPrecoTotal(pratosVenda);
						SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
						String data321;
						Calendar data13 = Calendar.getInstance();
						Date data2 = data13.getTime();
						data321 = s.format(data2);

						Venda venda = new Venda(data321, precoTotal, pratosVenda, forma, idCliente1);
						GerenciarVenda.adicionarVendaEmAberto(venda);

						Stage stage = (Stage) btCadastrar.getScene().getWindow();
						stage.close();

					} else {
						Alertas.showAlert(null, "Op��o inv�lida", null, AlertType.WARNING);
					}
				}
			} else {
				Alertas.showAlert(null, "Preencha todos os campos para cadastrar uma venda", null, AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Para cadastrar uma venda � necess�rio pelo menos um prato anexado a ela", null, AlertType.WARNING);
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
	 * Fun��o respon�vel por carregar Colunas dos pratos
	 */
	public void carregandoColunasPrato() {
		
		idColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("idPrato"));
		nomeColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("nomePrato"));
		precoColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("precoPrato"));
		
	}

	/**
	 * Fun��o respons�vel por carregar a tableview dos Pratos
	 */
	public void carregandoTableViewPrato(List<Prato> listaPratos) {
		
		obsPratos = FXCollections.observableArrayList(listaPratos);
		pratos.setItems(obsPratos);
		carregandoColunasPrato();

	}

	/*
	 * Fun��o respons�vel pelo evento do bot�o adicionar e atualiza a tableview dos
	 * pratos da venda
	 */
	@FXML
	public void onBtAdicionar(ActionEvent Event) throws IOException {

		String entradaId = IdPrato.getText();
		pratosVenda = ListasSecundarias.listaVendaPratosId(pratos1);

		if (pratosVenda != null) {
			if (Verificacoes.verificaAdicaoIdItensVenda(entradaId)) {

				int idPratoVenda = Integer.parseInt(entradaId); 

				pratosVenda.add(idPratoVenda);
				
				pratos1 = ListasSecundarias.listaPratosVenda(pratosVenda);

				carregandoTableViewPrato(pratos1);

			} else {
				Alertas.showAlert(null, "Id inv�lido!!",
						"� inexistente, inv�lido ou n�o existe quantidade de produto suficiente para cria��o desse prato", AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "N�o existem � possivel cadastrar este fornecedor",
					"Para cadastrar o fornecedor � necess�rio a exist�ncia de pelo menos um produto para anexar a ele",
					AlertType.WARNING);
		}
	}

	/**
	 * Fun��o do evento do bot�o pratos em que abre uma nova tela com os pratos
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtPratos(ActionEvent Event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/views/PratosVisuView.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Produtos");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btPratos.getScene().getWindow());
		primaryStage.show();
	}

	

}
