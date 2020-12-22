package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML private TextField textField;
    @FXML private ListView list;
    @FXML private Button button0;
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button buttonPoint;
    @FXML private Button buttonEnter;
    @FXML private Button buttonC;
    @FXML private Button buttonCE;
    @FXML private Button buttonAdd;
    @FXML private Button buttonSubtract;
    @FXML private Button buttonMulitply;
    @FXML private Button buttonDivide;
    @FXML private Button buttonReciprocal;
    @FXML private Button buttonChange;
    @FXML private Button buttonSign;

    private Stage stage;

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("/sample/sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle("UPN/RPN Taschenrechner");
            stage.setScene(new Scene(root, 605, 405));
            stage.show();
        }

        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }

    private Stack<String> stack = new Stack<String>();
    private StringBuilder sb = new StringBuilder();

    public ObservableList<String> getObservableList() {
        List<String> strings = new ArrayList<>(stack);
        Collections.reverse(strings);
        return FXCollections.observableList(strings);
    }


    public void functionNumbers()
    {
        if(button0.isFocused())
        {
            sb.append(0);
            textField.setText(sb.toString());
        }

        else if(button1.isFocused())
        {
            sb.append(1);
            textField.setText(sb.toString());
        }

        else if(button2.isFocused())
        {
            sb.append(2);
            textField.setText(sb.toString());
        }

        else if(button3.isFocused())
        {
            sb.append(3);
            textField.setText(sb.toString());
        }

        else if(button4.isFocused())
        {
            sb.append(4);
            textField.setText(sb.toString());
        }

        else if(button5.isFocused())
        {
            sb.append(5);
            textField.setText(sb.toString());
        }

        else if(button6.isFocused())
        {
            sb.append(6);
            textField.setText(sb.toString());
        }

        else if(button7.isFocused())
        {
            sb.append(7);
            textField.setText(sb.toString());
        }

        else if(button8.isFocused())
        {
            sb.append(8);
            textField.setText(sb.toString());
        }

        else if(button9.isFocused())
        {
            sb.append(9);
            textField.setText(sb.toString());
        }
    }

    public void functionOther()
    {
        //try{
            if(buttonEnter.isFocused())
            {
                stack.push(sb.toString());
                list.setItems(getObservableList());
                textField.clear();
                sb.setLength(0);
            }

            else if(buttonC.isFocused())
            {
                textField.clear();
                sb.setLength(0);
                stack.clear();
                list.setItems(null);
            }

            else if(buttonCE.isFocused())
            {
                textField.clear();
                sb.setLength(0);
            }

            else if(buttonReciprocal.isFocused())
            {
                double x = Double.parseDouble(sb.toString());

                double result = 1 / x;

                textField.clear();
                sb.setLength(0);
                stack.push(String.valueOf(result));
                list.setItems(getObservableList());
                }

            else if(buttonChange.isFocused())
            {
                double x = Double.parseDouble(stack.pop());
                double y = Double.parseDouble(stack.pop());

                stack.push(String.valueOf(x));
                stack.push(String.valueOf(y));
                list.setItems(getObservableList());
            }

            else if(buttonPoint.isFocused())
            {
                sb.append(".");
                textField.setText(sb.toString());
            }

            else if(buttonSign.isFocused())
            {
                double x = Double.parseDouble(sb.toString());

                if(x > 0)
                {
                    double result = -x;
                    textField.clear();
                    sb.setLength(0);
                    stack.push(String.valueOf(result));
                    list.setItems(getObservableList());
                }
                else
                {
                    double result = -x;
                    textField.clear();
                    sb.setLength(0);
                    stack.push(String.valueOf(result));
                    list.setItems(getObservableList());
                }
            }

        /*
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
        */
    }

    public void functionOperators()
    {
        //try {
            if (buttonAdd.isFocused()) {
                double x = Double.parseDouble(stack.pop());
                double y = Double.parseDouble(stack.pop());

                double result = x + y;

                stack.push(String.valueOf(result));
                list.setItems(getObservableList());
                sb.setLength(0);
            } else if (buttonSubtract.isFocused()) {
                double x = Double.parseDouble(stack.pop());
                double y = Double.parseDouble(stack.pop());

                double result = x - y;

                stack.push(String.valueOf(result));
                list.setItems(getObservableList());
                sb.setLength(0);
            } else if (buttonMulitply.isFocused()) {
                double x = Double.parseDouble(stack.pop());
                double y = Double.parseDouble(stack.pop());

                double result = x * y;

                stack.push(String.valueOf(result));
                list.setItems(getObservableList());
                sb.setLength(0);
            } else if (buttonDivide.isFocused()) {
                double x = Double.parseDouble(stack.pop());
                double y = Double.parseDouble(stack.pop());

                double result = x / y;

                stack.push(String.valueOf(result));
                list.setItems(getObservableList());
                sb.setLength(0);
            }
       /*
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
        }
        */
    }
}