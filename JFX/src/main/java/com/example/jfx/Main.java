package com.example.jfx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.*;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Group root = new Group(); // Create a root node to arrange all components

		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
		//Scene scene = new Scene(root, 600, 600, Color.LIGHTGOLDENRODYELLOW); // Create a scene w/ root node with a background color of orange
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
		String cssLocation = Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm();
		scene.getStylesheets().add(cssLocation);

		Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
		Scene scene2 = new Scene(root2);
		stage.setScene(scene2);

		Image icon = null;

		try {
			icon = new Image(Objects.requireNonNull(getClass().getResource("icon.png")).toExternalForm());
		} catch (Exception e) {
			System.out.println("No image found");
		}

		stage.getIcons().add(icon);
		stage.setTitle("Stage Demo Program"); // Set the title at the top of the screen.
		/*stage.setWidth(420);
		stage.setHeight(420);
		stage.setResizable(false);
		stage.setX(50);
		stage.setY(50);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("you are stuck :) (press 'x')");
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("x"));

		// Text
		Text text = new Text("Hello, World!");
		text.setX(50);
		text.setY(50);
		text.setFont(Font.font("Arial", 50));
		text.setFill(Color.DARKGRAY);
		//root.getChildren().add(text);

		// Line
		Line line = new Line();
		line.setStartX(200);
		line.setStartY(200);
		line.setEndX(500);
		line.setEndY(200);
		line.setStrokeWidth(5);
		line.setStroke(Color.LIGHTCORAL);
		line.setOpacity(0.75);
		line.setSmooth(true);
		line.setRotate(150);
		//root.getChildren().add(line);

		// Rectangle
		Rectangle rect = new Rectangle();
		rect.setX(200);
		rect.setY(200);
		rect.setWidth(100);
		rect.setHeight(100);
		rect.setFill(Color.LIGHTCORAL);
		rect.setStrokeWidth(5);
		rect.setStroke(Color.DARKGRAY);
		rect.setOpacity(0.75);
		rect.setArcWidth(20);
		rect.setArcHeight(20);
		rect.setSmooth(true);
		rect.setRotate(45);
		//root.getChildren().add(rect);

		// Triangle
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(
				500.0,500.0,
				550.0,550.0,
				500.0,600.0);
		triangle.setFill(Color.LIGHTSEAGREEN);
		//root.getChildren().add(triangle);
		triangle.setOpacity(0.75);

		// Circle
		Circle circle = new Circle();
		circle.setCenterX(300);
		circle.setCenterY(300);
		circle.setRadius(125);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.DARKGRAY);
		circle.setStrokeWidth(5);
		//root.getChildren().add(circle);

		// Image
		Image image = null;
		try {
			image = new Image(Objects.requireNonNull(getClass().getResource("rat-spinning.gif")).toExternalForm());
		} catch (Exception e) {
			System.out.println("No image found");
		}
		ImageView imageView = new ImageView(image);
		imageView.setX(25);
		imageView.setY(300);
		//root.getChildren().add(imageView); */

		stage.setScene(scene); // Set scene. Set the scene before you show the stage, like a play.
		stage.show(); // Show the stage

		stage.setOnCloseRequest(event -> {
			event.consume();
			logout(stage);
		});
	}

	public void logout(Stage stage) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout Confirmation");
		alert.setHeaderText("Are you sure you want to logout?");
		alert.setContentText("You will be logged out of the application.");

		if (alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}
}