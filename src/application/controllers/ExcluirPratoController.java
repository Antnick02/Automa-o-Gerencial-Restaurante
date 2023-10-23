package application.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarPrato;
import application.models.GerenciarVenda;
import application.models.Prato;
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
Componente Curricular: MI algoritmos e programação 2
Concluido em: 09/07/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/ 
public class ExcluirPratoController implements Initializable {

	@FXML
	private Button btExcluir;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField idPrato;

	/**
	 * Função responsável pelo botão excluir
	 * 
	 * @param event
	 */
	@FXML
	void onBtExcluir(ActionEvent event) {
		checarEntrada();
	}

	/**
	 * Função responsável por checar a entrada e realizar a exclusão de um Cliente
	 */
	private void checarEntrada() {

		String entradaIdPrato = idPrato.getText();

		if (Verificacoes.verificaExclusaoIdPrato(entradaIdPrato, GerenciarVenda.getVendasEmAberto())) {
			if (Verificacoes.verificaExclusaoIdPrato(entradaIdPrato, GerenciarVenda.getVendas())) {
				int id2 = Integer.parseInt(entradaIdPrato);
				GerenciarPrato.excluirPrato(id2);
				Stage stage = (Stage) btExcluir.getScene().getWindow();
				stage.close();

			} else {
				Alertas.showAlert(null, "Este prato ainda está vinculado a alguma venda realizada!!", null, AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Id Inválido, inexistente ou este prato está vinculado a alguma venda em aberto", null, AlertType.WARNING);
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
