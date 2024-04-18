module aragon {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens fxml to javafx.graphics, javafx.fxml;
}
