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
	 * Função do botão de voltar para tela anterior
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
	 * Função responsável por checar o id de busca do usuário 
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
			Alertas.showAlert(null, "Id inválido!!", "Só é aceito apenas números", AlertType.WARNING);
		}
	}

	/**
	 * Função do botão responsável pela busca de um usuário pelo id
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
	 * Função responsável por carregar a tableview
	 */
	public void carregandoTableView() {
		List<Usuario>listaUsuarios = GerenciarUsuario.getUsuarios();
		obsUsuarios = FXCollections.observableArrayList(listaUsuarios);
		usuarios.setItems(obsUsuarios); 
		carregandoColunas();
		
	} 
	
	/**
	 * Função responável por carregar Colunas
	 */
	public void carregandoColunas() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("idUsuario"));
		loginCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("loginUsuario"));
	}
	
	/**
	 * Função do evento do botão atualizar 
	 * responsável por atualizar a tableView
	 * @param Event
	 */
	@FXML 
	public void onBtAtualizar(ActionEvent Event) {
		carregandoTableView();
	}
	
	/**
	 * Função do botão ExcluirUsuario responsável 
	 * por trocar de tela para exclusão de usuário 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtExcluir(ActionEvent Event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/ExcluirUsuarioView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exclusão de Usuário");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btExcluir.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}
	
	/**
	 * Função do botão AdicionarUsuario responsável 
	 * por trocar de tela para adição de usuário 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtAdicionarUsuario(ActionEvent Event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/AdicionarUsuarioView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cadastro de Usuário");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btNovoUsuario.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}
	
	/**
	 * Função do botão EditarUsuario responsável 
	 * por trocar de tela para edição de usuário 
	 * @param Event
	 * @throws IOException
	 */
	@FXML 
	public void onBtEditarUsuario(ActionEvent Event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("/views/EditarUsuariosView.fxml")); 
		Stage primaryStage = new Stage();  
		Scene scene = new Scene(root);
		primaryStage.setTitle("Edição de Usuário");
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.initOwner(btEditar.getScene().getWindow());
		primaryStage.show(); 
		
		carregandoTableView();
	}

}
