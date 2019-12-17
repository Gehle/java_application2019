package app;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class PongGame extends Application {

	private static final int psx = 750;  // taille fenetre en x
	private static final int psy = 600;   // taille fenetre en y
	private static final int rball = 20; // diam balle
	private static final int lrect = 120; // largeur rectangle
	private static final int hrect = 20; // hauteur rectangle
	//private static final int vrect = 15; //vitesse rectangle
	private static final int rectY = 570; //placement rectangle Y
	double ballSpeedX;
	double ballSpeedY;
	double dx = 0.5;
	double dy = 0.5;
	int score = 0;
	
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, psx, psy, Color.BLACK);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			Circle ball = new Circle(psx / 2, psy / 2, rball);
			ball.setFill(Color.WHITE);

			
			Rectangle joueur = new Rectangle((psx - lrect) / 2, rectY, lrect, hrect); // defini position et taille du rectangle joueur
			joueur.setFill(Color.WHITE);
			
			
			/*Text text = new Text("PERDU!\n Score: " + score);*/
			Text text = new Text("PERDU!");
			text.setFont(Font.font("Calibri", 70));
			text.setFill(Color.WHITE);
			text.setTextOrigin(VPos.CENTER);
			double width = text.getLayoutBounds().getWidth();
			text.setLayoutX(psx/2 - width/2);
			text.setLayoutY(300);
			text.setVisible(false);

			
			
			root.getChildren().addAll(joueur, ball, text);

			scene.setOnMouseMoved(e -> {
				
				joueur.setX(e.getSceneX() - lrect/2);
			});
			
			/*joueur.setOnKeyPressed(new EventHandler<KeyEvent>() { // detecte si on a appuié sur une touche
				public void handle(KeyEvent event) {
					if (event.getCode() == KeyCode.LEFT) { // le rectangle se déplace vers la gauche
						joueur.setX(joueur.getX() - vrect);
					}

					if (event.getCode() == KeyCode.RIGHT) { // le rectangle se déplace vers la droite
						joueur.setX(joueur.getX() + vrect);

					}
					event.consume();
				}
			});*/

			
			ballSpeedX = dx;
			ballSpeedY = -dy;
		
			Timeline loop = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg) {

					// deplacement:
					ball.setCenterX(ball.getCenterX() + ballSpeedX);
					ball.setCenterY(ball.getCenterY() - ballSpeedY);
					
					//haut
					if(ball.getCenterY() <= (rball/2)){
						ballSpeedY = -dy;
					}
					
					//bas
					if(ball.getCenterY() >= rectY){
						if(ball.getCenterX() >= joueur.getX() && ball.getCenterX() <= joueur.getX() + lrect){
							dx += 0.25;
							dy += 0.25;
							ballSpeedY = dy;
							score += 1;
							
						}
					}
					
					//gauche
					if(ball.getCenterX() <= (rball/2)){
						ballSpeedX = dx;
					}
					
					//droit
					if(ball.getCenterX() >= (psx-(rball/2))){
						ballSpeedX = -dx;
					}
					
					//collision bas
					if(ball.getCenterY() >= (psy-(rball/2))){
						text.setVisible(true);
						ballSpeedX = 0;
						ballSpeedY = 0;
						ball.setFill(Color.BLACK);
						ball.toBack();
					}
					primaryStage.setTitle("Pong || Score: " + score);
				}	
			}));
			loop.setCycleCount(Timeline.INDEFINITE);
			loop.play();
			
			//marche pas
			/*if(text.isVisible() == true){
				loop.stop();
			}*/
			
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pong");
			primaryStage.show();
			joueur.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void launcher(String[] args) {
		launch(args);
	}
}