/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package animation;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BouncingBall extends Pane {

    private Circle ball = new Circle(10, Color.BROWN); // Create the ball
    private Rectangle racket = new Rectangle(100, 10, Color.BLUE); // Create the racket
    private Timeline animation;
    private double ballSpeedX = 5; // Set the initial X-axis speed of the ball
    private double ballSpeedY = 5; // Set the initial Y-axis speed of the ball
    private double racketSpeed = 10; // Set the speed of the racket
    private static final int GAME_WIDTH = 800; // Set your game width
    private static final int GAME_HEIGHT = 600; // Set your game height
    private static final int RACKET_WIDTH = 70; // Set the racket width
    private int human = 0;
    private int computer = 0;
     GridPane textPane = new GridPane();
     private Label playerLabel = new Label("Player Score: " + human);
    private Label computerLabel = new Label("Computer Score: " + computer);

    public BouncingBall() {
        textPane.add(playerLabel, 0, 2);
        textPane.add(computerLabel, 0, 3);
        ball.setCenterX(GAME_WIDTH / 2); // Set initial ball X-coordinate
        ball.setCenterY(GAME_HEIGHT / 2); // Set initial ball Y-coordinate

        racket.setLayoutX(GAME_WIDTH / 2 - RACKET_WIDTH / 2); // Initialize racket position
        racket.setLayoutY(GAME_HEIGHT - 20); // Set the Y-coordinate of the racket

        // Create the animation
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(animation.getRate() * 2); // Adjust the rate as needed
        animation.play(); // Start animation

        getChildren().addAll(ball, racket, textPane);

    }

    public void moveBall() {
        double nextBallX = ball.getCenterX() + ballSpeedX;
        double nextBallY = ball.getCenterY() + ballSpeedY;

        // Check collisions with walls
        if (nextBallX >= getWidth() - ball.getRadius() || nextBallX <= ball.getRadius()) {
            ballSpeedX = -ballSpeedX;
            
        }
        if (nextBallY >= getHeight() - ball.getRadius() || nextBallY <= ball.getRadius()) {
            ballSpeedY = -ballSpeedY;
            
        if (nextBallY > GAME_HEIGHT/2) {
            // Increment the computer's score
            computer++;
            // Update the computer's score label
            computerLabel.setText("Computer Score: " + computer);
        }
        }
        // Update ball position
        ball.setCenterX(nextBallX);
        ball.setCenterY(nextBallY);

        // Check collision with racket
        checkCollisionRacket(racket);
    }

    public void setYDirection(int yDirection) {
        racketSpeed = yDirection;
    }

    public void moveRacketLeft() {
        racket.setX(racket.getX() - racketSpeed);
        racket.setLayoutX(Math.max(0, GAME_WIDTH / 2 - RACKET_WIDTH / 2)); // doesn't go off screen
    }

    public void moveRacketRight() {
        if (racket.getX() + racket.getWidth() + racketSpeed <= getWidth()) {
            racket.setX(racket.getX() + racketSpeed);
        }
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() * 1.5);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() / 1.5);
    }

    public void checkCollisionRacket(Rectangle racket) {
        if (ball.getBoundsInParent().intersects(racket.getBoundsInParent())) {
            // Ball and racket have collided, change ball's Y direction
            ballSpeedY = -ballSpeedY;
            human++;
            //change player label
             playerLabel.setText("Player Score: " + human);
        }
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }
}
