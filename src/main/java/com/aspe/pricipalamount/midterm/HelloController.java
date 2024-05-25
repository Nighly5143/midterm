package com.aspe.pricipalamount.midterm;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button computeBtn;

    @FXML
    private Label result;

    @FXML
    private TextField textFld;

    @FXML
    void compute(ActionEvent event) {
        try {
            double principal = Double.parseDouble(textFld.getText());
            int term = Integer.parseInt(comboBox.getValue());

            String resultT = "Interest Amount: " + principal ;
            result.setText(resultT);
        } catch (NumberFormatException | NullPointerException e) {
            result.setText("Please enter valid principal amount and select a term.");
        }
    }

    @FXML
    public void initialize() {
        for (int i = 1; i <= 12; i++) {
            comboBox.getItems().add(String.valueOf(i));
            comboBox.getSelectionModel().selectFirst();

            computeBtn.setOnAction(event -> calculateInterest());
        }
    }

    private void calculateInterest() {
        String principalAmountText = textFld.getText();

        if (principalAmountText.isEmpty()) {
            result.setText("Invalid Input");
            return;
        }

        double pAmount = Double.parseDouble(principalAmountText);

        Integer selectedTerm = Integer.parseInt(comboBox.getSelectionModel().getSelectedItem());

        if (selectedTerm == null) {
            result.setText("...");
            return;
        }

        double calculatedResult = pAmount; // Initial result is the principal amount

        for (int i = 1; i <= selectedTerm; i++) {
            calculatedResult += calculatedResult * 0.10; // Increase result by 10% for each term
        }

        result.setText("Result: " + String.format("%.2f", calculatedResult));
    }

}
