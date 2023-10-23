package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VendasController implements Initializable{
	
	@FXML
    private Button Voltar;

    @FXML
    private Button btVendaAberto;

    @FXML
    private Button btVendaRealizada;
    
    /**
	 * Fun��o do bot�o de Vendas em aberto
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void onBtVendaAberto(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.mudarCena("/views/VendasEmAbertoView.fxml");
    }
    
    /**
	 * Fun��o do bot�o de vendas realizadas
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void onBtVendaRealizada(ActionEvent event) throws IOException{
    	Main m = new Main();
		m.mudarCena("/views/VendasRealizadasView.fxml");
    }
    
    /**
	 * Fun��o do bot�o de voltar para tela anterior
	 * 
	 * @param event
	 * @throws IOException
	 */
    @FXML
    void onBtVoltar(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.mudarCena("/views/LogadoView.fxml");
    }
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
