module Pbl03 {
	requires javafx.controls;
	requires javafx.fxml;
	requires itext;
	requires java.desktop;
	requires javafx.graphics; 
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controllers to javafx.graphics, javafx.fxml;
	opens application.util to javafx.graphics, javafx.fxml;
	opens views to javafx.graphics, javafx.fxml;
	
	exports application;
}
