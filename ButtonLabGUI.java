import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

/** A window with one button
 * @author <em>Your name goes here</em>
 * @author <em>Your partner's name goes here</em>
 */
public class ButtonLabGUI extends Application {
  /** A clickable button */
  private Button button;
  
  /** 
   * Overrides the start method of Application to create the GUI with one button in the center of the main window.
   * @param primaryStage the JavaFX main window
   */
  public void start(Stage primaryStage) {
    button = new Button("Click me");
    
    BorderPane pane = new BorderPane();      // create a 5 region layout for the window
    pane.setCenter(button);                  // add the button to the middle

    Scene scene = new Scene(pane);           // Create a "scene" that contains this border area

    primaryStage.setTitle("Button Lab GUI");
    primaryStage.setScene(scene);            // Add the "scene" to the main window
    primaryStage.show();                     // Display the window
  }
    
  /**
   * The method to launch the program.
   * @param args  The command line arguments.  The arguments are passed on to the JavaFX application.
   */
   public static void main(String[] args) {
     Application.launch(args);
   }
  
}