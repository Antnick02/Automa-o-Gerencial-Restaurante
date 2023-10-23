package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.models.Cliente;
import application.models.GerenciarCliente;
import application.util.Alertas;
import application.util.Buscas;
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
public class CadastrarClienteController implements Initializable {

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField cpf;

	@FXML
	private TextField email;

	@FXML
	private TextField nome;

	@FXML
	private TextField telefone;

	/**
	 * Fun��o do evento de apertar o bot�o cadastrar
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException {
		checarEntradas();
	}

	/**
	 * Fun��o respons�vel por checar as entradas e cadstrar um novo cliente
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaCpf = cpf.getText();
		String entradaEmail = email.getText();
		String entradaTelefone = telefone.getText();

		if ((entradaNome != "") && (entradaCpf != "") && (entradaEmail != "") && (entradaTelefone != "")) {

			if (Buscas.buscaEmailCliente(entradaEmail)) {

				Alertas.showAlert(null, "Esse email j� est� sendo utilizado", null, AlertType.WARNING);

			} else {

				if (Verificacoes.verificaConversaoNumeroInt(entradaTelefone)) {
					
					int telefone1 = Integer.parseInt(entradaTelefone);
					
					if (!(Buscas.buscaTelefoneCliente(telefone1))) {

						if (Verificacoes.verificaConversaoNumeroInt(entradaCpf)) {

							int cpf1 = Integer.parseInt(entradaCpf); 

							if (!(Buscas.buscaCpfCliente(cpf1))) {
								
								
								Cliente cliente = new Cliente(entradaNome, cpf1, entradaEmail, telefone1);
								GerenciarCliente.adicionarCliente(cliente);

								Stage stage = (Stage) btCadastrar.getScene().getWindow();
								stage.close();

							} else {
								Alertas.showAlert(null, "Cpf inv�lido", "Este cpf j� est� sendo utilizado",
										AlertType.WARNING);
							}

						} else {
							Alertas.showAlert(null, "Cpf Inv�lido", "Por favor digite apenas n�meros inteiros",
									AlertType.WARNING);
						}
					} else {
						Alertas.showAlert(null, "Telefone Inv�lido", "Este telefone j� est� sendo utilizado",
								AlertType.WARNING);
					}
				} else {
					Alertas.showAlert(null, "Telefone Inv�lido", "Por favor digite apenas n�meros inteiros",
							AlertType.WARNING);
				}
			}
		} else {
			Alertas.showAlert(null, "Preencha todos os campos para cadastrar um Cliente", null, AlertType.WARNING);
		}
	}

	/**
	 * Fun��o Respons�vel por fechar a janela
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
