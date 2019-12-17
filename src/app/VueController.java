package app;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import app.Main;

public class VueController {

private Main main;

@FXML
private Button btn;
@FXML
public Slider sldQuertety;


public Slider getSldQuertety() {
	return sldQuertety;
}


public void setSldQuertety(Slider sldQuertety) {
	this.sldQuertety = sldQuertety;
}

public String path = "@../../source/arcade.mp3";
public Media media =new Media(new File(path).toURI().toString());

public MediaPlayer mediaplayer = new MediaPlayer(media);


public MediaPlayer getMediaplayer() {
	return mediaplayer;
}





public void exit(ActionEvent event) {
	
	System.exit(0);
	
}


@FXML

public void playSound(ActionEvent event) {
	
	mediaplayer.play();
	
	mediaplayer.setVolume(sldQuertety.getValue());
	
	
	
}
@FXML
public void pause(ActionEvent event) {
	
		mediaplayer.pause();
	
	
}

@FXML
public void change(ActionEvent event) {
	mediaplayer.setVolume(sldQuertety.getValue());
}
public void setMain(Main main) {
	this.main = main;
	
}
public void regle(ActionEvent event) {
	Main.showScene2();
	
}
public void credit(ActionEvent event) {
	Main.showScene3();
	
}
public void returned(ActionEvent event) {
	
	Main.showScene();
}
public void game(ActionEvent event) {
	
	
	Main.showScene4();
}


}
