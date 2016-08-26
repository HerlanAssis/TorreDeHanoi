package br.com.ifrn.ed.hanoi.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.ifrn.ed.hanoi.Hanoi;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    Hanoi hanoi;
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
        // TODO
        hanoi = new Hanoi();
    }

    @FXML
    private void handleTextChange(ActionEvent event) {
    }

    @FXML
    private void btStart(ActionEvent event) {

        hanoi.clearStacks();
        hanoi.gerarElementos(Integer.parseInt(tfcapcity.getText()));
        hanoi.resolver();
        
        ObservableList<String> stackA =FXCollections.observableArrayList();
        
        stackA.add("");
        
//        ObservableList<String> items = FXCollections.observableArrayList(
//                "Single", "Double", "Suite", "Family App");
        poleA.setItems(stackA);
    }

}
