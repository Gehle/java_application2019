package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Main extends Application {

	// static MediaPlayer mediaplayer = new MediaPlayer(media);

	private static Stage primaryStage;
	private static Stage gameStage;

	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("PONG PONG");
		mainScene();
	}

	public static void mainScene() {
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

	private static final int psx = 750;  // taille fenetre en x
	private static final int psy = 600;   // taille fenetre en y
	private static final int rball = 20; // diam balle
	private static final int lrect = 120; // largeur rectangle
	private static final int hrect = 20; // hauteur rectangle
	//private static final int vrect = 15; //vitesse rectangle
	private static final int rectY = 570; //placement rectangle Y
	static double ballSpeedX;
	static double ballSpeedY;
	static double dx = 0.5;
	static double dy = 0.5;
	static int score = 0;
	
	public static void pongGame() {
		try {

			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-color:BLACK;");
			Scene scene = new Scene(root, psx, psy);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Circle ball = new Circle(psx / 2, psy / 2, rball);
			ball.setFill(Color.WHITE);

			Rectangle joueur = new Rectangle((psx - lrect) / 2, rectY, lrect, hrect); // defini position et taille du
																						// rectangle joueur
			joueur.setFill(Color.WHITE);

			/* Text text = new Text("PERDU!\n Score: " + score); */
			Text text = new Text("PERDU!");
			text.setFont(Font.font("Calibri", 70));
			text.setFill(Color.WHITE);
			text.setTextOrigin(VPos.CENTER);
			double width = text.getLayoutBounds().getWidth();
			text.setLayoutX(psx / 2 - width / 2);
			text.setLayoutY(300);
			text.setVisible(false);

			root.getChildren().addAll(joueur, ball, text);

			scene.setOnMouseMoved(e -> {

				joueur.setX(e.getSceneX() - lrect / 2);
			});

			/*
			 * joueur.setOnKeyPressed(new EventHandler<KeyEvent>() { // detecte si on a
			 * appuié sur une touche public void handle(KeyEvent event) { if
			 * (event.getCode() == KeyCode.LEFT) { // le rectangle se déplace vers la gauche
			 * joueur.setX(joueur.getX() - vrect); }
			 * 
			 * if (event.getCode() == KeyCode.RIGHT) { // le rectangle se déplace vers la
			 * droite joueur.setX(joueur.getX() + vrect);
			 * 
			 * } event.consume(); } });
			 */

			ballSpeedX = dx;
			ballSpeedY = -dy;

			Timeline loop = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg) {

					// deplacement:
					ball.setCenterX(ball.getCenterX() + ballSpeedX);
					ball.setCenterY(ball.getCenterY() - ballSpeedY);

					// haut
					if (ball.getCenterY() <= (rball / 2)) {
						ballSpeedY = -dy;
					}

					// bas
					if (ball.getCenterY() >= rectY) {
						if (ball.getCenterX() >= joueur.getX() && ball.getCenterX() <= joueur.getX() + lrect) {
							dx += 0.25;
							dy += 0.25;
							ballSpeedY = dy;
							score += 1;

						}
					}

					// gauche
					if (ball.getCenterX() <= (rball / 2)) {
						ballSpeedX = dx;
					}

					// droit
					if (ball.getCenterX() >= (psx - (rball / 2))) {
						ballSpeedX = -dx;
					}

					// collision bas
					if (ball.getCenterY() >= (psy - (rball / 2))) {
						text.setVisible(true);
						ballSpeedX = 0;
						ballSpeedY = 0;
						ball.setCenterX(25);
						ball.setCenterY(25); 
						ball.setFill(Color.BLACK);
						ball.toBack();
					}
					primaryStage.setTitle("Pong || Score: " + score);
				}
			}));
			loop.setCycleCount(Timeline.INDEFINITE);
			loop.play();

			// marche pas
			/*
			 * if(text.isVisible() == true){ loop.stop(); }
			 */

			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pong");
			primaryStage.show();
			joueur.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}