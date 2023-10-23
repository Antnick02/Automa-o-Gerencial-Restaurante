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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import application.models.GerenciarProduto;
import application.models.Produto;
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

public class EditarProdutoController implements Initializable {

	@FXML
	private Button btEditar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField idProduto;

	@FXML
	private TextField nome;

	@FXML
	private TextField preco;

	@FXML
	private TextField quantidade;

	/**
	 * Função do evento de apertar o botão editar
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtEditar(ActionEvent Event) throws IOException {
		checarEntradas();
	}

	/**
	 * Função responsável por checar as entradas e editar um produto
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaPreco = preco.getText();
		String entradaQuantidade = quantidade.getText();
		String entradaid = idProduto.getText();

		if (Verificacoes.verificaIdProduto(entradaid)) {

			if ((entradaNome != "") && (entradaPreco != "") && (entradaQuantidade != "")) {

				if (Buscas.buscaNomeProduto(entradaNome)) {

					Alertas.showAlert(null, "Esse Login já está sendo utilizado", null, AlertType.WARNING);

				} else {

					if (Verificacoes.verificaConversaoNumeroFloat(entradaPreco)) {

						if (Verificacoes.verificaConversaoNumeroDouble(entradaQuantidade)) {
							int posicao;
							int id1 = Integer.parseInt(entradaid);
							String validade;

							posicao = GerenciarProduto.buscaProduto(id1, GerenciarProduto.getProdutos(),
									GerenciarProduto.getProdutos().size());
							validade = GerenciarProduto.getProdutos().get(posicao).getValidade();
							float preco1 = Float.parseFloat(entradaPreco);
							double quantidade1 = Double.parseDouble(entradaQuantidade);

							Produto produto = new Produto(preco1, validade, entradaNome, quantidade1);
							produto.setIdProduto(id1);
							GerenciarProduto.editarProduto(produto);

							Stage stage = (Stage) btEditar.getScene().getWindow();
							stage.close();

						} else {
							Alertas.showAlert(null, "Quantidade Inválida", "Por favor digite apenas nesse formato 0.00",
									AlertType.WARNING);
						}

					} else {
						Alertas.showAlert(null, "Preço Inválido", "Por favor digite apenas nesse formato 0.00",
								AlertType.WARNING);
					}
				}
			} else {
				Alertas.showAlert(null, "Preencha todos os campos para editar um produto", null, AlertType.WARNING);
			}
		} else {
			Alertas.showAlert(null, "Id inválido ou inexistente", null, AlertType.WARNING);
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
