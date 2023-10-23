package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.models.Funcionario;
import application.models.GerenciarUsuario;
import application.models.Gerente;
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
Componente Curricular: MI algoritmos e programa��o 2
Concluido em: 09/07/2022
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
*/ 
public class CadastrarUsuarioController implements Initializable {

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField login;

	@FXML
	private PasswordField senha;

	@FXML
	private TextField tipo;

	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException{
		checarEntradas();
	}

	private void checarEntradas() {

		String entradaLogin = login.getText();
		String entradaSenha = senha.getText();
		String entradaTipo = tipo.getText();

		if ((entradaLogin != "") && (entradaSenha != "") && (entradaTipo != "")) {
			
			if (Buscas.buscaLogin(entradaLogin)) {
				
				Alertas.showAlert(null, "Esse Login j� est� sendo utilizado", null, AlertType.WARNING);
				
			} else {

				if ((entradaTipo.equals("1")) || (entradaTipo.equals("2"))) {

					if (entradaTipo.equals("1")) {

						Gerente gerente = new Gerente(entradaLogin, entradaSenha);
						GerenciarUsuario.adicionarUsuario(gerente); 
						Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
					    stage.close();

					} else if (entradaTipo.equals("2")) {

						Funcionario funcionario = new Funcionario(entradaLogin, entradaSenha);
						GerenciarUsuario.adicionarUsuario(funcionario);
						
						Stage stage = (Stage) btCadastrar.getScene().getWindow(); 
					    stage.close();

					}
				}else {
					Alertas.showAlert(null, "Tipo inv�lido", "Por favor digite apenas 1 ou 2", AlertType.WARNING);
				}
			}

		}else {
			Alertas.showAlert(null, "Preencha todos os campos para cadastrar um cliente", null, AlertType.WARNING);
		}

	}
	
	@FXML 
	public void onBtVoltar() {
		Stage stage = (Stage) btVoltar.getScene().getWindow(); 
	    stage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
