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
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 09/07/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
	 * Fun��o do bot�o de Usu�rios
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtUsuarios(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/UsuariosView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de produtos
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtProdutos(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ProdutosView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de Vendas
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVendas(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/VendasView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de Fornecedores
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtFornecedores(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/FornecedoresView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de pratos
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtPratos(ActionEvent event) throws IOException{
		Main m = new Main(); 
		m.mudarCena("/views/PratosView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de Clientes
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtClientes(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ClientesView.fxml");
	}
	
	/**
	 * Fun��o do bot�o de sair
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
