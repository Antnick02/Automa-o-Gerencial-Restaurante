package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
	
	
	@FXML
	public void onBtUsuarios(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/UsuariosView.fxml");
	}
	
	@FXML
	public void onBtProdutos(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ProdutosView.fxml");
	}
	
	@FXML
	public void onBtVendas(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/VendasView.fxml");
	}
	
	@FXML
	public void onBtFornecedores(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/FornecedoresView.fxml");
	}
	
	@FXML
	public void onBtPratos(ActionEvent event) throws IOException{
		Main m = new Main(); 
		m.mudarCena("/views/PratosView.fxml");
	}
	
	@FXML
	public void onBtClientes(ActionEvent event) throws IOException {
		Main m = new Main(); 
		m.mudarCena("/views/ClientesView.fxml");
	}
	
	@FXML
	public void onBtSair(ActionEvent event) throws IOException{
		Main m = new Main(); 
		m.mudarCena("/views/LoginView.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	} 
	
}
