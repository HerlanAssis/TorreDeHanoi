package br.com.ifrn.ed.hanoi.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 *
 * @author savio
 */
public class HanoiSc extends Application {
    
   @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/br/com/ifrn/ed/hanoi/ui/Tela.fxml"));
        primaryStage.setTitle("Torre de Hanoi");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
