package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main3 extends Application {
	
	protected Label lbl;
	protected TextField txfName;
	protected TextArea txaMessage;
	protected Button btnHelloWorld;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create controls
			lbl = new Label("Name");
			txfName = new TextField();
			txaMessage = new TextArea();
			txaMessage.setPrefHeight(100);
			txaMessage.setPrefWidth(200);
			btnHelloWorld = new Button("Hello World");

			// Create HBox
			HBox hBoxName = new HBox();
			// Add style definition to HBox
			hBoxName.getStyleClass().add("h_or_v_box");
			// Add controls to HBox
			hBoxName.getChildren().addAll(lbl, txfName);

			// Create root container for controls
			GridPane root = new GridPane();

			// Add HBox to Gridpane
			root.add(hBoxName, 0, 0);
			// Add other controls to GridPane
			root.add(btnHelloWorld, 0, 1);
			root.add(txaMessage, 0, 2);

			// Add GridPane (root) to Scene.
			Scene scene = new Scene(root,300,250);

			// Set the title for the window
			primaryStage.setTitle("Hello World");

			// Code to display the Gui
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
