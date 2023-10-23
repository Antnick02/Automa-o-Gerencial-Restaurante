package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

import application.models.GerenciarProduto;
import application.models.GerenciarVenda;
import application.models.Relatorio;
import application.models.Venda;
import application.util.Alertas;
import application.util.Calcula;
import application.util.Ordenacoes;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RelatoriosVendaController implements Initializable {
	
	@FXML 
	private TextField idPrato;
	
	@FXML
    private Button btGeral;

    @FXML
    private Button btPrato;

    @FXML
    private Button btData;

    @FXML
    private Button btVoltar;

	/**
	 * Função responsável pelo botão de voltar
	 */
	@FXML
	public void onBtVoltar() {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Função do botão geral em que 
	 * gera um relatório geral de vendas realizadas
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtGeral(ActionEvent Event) throws IOException{
		float precoTotalVendas = Calcula.calculaPrecoVendas(GerenciarVenda.getVendas()); 
		int quantidadePratosVendas = Calcula.calculaPratosVendas(GerenciarVenda.getVendas());
		Relatorio.GerarRelatorioVendas(GerenciarVenda.getVendas(), quantidadePratosVendas, precoTotalVendas);
	}
	
	/**
	 * Função do botão prato em que
	 * gera um relatório de vendas a partir do tipo de prato
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtPrato(ActionEvent Event) throws IOException{
		String entradaId = idPrato.getText(); 
		
		if(Verificacoes.verificaIdPrato(entradaId)){
			
			int id = Integer.parseInt(entradaId); 
			
			List<Venda> vendas = Ordenacoes.OrdenarVendaPrato(id); 
			Integer tamanho = vendas.size();
			
			if(!(tamanho.equals(0))){
				float precoTotalVendas = Calcula.calculaPrecoVendas(vendas); 
				int quantidadePratosVendas = Calcula.calculaPratosVendas(vendas);
				Relatorio.GerarRelatorioVendas(vendas, quantidadePratosVendas, precoTotalVendas);
				
			}else {
				Alertas.showAlert(null, "Não existem vendas que possuem este prato", null, AlertType.WARNING);
			}
			
		}else {
			Alertas.showAlert(null, "Id inválido", "Id inválido ou inexistente", AlertType.WARNING);
		}
	}
	
	/**
	 * Função do botão data em que gera 
	 * um relatório de vendas a partir da menor data
	 * @param Event
	 * @throws IOException
	 * @throws ParseException
	 */
	@FXML 
	public void onBtData(ActionEvent Event) throws IOException, ParseException{
		List<Venda> vendas = Ordenacoes.OrdenarVendasData(GerenciarVenda.getVendas());
		float precoTotalVendas = Calcula.calculaPrecoVendas(vendas); 
		int quantidadePratosVendas = Calcula.calculaPratosVendas(vendas);
		Relatorio.GerarRelatorioVendas(vendas, quantidadePratosVendas, precoTotalVendas);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
