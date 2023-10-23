package application.controllers;
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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.models.Funcionario;
import application.models.GerenciarUsuario;
import application.models.Gerente;
import application.util.Alertas;
import application.util.Buscas;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarUsuarioController implements Initializable {

	@FXML
	private Button btEditar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField idUsuario;

	@FXML
	private TextField login;

	@FXML
	private PasswordField senha;

	@FXML
	private TextField tipo;
	
	/**
	 * Fun��o do evento de clicar no bot�o de Editar
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtEditar(ActionEvent Event) throws IOException {
		checarEntradas();
	}
	
	/**
	 * Fun��o respons�ve� por checar as entradas 
	 * e realizar a edi��o de um Usu�rio
	 */
	private void checarEntradas() {
		String entradaIdUsuario = idUsuario.getText();
		String entradaLogin = login.getText();
		String entradaSenha = senha.getText();
		String entradaTipo = tipo.getText();

		if (Verificacoes.verificaIdUsuario(entradaIdUsuario)) {
			 
			
			if ((entradaLogin != "") && (entradaSenha != "") && (entradaTipo != "")) {

				if (Buscas.buscaLogin(entradaLogin)) {

					Alertas.showAlert(null, "Esse Login j� est� sendo utilizado", null, AlertType.WARNING);

				} else {

					if ((entradaTipo.equals("1")) || (entradaTipo.equals("2"))) {
						int id2 = Integer.parseInt(entradaIdUsuario);

						if (entradaTipo.equals("1")) {

							Gerente gerente = new Gerente(entradaLogin, entradaSenha);
							gerente.setIdUsuario(id2);
							GerenciarUsuario.editarUsuario(gerente);
							
							Stage stage = (Stage) btEditar.getScene().getWindow();
							stage.close();

						} else if (entradaTipo.equals("2")) {

							Funcionario funcionario = new Funcionario(entradaLogin, entradaSenha);
							funcionario.setIdUsuario(id2);
							GerenciarUsuario.editarUsuario(funcionario);

							Stage stage = (Stage) btEditar.getScene().getWindow();
							stage.close();

						}
					} else {
						Alertas.showAlert(null, "Tipo inv�lido", "Por favor digite apenas 1 ou 2", AlertType.WARNING);
					}
				}

			} else {
				Alertas.showAlert(null, "Preencha todos os campos para editar um cliente", null, AlertType.WARNING);
			}
		}else {
			Alertas.showAlert(null, "Id Inv�lido ou inexistente!!", null, AlertType.WARNING);
		}
	}
	
	/**
	 * Fun��o respons�vel pelo bot�o de voltar
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

}
