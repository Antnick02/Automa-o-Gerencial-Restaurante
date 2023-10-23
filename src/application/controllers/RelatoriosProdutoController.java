package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import application.models.GerenciarProduto;
import application.models.Relatorio;
import application.util.Ordenacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RelatoriosProdutoController implements Initializable {

	@FXML
    private Button btGeral;

    @FXML
    private Button btQuantidade;

    @FXML
    private Button btVencimento;

    @FXML
    private Button btVoltar;

	/**
	 * Fun��o respons�vel pelo bot�o de voltar
	 */
	@FXML
	public void onBtVoltar() {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Fun��o respons�vel pelo bot�o geral 
	 * em que gera o relat�rio geral de produtos
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtGeral(ActionEvent Event) throws IOException{
		Relatorio.GerarRelatorioProdutos(GerenciarProduto.getProdutos());
	}
	
	/**
	 * Fun��o respons�vel pelo bot�o quantidade 
	 * em que gera um relat�rio de produtos por quantidade
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtQuantidade(ActionEvent Event) throws IOException{
		Relatorio.GerarRelatorioProdutos(Ordenacoes.OrdenarProdutosQuantidade(GerenciarProduto.getProdutos()));
	}
	
	/**
	 * Fun��o do bot�o vencimento em que gera 
	 * um relat�rio de produtos a partir do vencimento
	 * @param Event
	 * @throws IOException
	 * @throws ParseException
	 */
	@FXML 
	public void onBtVencimento(ActionEvent Event) throws IOException, ParseException{
		Relatorio.GerarRelatorioProdutos(Ordenacoes.OrdenarProdutosVencimento(GerenciarProduto.getProdutos()));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
