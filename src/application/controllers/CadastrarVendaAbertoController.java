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
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
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
	 * Função responsável por checar as entradas e cadstrar uma nova venda
	 */
	private void checarEntradas() {

		String entradaIdCliente = idCliente.getText();
		String entradaOpcao = opcao.getText();

		if (pratos1 != null) {
			if ((entradaIdCliente != "") && (entradaOpcao != "")) {

				if (!(Verificacoes.verificaIdCliente(entradaIdCliente))) {

					Alertas.showAlert(null, "Id inválido", "id inválido ou inexistente", AlertType.WARNING);

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
							forma = "Cartão crédito";

						} else if (entradaOpcao.equals("4")) {
							forma = "Cartão débito";

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
						Alertas.showAlert(null, "Opção inválida", null, AlertType.WARNING);
					}
				}
			} else {
				Alertas.showAlert(null, "Preencha todos os campos para cadastrar uma venda", null, AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Para cadastrar uma venda é necessário pelo menos um prato anexado a ela", null, AlertType.WARNING);
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
	 * Função responável por carregar Colunas dos pratos
	 */
	public void carregandoColunasPrato() {
		
		idColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("idPrato"));
		nomeColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("nomePrato"));
		precoColPrato.setCellValueFactory(new PropertyValueFactory<Prato, String>("precoPrato"));
		
	}

	/**
	 * Função responsável por carregar a tableview dos Pratos
	 */
	public void carregandoTableViewPrato(List<Prato> listaPratos) {
		
		obsPratos = FXCollections.observableArrayList(listaPratos);
		pratos.setItems(obsPratos);
		carregandoColunasPrato();

	}

	/*
	 * Função responsável pelo evento do botão adicionar e atualiza a tableview dos
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
				Alertas.showAlert(null, "Id inválido!!",
						"È inexistente, inválido ou não existe quantidade de produto suficiente para criação desse prato", AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Não existem é possivel cadastrar este fornecedor",
					"Para cadastrar o fornecedor é necessário a existência de pelo menos um produto para anexar a ele",
					AlertType.WARNING);
		}
	}

	/**
	 * Função do evento do botão pratos em que abre uma nova tela com os pratos
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
