package br.com.ifrn.ed.hanoi.ui;

import br.com.ifrn.ed.hanoi.Hanoi;
import br.com.ifrn.ed.hanoi.PassosHanoi;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
/**
 * FXML Controller class
 *
 * @author savio
 */
public class FXMLController implements Initializable {

    private Hanoi hanoi;
    private ArrayList<PassosHanoi> stackArray;
    private int movAtual;
    private final int MAXSIZE = 10;
    private double tam;

    @FXML
    private Label MoveTimes;
    @FXML
    private ListView<String> poleA;
    @FXML
    private ListView<String> poleB;
    @FXML
    private ListView<String> poleC;
    @FXML
    private Button btStart;
    @FXML
    private ComboBox<?> capacidade;
    @FXML
    private ComboBox<?> time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hanoi = new Hanoi();
    }

    @FXML
    private void btStart(ActionEvent event) {
        hanoi.clearStacks();
        hanoi.gerarElementos(Integer.parseInt(capacidade.getValue().toString()));
        stackArray = hanoi.resolver();     
        this.tam = MAXSIZE / Double.parseDouble(capacidade.getValue().toString());

        //TOTAL DE MOVIMENTOS NECESSÁEIOS - > hanoi.getTotalMovimentosNecessarios();
        //DEFINIR VALOR PADRÃO PARA O TEMPO E O TOTAL DE PINOS
        Task<Void> exampleTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (; movAtual < stackArray.size(); movAtual++) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setItemsListView(poleA, stackArray.get(movAtual).getStackA());
                            setItemsListView(poleB, stackArray.get(movAtual).getStackB());
                            setItemsListView(poleC, stackArray.get(movAtual).getStackC());
                            MoveTimes.setText("Movimentos: " + stackArray.get(movAtual).getTotalMovimentosRealizados());

                        }
                    });

                    Thread.sleep((long) (Double.parseDouble(time.getValue().toString()) * 1000));
                }
                return null;
            }
        };
        new Thread(exampleTask).start();
    }

    /**
     * Realiza o set de items em um listView a partir e uma pilha;
     *
     * @param listView a ser modificado;
     * @param stack de item a serem adicionados;
     */
    private void setItemsListView(ListView listView, MyStack stack) {
        ObservableList<Button> pole = FXCollections.observableArrayList();
        MyStack<Integer> myStackA = MyStack.copy(stack);

        while (!myStackA.isEmpty()) {
            Button bt = new Button();
            int valorBotao = myStackA.pop();
            
            bt.setStyle("-fx-background-color: "+gencode()+";");
            bt.setScaleX(valorBotao * tam);
            bt.setScaleY(6 * 0.125);
            pole.add(0, bt);
        }

        listView.setItems(pole);
    }
    
    static String gencode()
    {
        String[] letters = new String[15];
        letters = "0123456789ABCDEF".split("");
        String code ="#";
        for(int i=0;i<6;i++)
        {
            double ind = Math.random() * 15;
            int index = (int)Math.round(ind);
            code += letters[index]; 
        }
        return code;
    }
}
