package com.example.jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Scene2Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private Label nameLabel;
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;

	public void displayName(String name) {
		nameLabel.setText("Hello " + name + ".");
	}

	public void switchToSceneOne(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String cssLocation = Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm();
		scene.getStylesheets().add(cssLocation);
		stage.setScene(scene);
		stage.show();
	}

	public void logout(ActionEvent event) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout Confirmation");
		alert.setHeaderText("Are you sure you want to logout?");
		alert.setContentText("You will be logged out of the application.");

		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("Logging out...");
			stage.close();
		}
	}
}
