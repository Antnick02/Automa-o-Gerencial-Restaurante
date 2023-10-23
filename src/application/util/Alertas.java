package application.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Classe responsável por ter o modelo para criação de alertas  
 * do programa
 * @author anton
 *
 */
public class Alertas {

	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

}
