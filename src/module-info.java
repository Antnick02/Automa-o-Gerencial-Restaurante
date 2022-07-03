module Pbl03 {
	requires javafx.controls;
	requires javafx.fxml;
	requires itext;
	requires java.desktop;
	opens application to javafx.graphics, javafx.fxml;
}
