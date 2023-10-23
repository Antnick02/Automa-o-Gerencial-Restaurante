package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Cliente;
import application.models.Fornecedor;
import application.models.Funcionario;
import application.models.GerenciarCliente;
import application.models.GerenciarFornecedor;
import application.models.GerenciarPrato;
import application.models.GerenciarProduto;
import application.models.GerenciarUsuario;
import application.models.GerenciarVenda;
import application.models.Gerente;
import application.models.Ingrediente;
import application.models.Prato;
import application.models.Produto;
import application.models.Venda;
import application.util.Alertas;
import application.util.Buscas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
public class LoginController implements Initializable {

	@FXML
	private Button btLogin;

	@FXML
	private TextField login;

	@FXML
	private Button btSair;

	@FXML
	private PasswordField senha;

	/**
	 * Função do botão responsável pelo login
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtLogin(ActionEvent event) throws IOException {
		checarSenha();
	}

	/**
	 * Função responsável pelo usuário sair do programa
	 */
	@FXML
	public void onBtSair() {
		Stage stage = (Stage) btSair.getScene().getWindow();
		stage.close();
	}

	/**
	 * Função respoável por verificar o login e senha do usuário
	 * 
	 * @throws IOException
	 */
	private void checarSenha() throws IOException {
		Main m = new Main();

		boolean verifLogin = Buscas.buscaLogin(login.getText().toString());
		boolean verifSenha = Buscas.buscaSenha(senha.getText().toString());

		if (verifLogin && verifSenha) {

			int id1 = Buscas.buscaIdUsuarioLogin(login.getText().toString());
			int id2 = Buscas.buscaIdUsuarioSenha(senha.getText().toString());

			if (id1 == id2) {

				m.mudarCena("/views/LogadoView.fxml");
			} else {
				Alertas.showAlert(null, "Login e senha não correspondem!!", null, AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Login ou senha inexistentes!!", null, AlertType.WARNING);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		carregarUsuarios();
		carregarProdutos();
		carregarFornecedores();
		carregarClientes(); 
		carregarPratos();
		carregarVendas();
		
	}

	/**
	 * Função responsável por popular Usuarios
	 */
	public void carregarUsuarios() {

		Gerente gerente1 = new Gerente("joao", "123");
		Funcionario funcionario = new Funcionario("jorge", "321");
		Gerente gerente2 = new Gerente("joaquim", "12");

		GerenciarUsuario.adicionarUsuario(gerente1);
		GerenciarUsuario.adicionarUsuario(gerente2);
		GerenciarUsuario.adicionarUsuario(funcionario);

	}

	/**
	 * Função responsável por popular Produtos
	 */
	public void carregarProdutos() {
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);

		String data132;
		Calendar data14 = Calendar.getInstance();
		data14.add(Calendar.DATE, 1);
		Date data3 = data14.getTime();
		data132 = s.format(data3);

		Produto produto1 = new Produto((float) 10.50, data123, "leite", 7000);
		Produto produto2 = new Produto((float) 5.20, data321, "Saco de bala", 7000);
		Produto produto3 = new Produto((float) 7.30, data132, "macarrao", 10000);

		GerenciarProduto.adicionarProduto(produto1);
		GerenciarProduto.adicionarProduto(produto2);
		GerenciarProduto.adicionarProduto(produto3);
	}

	/**
	 * Função que popula fornecedores
	 */
	public static void carregarFornecedores() {
		List<Integer> produtos1 = new ArrayList<>();

		produtos1.add(1);

		List<Integer> produtos2 = new ArrayList<>();

		produtos2.add(1);
		produtos2.add(2);

		Fornecedor fornecedor1 = new Fornecedor("Casas Bahia", 123, "Rua 1", produtos1);
		Fornecedor fornecedor2 = new Fornecedor("Palmeira", 321, "Rua 2", produtos2);

		GerenciarFornecedor.adicionarFornecedor(fornecedor1);
		GerenciarFornecedor.adicionarFornecedor(fornecedor2);
	}

	/**
	 * Função que popula Clientes
	 */
	public static void carregarClientes() {

		Cliente cliente1 = new Cliente("jose", 123, "@we", 123);
		Cliente cliente2 = new Cliente("jose", 321, "@yt", 456);
		Cliente cliente3 = new Cliente("joao", 456, "@op", 789);

		GerenciarCliente.adicionarCliente(cliente1);
		GerenciarCliente.adicionarCliente(cliente2);
		GerenciarCliente.adicionarCliente(cliente3);

	}

	/**
	 * Função que popula pratos
	 */
	public static void carregarPratos() {
		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Ingrediente> ingredientes1 = new ArrayList<>();

		Ingrediente ingrediente1 = new Ingrediente(0, 400);
		Ingrediente ingrediente2 = new Ingrediente(1, 200);

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);

		ingredientes1.add(ingrediente2);

		Prato prato = new Prato("macarronada", "massas", "macarrao e carne", ingredientes, (float) 20.0);
		Prato prato2 = new Prato("Feijoada", "almoco", "feijao e carne", ingredientes1, (float) 25.0);

		GerenciarPrato.adicionarPrato(prato);
		GerenciarPrato.adicionarPrato(prato2);
	} 
	
	/**
	 * Função que popula vendas
	 */
	public static void carregarVendas() {
		String data123;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data12 = Calendar.getInstance();
		data12.add(Calendar.DATE, 4);
		Date data1 = data12.getTime();
		data123 = s.format(data1);

		String data321;
		Calendar data13 = Calendar.getInstance();
		Date data2 = data13.getTime();
		data321 = s.format(data2);

		String data132;
		Calendar data14 = Calendar.getInstance();
		data14.add(Calendar.DATE, 1);
		Date data3 = data14.getTime();
		data132 = s.format(data3); 
		
		List<Integer>itens = new ArrayList<>(); 
		List<Integer>itens1 = new ArrayList<>();
		
		itens.add(0);
		itens.add(1);
		
		itens1.add(1);
		
		Venda venda1 = new Venda(data132, (float)45, itens, "Dinheiro", 1);
		Venda venda2 = new Venda(data321, (float)25, itens1, "Pix", 2); 
		
		GerenciarVenda.adicionarVendaEmAberto(venda1);
		GerenciarVenda.adicionarVendaEmAberto(venda2);
	}

}
