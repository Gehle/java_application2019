package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import app.Main;
import app.VueController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Main extends Application {


	private static final int psx = 750;  // taille fenetre en x
	private static final int psy = 600;   // taille fenetre en y
	private static final int rball = 20; // diam balle
	private static final int lrect = 120; // largeur rectangle
	private static final int hrect = 20; // hauteur rectangle
	private static final int rectY = 570; //placement rectangle Y
	static double ballSpeedX= 0.5;
	static double ballSpeedY= -0.5;
	static double dx = 0.5;
	static double dy = 0.5;
	static int score = 0;

	private static Stage primaryStage;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}



	public static void pongGame() {
		try {

			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-color:BLACK;");
			Scene scene = new Scene(root, psx, psy);

			Circle ball = new Circle(psx / 2, psy / 2, rball);
			ball.setFill(Color.WHITE);

			Rectangle joueur = new Rectangle((psx - lrect) / 2, rectY, lrect, hrect); // defini position et taille du rectangle joueur																	
			joueur.setFill(Color.WHITE);

			Text text = new Text("PERDU!");
			text.setFont(Font.font("Calibri", 70));
			text.setFill(Color.WHITE);
			text.setTextOrigin(VPos.CENTER);
			double widthText = text.getLayoutBounds().getWidth();
			text.setLayoutX(psx / 2 - widthText / 2);
			text.setLayoutY(250);
			text.setVisible(false);
			
			Text message = new Text("Press ESC to return to the menu");
			message.setFont(Font.font("Calibri", 40));
			message.setFill(Color.WHITE);
			message.setTextOrigin(VPos.CENTER);
			double widthMessage = message.getLayoutBounds().getWidth();
			message.setLayoutX(psx / 2 - widthMessage / 2);
			message.setLayoutY(350);
			message.setVisible(false);

			root.getChildren().addAll(joueur, ball, text, message);

			scene.setOnMouseMoved(e -> {

				joueur.setX(e.getSceneX() - lrect / 2);
			});


			ballSpeedX = dx;
			ballSpeedY = -dy;

			//ballSpeedX = dx;
			//ballSpeedY = -dy;


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
						message.setVisible(true);
						/*ballSpeedX = 0;
						ballSpeedY = 0;
						ball.setCenterX(25);
						ball.setCenterY(25); 
						ball.setFill(Color.BLACK);
						ball.toBack();*/
						
						scene.setOnKeyPressed(new EventHandler<KeyEvent>() { // detecte si on a appuié sur une touche
							public void handle(KeyEvent event) {
								if (event.getCode() == KeyCode.ESCAPE) {
									Main.mainScene();
								}
								event.consume();
							}
						});
					}
					primaryStage.setTitle("Pong || Score: " + score);
				}
			}));
			loop.setCycleCount(Timeline.INDEFINITE);
			loop.play();


			if (ball.getCenterY() >= (psy - (rball / 2))) {
				loop.stop();
			}

			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pong");
			primaryStage.show();
			joueur.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}