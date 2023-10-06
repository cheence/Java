/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animation;

import animation.BouncingBall;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Chance
 */
public class BallControl extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BouncingBall bouncingBall = new BouncingBall();
        bouncingBall.setPrefSize(800, 600); // Set the preferred size
        Scene scene = new Scene(bouncingBall, 800, 600);
        primaryStage.setTitle("Bouncing Ball Control"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene
        primaryStage.show(); // Display the stage
        // Must request focus after the primary stage is displayed
        bouncingBall.requestFocus();
        
        bouncingBall.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                bouncingBall.pause();
            }
        });
        bouncingBall.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
            {
                bouncingBall.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                bouncingBall.decreaseSpeed();
            }
        });

         bouncingBall.setOnKeyPressed(m ->
        {
            if (m.getCode() == KeyCode.LEFT)
            {
                bouncingBall.moveRacketLeft();
            }
            else if (m.getCode() == KeyCode.RIGHT)
            {
                bouncingBall.moveRacketRight();
            }
        });
      

    }

    public static void main(String[] args) {
        launch(args);
    }
}
