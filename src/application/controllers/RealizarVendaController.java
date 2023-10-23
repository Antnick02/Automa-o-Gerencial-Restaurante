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
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarVenda;
import application.models.Prato;
import application.models.Relatorio;
import application.models.Venda;
import application.util.Alertas;
import application.util.ControleEstoque;
import application.util.ListasSecundarias;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RealizarVendaController implements Initializable {

	@FXML
	private Button btRealizar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField idVenda;

	/**
	 * Função responsável pelo botão realizar
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void onBtRealizar(ActionEvent event) {
		checarEntrada();
	}

	/**
	 * Função responsável por checar a entrada e fazer a realização de uma venda
	 */
	private void checarEntrada() {

		String entradaIdVenda = idVenda.getText();

		if (Verificacoes.verificaIdVenda(entradaIdVenda, GerenciarVenda.getVendasEmAberto())) {

			Venda venda;
			int idVenda1 = Integer.parseInt(entradaIdVenda);
			int posicao = GerenciarVenda.buscaVenda(idVenda1, GerenciarVenda.getVendasEmAberto(),
					GerenciarVenda.getVendasEmAberto().size());
			venda = GerenciarVenda.getVendasEmAberto().get(posicao);

			if (ControleEstoque.verificaReducaoEstoque(venda.getItens())) {

				List<Prato> pratos = ListasSecundarias.listaPratosVenda(venda.getItens());

				Relatorio.GerarRelatorioNota(venda, pratos, venda.getPrecoTotal());  
				Venda novaVenda = new Venda(venda.getData(), venda.getPrecoTotal(), venda.getItens(), venda.getFormaDePagamento(), venda.getIdCliente());
				GerenciarVenda.adicionarVenda(novaVenda);
				GerenciarVenda.excluirVendaEmAberto(idVenda1);
				
				Stage stage = (Stage) btRealizar.getScene().getWindow();
				stage.close();

			} else {
				Alertas.showAlert(null,
						"Não contém quantidade de produtos o suficiente no estoque para confecção dos pratos", null,
						AlertType.WARNING);
			}

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
