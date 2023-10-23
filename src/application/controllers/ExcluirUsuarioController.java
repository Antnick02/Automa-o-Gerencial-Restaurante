package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.models.GerenciarUsuario;
import application.util.Alertas;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
public class ExcluirUsuarioController implements Initializable {

	@FXML
	private Button btExcluir;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField idUsuario;
	
	/**
	 * Fun��o respons�vel pelo evento do bot�o excluir
	 * @param event
	 */
	@FXML
	void onBtExcluir(ActionEvent event) {
		checarEntrada();
	}

	/**
	 * Fun��o respons�vel por checar a entrada e realizar a exclus�o de um Usu�rio
	 */
	private void checarEntrada() {

		String entradaIdUsuario = idUsuario.getText();

		if (Verificacoes.verificaIdUsuario(entradaIdUsuario)) {
			int id2 = Integer.parseInt(entradaIdUsuario);
			GerenciarUsuario.excluirUsuario(id2);
			Stage stage = (Stage) btExcluir.getScene().getWindow();
			stage.close();
			
		} else {
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
