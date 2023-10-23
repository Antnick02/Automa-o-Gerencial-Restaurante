package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
public class LogadoController implements Initializable{
	
	@FXML 
	private Button btUsuarios; 
	
	@FXML
	private Button btProdutos;
	
	@FXML
	private Button btClientes;
	
	@FXML
	private Button btFornecedores;
	
	@FXML
	private Button btPratos;
	
	@FXML
	private Button btVendas;
	
	@FXML 
	private Button btSair;
	
	/**
	 * Função do botão de Usuários
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtUsuarios(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/UsuariosView.fxml");
	}
	
	/**
	 * Função do botão de produtos
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtProdutos(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ProdutosView.fxml");
	}
	
	/**
	 * Função do botão de Vendas
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVendas(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/VendasView.fxml");
	}
	
	/**
	 * Função do botão de Fornecedores
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtFornecedores(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/FornecedoresView.fxml");
	}
	
	/**
	 * Função do botão de pratos
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtPratos(ActionEvent event) throws IOException{
		Main m = new Main(); 
		m.mudarCena("/views/PratosView.fxml");
	}
	
	/**
	 * Função do botão de Clientes
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtClientes(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ClientesView.fxml");
	}
	
	/**
	 * Função do botão de sair
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtSair(ActionEvent event) throws IOException{
		Main m = new Main(); 
		m.mudarCena("/views/LoginView.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	} 
	
}
