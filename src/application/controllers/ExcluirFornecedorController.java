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
import java.net.URL;
import java.util.ResourceBundle;

import application.models.GerenciarFornecedor;
import application.util.Alertas;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExcluirFornecedorController implements Initializable {

	@FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField idFornecedor;

    /**
     * Função do evento do botão excluir
     * @param event
     */
	@FXML
	void onBtExcluir(ActionEvent event) {
		checarEntrada();
	}

	/**
	 * Função responsável por checar a entrada e realizar a exclusão de um Fornecedor
	 */
	private void checarEntrada() {

		String entradaIdFornecedor = idFornecedor.getText();

		if (Verificacoes.verificaIdFornecedor(entradaIdFornecedor)) {
			int id2 = Integer.parseInt(entradaIdFornecedor);
			GerenciarFornecedor.excluirFornecedor(id2);
			Stage stage = (Stage) btExcluir.getScene().getWindow();
			stage.close();
			
		} else {
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
