package application.controllers;
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
	 * Função do evento de clicar no botão de Editar
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtEditar(ActionEvent Event) throws IOException {
		checarEntradas();
	}
	
	/**
	 * Função responsáveç por checar as entradas 
	 * e realizar a edição de um Usuário
	 */
	private void checarEntradas() {
		String entradaIdUsuario = idUsuario.getText();
		String entradaLogin = login.getText();
		String entradaSenha = senha.getText();
		String entradaTipo = tipo.getText();

		if (Verificacoes.verificaIdUsuario(entradaIdUsuario)) {
			 
			
			if ((entradaLogin != "") && (entradaSenha != "") && (entradaTipo != "")) {

				if (Buscas.buscaLogin(entradaLogin)) {

					Alertas.showAlert(null, "Esse Login já está sendo utilizado", null, AlertType.WARNING);

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
						Alertas.showAlert(null, "Tipo inválido", "Por favor digite apenas 1 ou 2", AlertType.WARNING);
					}
				}

			} else {
				Alertas.showAlert(null, "Preencha todos os campos para editar um cliente", null, AlertType.WARNING);
			}
		}else {
			Alertas.showAlert(null, "Id Inválido ou inexistente!!", null, AlertType.WARNING);
		}
	}
	
	/**
	 * Função responsável pelo botão de voltar
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
