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
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
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
	 * Função do evento de apertar o botão cadastrar
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException {
		checarEntradas();
	}

	/**
	 * Função responsável por checar as entradas e cadstrar um novo cliente
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaCpf = cpf.getText();
		String entradaEmail = email.getText();
		String entradaTelefone = telefone.getText();

		if ((entradaNome != "") && (entradaCpf != "") && (entradaEmail != "") && (entradaTelefone != "")) {

			if (Buscas.buscaEmailCliente(entradaEmail)) {

				Alertas.showAlert(null, "Esse email já está sendo utilizado", null, AlertType.WARNING);

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
								Alertas.showAlert(null, "Cpf inválido", "Este cpf já está sendo utilizado",
										AlertType.WARNING);
							}

						} else {
							Alertas.showAlert(null, "Cpf Inválido", "Por favor digite apenas números inteiros",
									AlertType.WARNING);
						}
					} else {
						Alertas.showAlert(null, "Telefone Inválido", "Este telefone já está sendo utilizado",
								AlertType.WARNING);
					}
				} else {
					Alertas.showAlert(null, "Telefone Inválido", "Por favor digite apenas números inteiros",
							AlertType.WARNING);
				}
			}
		} else {
			Alertas.showAlert(null, "Preencha todos os campos para cadastrar um Cliente", null, AlertType.WARNING);
		}
	}

	/**
	 * Função Responsável por fechar a janela
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
