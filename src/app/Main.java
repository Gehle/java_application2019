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


	//static MediaPlayer mediaplayer = new MediaPlayer(media);
	
	
	
	 
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("PONG PONG");
		showScene();
	}
	public static  void showScene() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader =new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("Vue.fxml"));
			
			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);
			

			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			VueController controller = loader.getController();
			
			controller.getMediaplayer().play();
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
	public static void showScene2() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader =new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("Vue2.fxml"));
			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	;
	
}
	public static void showScene3() {
		try {
			Pane layout = new Pane();
			FXMLLoader loader =new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("Vue3.fxml"));
			loader.setLocation(Main.class.getResource("Vue3.fxml"));
			layout = (Pane) loader.load();
			Scene scene = new Scene(layout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//VueController controller =loader.getController();
			//controller.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	;
	
	
}


	//variable
			private static final int width = 800;
			private static final int height = 600;
			private static final int PLAYER_HEIGHT = 100;
			private static final int PLAYER_WIDTH = 15;
			private static final double BALL_R = 15;
			private static int ballYSpeed = 1;
			private static int ballXSpeed = 1;
			private static double playerOneYPos = height / 2;
			private static double playerTwoYPos = height / 2;
			private static double ballXPos = width / 2;
			private static double ballYPos = height / 2;
			private static int scoreP1 = 0;
			private static int scoreP2 = 0;
			private static boolean gameStarted;
			private static int playerOneXPos = 0;
			private static double playerTwoXPos = width - PLAYER_WIDTH;
	public static void showScene4() {
		try {
			primaryStage.setTitle("P O N G");
			//background size
			Canvas canvas = new Canvas(width, height);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
			Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
			//number of cycles in animation INDEFINITE = repeat indefinitely
			tl.setCycleCount(Timeline.INDEFINITE);
			
			//mouse control (move and click)
			canvas.setOnMouseMoved(e ->  playerOneYPos  = e.getY());
			canvas.setOnMouseClicked(e ->  gameStarted = true);
			primaryStage.setScene(new Scene(new StackPane(canvas)));
			primaryStage.show();
			tl.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	;
	
}
	private static void run(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if(gameStarted) {
			//set ball movement
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			//simple computer opponent who is following the ball
			if(ballXPos < width - width  / 4) {
				playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
			}  else {
				playerTwoYPos =  ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ?playerTwoYPos += 1: playerTwoYPos - 1;
			}
			//draw the ball
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click", width / 2, height / 2);
			
			//reset the ball start position 
			ballXPos = width / 2;
			ballYPos = height / 2;
			
			//reset the ball speed and the direction
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
		}
		
		//makes sure the ball stays in the canvas
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		
		//if you miss the ball, computer gets a point
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
		}
		
		//if the computer misses the ball, you get a point
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
		}
	
		//increase the speed after the ball hits the player
		if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) || 
			((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}