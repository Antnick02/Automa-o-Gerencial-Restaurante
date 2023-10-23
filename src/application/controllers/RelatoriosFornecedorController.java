package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.models.Fornecedor;
import application.models.GerenciarFornecedor;
import application.models.Relatorio;
import application.util.Alertas;
import application.util.Ordenacoes;
import application.util.Verificacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RelatoriosFornecedorController implements Initializable {

	@FXML
    private Button btGeral;

    @FXML
    private Button btProduto;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField idProduto;

	/**
	 * Função responsável pelo botão de voltar
	 */
	@FXML
	public void onBtVoltar() {
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Função responsável pelo eventto do botão geral 
	 * em que gera o relatório geral dos fornecedores
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtGeral(ActionEvent Event) throws IOException{
		Relatorio.GerarRelatorioFornecedores(GerenciarFornecedor.getFornecedores());
	}
	
	/**
	 * Função do evento do botão produto resposável 
	 * por gerar um relatório em pdf dos fornecedores por produto
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtProduto(ActionEvent Event) throws IOException{
		
		String entradaId = idProduto.getText(); 
		
		if(Verificacoes.verificaIdProduto(entradaId)){
			
			int id = Integer.parseInt(entradaId); 
			
			List<Fornecedor>fornecedores = Ordenacoes.OrdenarFornecedorProduto(id); 
			Integer tamanho = fornecedores.size();
			
			if(!(tamanho.equals(0))){
				
				Relatorio.GerarRelatorioFornecedores(fornecedores);
				
			}else {
				Alertas.showAlert(null, "Não existem fornecedores que fornecem este produto", null, AlertType.WARNING);
			}
			
		}else {
			Alertas.showAlert(null, "Id inválido", "Id inválido ou inexistente", AlertType.WARNING);
		}
		
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
