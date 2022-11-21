package ca.durhamcollege.oop3200f2022week10b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class Vector2ViewController implements Initializable
{



    @FXML
    private Button AddVectorButton;

    @FXML
    private Button CalculateDistanceButton;

    @FXML
    private Label TotalDistanceLabel;

    @FXML
    private TextField TotalDistanceTextView;

    @FXML
    private ListView<Vector2> Vector2ListView;

    @FXML
    private TextField XInputTextField;

    @FXML
    private TextField YInputTextField;

    @FXML
    void AddVectorButton_Clicked(ActionEvent event)
    {
        if(!XInputTextField.getText().isEmpty() && !YInputTextField.getText().isEmpty())
        {
            float x = Float.parseFloat(XInputTextField.getText());
            float y = Float.parseFloat(YInputTextField.getText());
            Vector2 newVector2 = new Vector2(x, y);
            Vector2ListView.getItems().add(newVector2);
            XInputTextField.clear();
            YInputTextField.clear();
            TotalDistanceTextView.clear();
        }
    }

    @FXML
    void CalculateDistanceButton_Clicked(ActionEvent event)
    {
        var selectedItemsList = Vector2ListView.getSelectionModel().getSelectedItems();
        var distance = Vector2.Distance(selectedItemsList.get(0), selectedItemsList.get(1));
        TotalDistanceTextView.setText(Float.toString(distance));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Vector2ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Vector2ListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
        {

            if(Vector2ListView.getSelectionModel().getSelectedItems().size() == 2)
            {
                showDistanceUI();
            }
            else
            {
                hideDistanceUI();
            }
        });

        XInputTextField.textProperty().addListener((obs, oldValue, newValue) ->{
            if (!newValue.matches("\\d*"))
            {
                XInputTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        YInputTextField.textProperty().addListener((obs, oldValue, newValue) ->{
            if (!newValue.matches("\\d*"))
            {
                YInputTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });


    }

    private void showDistanceUI()
    {
        CalculateDistanceButton.setVisible(true);
        TotalDistanceLabel.setVisible(true);
        TotalDistanceTextView.setVisible(true);
    }

    private void hideDistanceUI()
    {
        CalculateDistanceButton.setVisible(false);
        TotalDistanceLabel.setVisible(false);
        TotalDistanceTextView.setVisible(false);
        TotalDistanceTextView.clear();
    }
}