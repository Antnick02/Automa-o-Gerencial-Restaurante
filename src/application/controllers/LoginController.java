package application.controllers;

import application.util.Alertas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.Funcionario;
import application.models.GerenciarUsuario;
import application.models.Gerente;
import application.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	
	@FXML 
	private Button btLogin; 
	
	@FXML 
	private TextField login; 
	
	@FXML 
	private Button btSair; 
	
	@FXML 
	private PasswordField senha; 
	
	@FXML
	public void onBtLogin(ActionEvent event) throws IOException{
		checarSenha();
	}
	
	/**
	 * Fun��o que recebe um login e busca e retorna o id 
	 * do usu�rio de mesmo login na lista de usu�rios 
	 * caso n�o exista retorna -1
	 * @param login
	 * @return id usu�rio ou -1
	 */
	public static int buscaIdUsuarioLogin(String login) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios();
		int id = -1;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getLoginUsuario().equals(login)) {
		    	 id = usuario.getIdUsuario();
		     }
		}
		
		return id;
		
	}
	
	/**
	 * Fun��o que recebe um senha e busca e retorna o id 
	 * do usu�rio de mesmo senha na lista de usu�rios 
	 * caso n�o exista retorna -1
	 * @param senha
	 * @return id usu�rio ou -1
	 */
	public static int buscaIdUsuarioSenha(String senha) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios();
		int id = -1;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getSenhaUsuario().equals(senha)) {
		    	 id = usuario.getIdUsuario();
		     }
		}
		
		return id;
		
	}
	
	/**
	 * Fun��o que verifica se existe um mesmo login 
	 * na lista de usu�rios que foi passado,
	 * retornando true se existir e false se n�o existir
	 * @param login
	 * @return true ou false
	 */
	public boolean buscaLogin(String login) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios(); 
		boolean existe = false;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getLoginUsuario().equals(login)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	}
	
	/*
	 * Fun��o que recebe uma strig de senha, e retorna true
	 * se exisitr essa senha na lista de usu�rios e 
	 * false se n�o existir
	 */
	public static boolean buscaSenha(String senha) {
		
		List<Usuario>usuarios = new ArrayList<>();
		usuarios = GerenciarUsuario.getUsuarios(); 
		boolean existe = false;
		
		for(Usuario usuario : usuarios)
		{
		     if(usuario.getSenhaUsuario().equals(senha)) {
		    	 existe = true;
		     }
		}
		
		return existe;
	} 
	
	
	private void checarSenha() throws IOException{
		Main m = new Main(); 
		
		boolean verifLogin = buscaLogin(login.getText().toString()); 
		boolean verifSenha = buscaSenha(senha.getText().toString()); 
		
		if(verifLogin && verifSenha) {
			
			int id1 = buscaIdUsuarioLogin(login.getText().toString());
			int id2 = buscaIdUsuarioSenha(senha.getText().toString());
			
			if(id1 == id2) {
					
				System.out.println("Sucesso");
			
				m.mudarCena("/views/LogadoView.fxml");
			}
			else {
				Alertas.showAlert(null, "Login e senha n�o correspondem!!", null, AlertType.WARNING);
			}
		}
		else{
			Alertas.showAlert(null, "Login ou senha inexistentes!!", null, AlertType.WARNING);
		}
		
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Gerente gerente1 = new Gerente("joao", "123"); 
		Funcionario funcionario = new Funcionario("jorge", "321");
		Gerente gerente2 = new Gerente("joaquim", "12");  
		
		GerenciarUsuario.adicionarUsuario(gerente1); 
		GerenciarUsuario.adicionarUsuario(gerente2);
		GerenciarUsuario.adicionarUsuario(funcionario); 
		
		
	}
	
}
