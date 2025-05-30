package com.example.jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {


	@FXML //auto-inject all your fxml stuff
	private Circle circle;
	private double x, y;
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToSceneOne(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String cssLocation = Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm();
		scene.getStylesheets().add(cssLocation);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToSceneTwo(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene2.fxml")));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void up(ActionEvent e) {
		//System.out.println("Up");
		circle.setCenterY(y--);
	}
	public void down(ActionEvent e) {
		//System.out.println("Down");
		circle.setCenterY(y++);
	}
	public void left(ActionEvent e) {
		//System.out.println("Left");
		circle.setCenterX(x--);
	}
	public void right(ActionEvent e) {
		//System.out.println("Right");
		circle.setCenterX(x++);
	}
}
