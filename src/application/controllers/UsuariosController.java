package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.models.GerenciarUsuario;
import application.models.Usuario;
import application.util.Alertas;
import application.util.Verificacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UsuariosController implements Initializable {

	@FXML
    private Button btBuscaUsuario;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btNovoUsuario;

    @FXML
    private Button btVoltar;
    
    @FXML 
    private Button btAtualizar;
    
    @FXML
    private TextField idBusca;

    @FXML
    private TableColumn<Usuario, Integer> idCol;

    @FXML
    private TableColumn<Usuario, String> loginCol;

    @FXML
    private TableView<Usuario> usuarios;


	
	private ObservableList<Usuario>obsUsuarios;

	/**
	 * Fun��o do bot�o de voltar para tela anterior
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void onBtVoltar(ActionEvent Event) throws IOException {
		Main m = new Main();
		m.mudarCena("/views/LogadoView.fxml");
	}

	/**
	 * Fun��o respons�vel por checar o id de busca do usu�rio 
	 * e modificar a table view pela pesquisa
	 * @throws IOException
	 */
	private void checarIdBusca() throws IOException {
		if (Verificacoes.verificaConversaoNumeroInt(idBusca.getText())) {

			int id = Integer.parseInt(idBusca.getText());

			if (Verificacoes.verificaExistenciaIdUsuario(id)) {

				int posicao;

				posicao = GerenciarUsuario.buscaUsuario(id, GerenciarUsuario.getUsuarios(),
						GerenciarUsuario.getUsuarios().size());
				List<Usuario> usuario = new ArrayList<>();
				usuario.add(GerenciarUsuario.getUsuarios().get(posicao));

				obsUsuarios = FXCollections.observableArrayList(usuario);
				
				usuarios.setItems(obsUsuarios);
				
				carregandoColunas();

			} else {
				Alertas.showAlert(null, "Id inexistente!!", null, AlertType.WARNING);
			}

		} else {
			Alertas.showAlert(null, "Id inv�lido!!", "S� � aceito apenas n�meros", AlertType.WARNING);
		}
	}

	/**
	 * Fun��o do bot�o respons�vel pela busca de um usu�rio pelo id
	 * 
	 * @param Event
	 * @throws IOException
	 */
	@FXML
	public void onBtBusca(ActionEvent Event) throws IOException {
		
		checarIdBusca();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		carregandoTableView(); 

	}

	
	/**
	 * Fun��o respons�vel por carregar a tableview
	 */
	public void carregandoTableView() {
		List<Usuario>listaUsuarios = GerenciarUsuario.getUsuarios();
		obsUsuarios = FXCollections.observableArrayList(listaUsuarios);
		usuarios.setItems(obsUsuarios); 
		carregandoColunas();
		
	} 
	
	/**
	 * Fun��o respon�vel por carregar Colunas
	 */
	public void carregandoColunas() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("idUsuario"));
		loginCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("loginUsuario"));
	}
	
	/**
	 * Fun��o do evento do bot�o atualizar 
	 * respons�vel por atualizar a tableView
	 * @param Event
	 */
	@FXML 
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableView();
	}
	
	/**
	 * Fun��o do bot�o ExcluirUsuario respons�vel 
	 * por trocar de tela para exclus�o de usu�rio 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtExcluir(ActionEvent Event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirUsuarioView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclus�o de Usu�rio");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}
	
	/**
	 * Fun��o do bot�o AdicionarUsuario respons�vel 
	 * por trocar de tela para adi��o de usu�rio 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtAdicionarUsuario(ActionEvent Event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/AdicionarUsuarioView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cadastro de Usu�rio");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btNovoUsuario.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}
	
	/**
	 * Fun��o do bot�o EditarUsuario respons�vel 
	 * por trocar de tela para edi��o de usu�rio 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtEditarUsuario(ActionEvent Event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/EditarUsuariosView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Edi��o de Usu�rio");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btEditar.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}

}
