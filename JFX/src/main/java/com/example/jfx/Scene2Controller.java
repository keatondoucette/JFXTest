package com.example.jfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Scene2Controller implements Initializable {
	//---------------------------------------------------------------------------------------------------------
	// Code to display the image

	@FXML
	private Label nameLabel;

	public void displayName(String name) {
		nameLabel.setText("Hello " + name + ".");
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the scene swapping
	private Stage stage;

	public void switchToSceneOne(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		String cssLocation = Objects.requireNonNull(this.getClass().getResource("styles.css")).toExternalForm();
		scene.getStylesheets().add(cssLocation);
		stage.setScene(scene);
		stage.show();
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the logging out button

	@FXML
	private AnchorPane scenePane;

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

	//---------------------------------------------------------------------------------------------------------
	// Code for the image swapping

	@FXML
	private ImageView myImageView;
	URL imageUrl = Main.class.getResource("test.png");
	Image myImage = new Image(Objects.requireNonNull(imageUrl).toExternalForm());

	public void displayImage() {
		// Extract file name
		String path = imageUrl.getPath();
		String fileName = path.substring(path.lastIndexOf("/") + 1);

		// Swap the file
		if (fileName.equals("test.png")) {
			imageUrl = Main.class.getResource("newplot (1).png");
			myImage = new Image(Objects.requireNonNull(imageUrl).toExternalForm());
		}
		else {
			imageUrl = Main.class.getResource("test.png");
			myImage = new Image(Objects.requireNonNull(imageUrl).toExternalForm());
		}

		myImageView.setImage(myImage);
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the age verification

	@FXML
	private TextField myTextField;
	@FXML
	private Label ageLabel;
	@FXML
	private Button ageButton;

	public void submit(ActionEvent event) {

		int age;

		try {
			age = Integer.parseInt(myTextField.getText());

			if (age >= 18) {
				ageLabel.setText("You are old enough!");
			}
			else {
				ageLabel.setText("You are too young!");
			}
		}
		catch (NumberFormatException e) {
			ageLabel.setText("Please only numbers please");
		}
		catch (Exception e) {
			ageLabel.setText("ERROR");
		}
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the checkbox
	@FXML
	private CheckBox myCheckbox;
	@FXML
	private Label onOffLabel;

	public void change(ActionEvent event) {
		if (myCheckbox.isSelected()) {
			onOffLabel.setText("On");
		}
		else {
			onOffLabel.setText("Off");
		}
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the radio button
	@FXML
	private RadioButton rButton1,rButton2,rButton3;
	@FXML
	private Label foodLabel;

	public void getFood(ActionEvent event) {
		if (rButton1.isSelected()) {
			foodLabel.setText("Pizza");
		}
		else if (rButton2.isSelected()) {
			foodLabel.setText(rButton2.getText());
		}
		else if (rButton3.isSelected()) {
			foodLabel.setText("Taco");
		}
		else {
			foodLabel.setText("ERROR");
		}
	}
	//---------------------------------------------------------------------------------------------------------
	// Code for the date picker
	@FXML
	private DatePicker myDatePicker;
	@FXML
	private Label dateLabel;

	public void getDate(ActionEvent event) {
		LocalDate date = myDatePicker.getValue();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd MMM yy"));
		dateLabel.setText(formattedDate);
	}

	//---------------------------------------------------------------------------------------------------------
	// Code for the slider
	@FXML
	private Slider mySlider;
	@FXML
	private Label sliderLabel;
	private int temp;
	//---------------------------------------------------------------------------------------------------------
	// Code for progress bars
	@FXML
	private Label progressLabel;
	@FXML
	private ProgressBar myProgressbar;
	@FXML
	private Button progressButton;

	double progress;

	public void increaseProgress(ActionEvent event) {
		if (progress < 0.9) {
			progress += 0.1;
			myProgressbar.setProgress(progress);
			progressLabel.setText((int) Math.round(myProgressbar.getProgress() * 100) + "%");
		}
	}
	//---------------------------------------------------------------------------------------------------------
	// Code for spinner
	@FXML
	private Spinner<Integer> mySpinner;
	@FXML
	private Label spinnerLabel;
	private int currValue;

	//---------------------------------------------------------------------------------------------------------
	// Initialize code
	@Override
	public void initialize(java.net.URL url, java.util.ResourceBundle rb) {
		/** Progress Bar **/
		myProgressbar.setStyle("-fx-accent: red;");

		/** Slider **/
		temp = (int) mySlider.getValue();
		sliderLabel.setText(Integer.toString(temp));

		mySlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				temp = (int) mySlider.getValue();
				sliderLabel.setText(Integer.toString(temp));
			}
		});

		/** Spinner **/
		SpinnerValueFactory<Integer> valueFactory =
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

		valueFactory.setValue(1);

		mySpinner.setValueFactory(valueFactory);
		currValue = mySpinner.getValue();

		spinnerLabel.setText(Integer.toString(currValue));
		mySpinner.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				currValue = mySpinner.getValue();
				spinnerLabel.setText(Integer.toString(currValue));
			}
		});
	}
}
