package com.example.jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Scene1Controller {

	@FXML
	TextField nameTextToFind;

	@FXML //auto-inject all your fxml stuff
	private Circle circle;
	private double x, y;
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToSceneTwo(ActionEvent event) throws IOException {

		String text = nameTextToFind.getText();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		root = loader.load();

		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayName(text);

		//root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene2.fxml")));
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
