package application.controllers;

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
public class CadastrarProdutoController implements Initializable {

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btVoltar;

	@FXML
	private TextField nome;

	@FXML
	private TextField preco;

	@FXML
	private TextField quantidade;

	@FXML
	private TextField validade;
	
	/**
	 * Fun��o do evento de apertar o bot�o cadastrar
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtCadastrar(ActionEvent Event) throws IOException {
		checarEntradas();
	}
	
	/**
	 * Fun��o respons�vel por checar as entradas 
	 * e cadastrar um novo produto
	 */
	private void checarEntradas() {

		String entradaNome = nome.getText();
		String entradaPreco = preco.getText();
		String entradaValidade = validade.getText();
		String entradaQuantidade = quantidade.getText();

		if ((entradaNome != "") && (entradaPreco != "") && (entradaValidade != "") && (entradaQuantidade != "")) {

			if (Buscas.buscaNomeProduto(entradaNome)) {

				Alertas.showAlert(null, "Esse nome j� est� sendo utilizado", null, AlertType.WARNING);

			} else {

				if (Verificacoes.verificaConversaoNumeroFloat(entradaPreco)) {
					
					if(Verificacoes.verificaConversaoNumeroDouble(entradaQuantidade)) {
						
						if(Verificacoes.verificaConversaoNumeroInt(entradaValidade)){
							SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
							String validadeStr;
							Date validade = new Date(); 
							Calendar validade1 = Calendar.getInstance(); 
							validade1.setTime(validade); 
							int validade2 = Integer.parseInt(entradaValidade); 
							float preco1 = Float.parseFloat(entradaPreco); 
							double quantidade1 = Double.parseDouble(entradaQuantidade); 
							validade1.add(Calendar.DATE, validade2); 
							validade = validade1.getTime();
							validadeStr = s.format(validade);
							Produto produto = new Produto(preco1, validadeStr, entradaNome, quantidade1);
							GerenciarProduto.adicionarProduto(produto); 
							
							Stage stage = (Stage) btCadastrar.getScene().getWindow();
							stage.close();
							
							
						}else {
							Alertas.showAlert(null, "Validade Inv�lida", "Por favor digite apenas n�meros inteiros",AlertType.WARNING);
						}
						
					}else {
						Alertas.showAlert(null, "Quantidade Inv�lida", "Por favor digite apenas nesse formato 0.00",AlertType.WARNING);
					}

				} else {
					Alertas.showAlert(null, "Pre�o Inv�lido", "Por favor digite apenas nesse formato 0.00",AlertType.WARNING);
				}
			}
		} else {
			Alertas.showAlert(null, "Preencha todos os campos para cadastrar um produto", null, AlertType.WARNING);
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
