package com.example.jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene1Controller implements Initializable {
	//---------------------------------------------------------------------------------------------------------
	// Code for the scene swapping
	@FXML
	TextField nameTextToFind;

	public void switchToSceneTwo(ActionEvent event) throws IOException {
		String text = nameTextToFind.getText();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		Parent root = loader.load();

		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayName(text);

		//root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene2.fxml")));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the circle movement

	@FXML //auto-inject all your fxml stuff
	private Circle circle;
	private double x, y;

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
	//---------------------------------------------------------------------------------------------------------
	// Code for the background color
	@FXML
	private Pane myPane;
	@FXML
	private ColorPicker myColorPicker;

	public void changeColor(ActionEvent event) {
		Color myColor = myColorPicker.getValue();
		myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
		myPane.setStyle("-fx-background-color: " + myColor.toString());
	}
	//---------------------------------------------------------------------------------------------------------
	// Code for the choice box
	@FXML
	private ChoiceBox<String> myChoicebox;
	@FXML
	private Label foodLabel;

	@Override
	public void initialize(java.net.URL url, java.util.ResourceBundle rb) {
		String[] food = {"Pizza", "Taco", "Burger"};
		myChoicebox.getItems().addAll(food);

		myChoicebox.setOnAction(this::getFood);
	}

	public void getFood(ActionEvent event) {
		String foodChoice = myChoicebox.getValue();
		foodLabel.setText(foodChoice);
	}
}
