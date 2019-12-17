package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import app.Main;
import app.VueController;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Main extends Application {

	// static MediaPlayer mediaplayer = new MediaPlayer(media);

	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("PONG PONG");
		showScene();
	}

	public static void showScene() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("Vue.fxml"));

			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);

			primaryStage.setScene(scene);
			primaryStage.show();

			VueController controller = loader.getController();

			controller.getMediaplayer().play();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showScene2() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("Vue2.fxml"));
			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}

	public static void showScene3() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(Main.class.getResource("Vue3.fxml"));
			loader.setLocation(Main.class.getResource("Vue3.fxml"));
			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);

			primaryStage.setScene(scene);
			primaryStage.show();

			// VueController controller =loader.getController();
			// controller.setMain(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}

}