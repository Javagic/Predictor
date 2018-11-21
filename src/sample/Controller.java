package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private int fromInt;
    private int toInt;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private Button start;
    @FXML
    private Button greater;
    @FXML
    private Button less;
    @FXML
    private Label count;
    @FXML
    private Label liar;
    @FXML
    private Label youare;
    @FXML
    private Label total;
    @FXML
    private Button again;
    @FXML
    private Button done;


    private void hide(Node... nodes) {
        for (Node node : nodes) {
            node.setVisible(false);
        }
    }

    private void show(Node... nodes) {
        for (Node node : nodes) {
            node.setVisible(true);
        }
    }

    @FXML
    private void startClick(ActionEvent event) {
        show(greater, less, count, done);
        hide(label1, label2, from, to, start, liar, youare, total, again);
        fromInt = Integer.parseInt(from.getText());
        toInt = Integer.parseInt(to.getText());
        setCount();
    }


    @FXML
    private void greaterClick(ActionEvent event) {
        fromInt = Integer.parseInt(count.getText());
        setCount();
    }

    private void setCount() {
        int val = (toInt + fromInt) / 2;
        count.setText(String.valueOf(val));
        if (val - 1 == fromInt) {
            hide(less);
        } else {
            show(less);
        }
        if (val + 1 == toInt) {
            hide(greater);
        } else {
            show(greater);
        }
        if (!(less.isVisible() || greater.isVisible())) {
            onDone();
        }
    }

    @FXML
    private void lessClick(ActionEvent event) {
        toInt = Integer.parseInt(count.getText());
        setCount();
    }

    @FXML
    private void againClick(ActionEvent event) {
        hide(youare, again, total);
        show(label1, label2, start, from, to);
        from.setText("");
        to.setText("");
    }

    @FXML
    private void doneClick(ActionEvent event) {
        onDone();
    }

    private void onDone() {
        hide(greater, less, count, done);
        show(youare, again, total);
        total.setText(count.getText());
    }
}
