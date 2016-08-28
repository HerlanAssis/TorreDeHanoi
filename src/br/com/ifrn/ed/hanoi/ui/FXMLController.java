package br.com.ifrn.ed.hanoi.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.ifrn.ed.hanoi.Hanoi;
import br.com.ifrn.ed.hanoi.StepsHanoi;
import br.com.ifrn.ed.hanoi.stack.MyStack;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author savio
 */
public class FXMLController implements Initializable {

    private Hanoi hanoi;
    private ArrayList<StepsHanoi> stackArray;

    @FXML
    private Label MoveTimes;
    @FXML
    private TextField tfcapcity;
    @FXML
    private ListView<String> poleA;
    @FXML
    private ListView<String> poleB;
    @FXML
    private ListView<String> poleC;
    @FXML
    private Button btStart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hanoi = new Hanoi();
    }

    @FXML
    private void handleTextChange(ActionEvent event) {
    }

    @FXML
    private void btStart(ActionEvent event) {
        hanoi.clearStacks();
        hanoi.gerarElementos(Integer.parseInt(tfcapcity.getText()));
        stackArray = hanoi.resolver();        

        Task<Void> exampleTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Demais códigos...
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // Alteração de componentes
                    }
                });
                return null;
            }
        };
        new Thread(exampleTask).start();

//        ObservableList<String> pole = FXCollections.observableArrayList();
//        for (int i = 0; i < 10; i++) {
//            pole.add(i + "");
//        }
//
//        Task<Void> sleeper = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
//                return null;
//            }
//        };
//        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                
//            }
//        });
//        new Thread(sleeper).start();
    }

    private void setItemsListView(ListView listView, MyStack stack) {
        ObservableList<String> pole = FXCollections.observableArrayList();
        MyStack<Integer> myStackA = MyStack.copy(stack);
        while (!myStackA.isEmpty()) {
            pole.add(String.valueOf(myStackA.pop()));
        }
        listView.setItems(pole);
    }
}
