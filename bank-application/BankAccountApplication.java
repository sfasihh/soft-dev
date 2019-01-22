/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Samiya Fasihuddin
 */
public class BankAccountApplication extends Application {

    private Manager manager;

    public BankAccountApplication() {
        manager = new Manager();
    }

    @Override
    public void start(Stage stage) {

        Text text1 = new Text("Username");

        //creating label password 
        Text text2 = new Text("Password");

        // Creating label role 
        // Text text3 = new Text("Role");
        //Label for location 
        Text roleText = new Text("Role");

        //Choice box for location 
        ChoiceBox roleChoice = new ChoiceBox();
        roleChoice.getItems().addAll("Manager", "Customer");

        //Creating Text Filed for Username        
        TextField usernameField = new TextField();

        //Creating Text Filed for password        
        PasswordField passwordField = new PasswordField();

        //Creating Text Filed for Role        
        //TextField textField3 = new TextField();
        //Creating Buttons 
        Button button1 = new Button("Submit");

        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();

        //Setting size for the pane 
        gridPane.setMinSize(400, 200);

        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid 
        gridPane.add(text1, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(roleText, 0, 6);
        gridPane.add(roleChoice, 1, 6);
        gridPane.add(button1, 0, 7);

        //Styling nodes  
        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        roleText.setStyle("-fx-font: normal bold 15px 'arial' ");

        text1.setStyle("-fx-font: normal bold 20px 'arial' ");
        text2.setStyle("-fx-font: normal bold 20px 'arial' ");
        gridPane.setStyle("-fx-background-color: white;");

        //Creating a scene object 
        Scene scene = new Scene(gridPane);
        //Setting title to the Stage 
        stage.setTitle("Login");
        //Adding scene to the stage 
        stage.setScene(scene);
        //Displaying the contents of the stage 
        stage.show();

        GridPane managerGridPane = new GridPane();
        managerGridPane.setMinSize(400, 200);

        //Setting the padding  
        managerGridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        managerGridPane.setVgap(5);
        managerGridPane.setHgap(5);

        //Setting the Grid alignment 
        managerGridPane.setAlignment(Pos.CENTER);

        GridPane customerGridPane = new GridPane();
        customerGridPane.setMinSize(400, 200);

        //Setting the padding  
        customerGridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        customerGridPane.setVgap(5);
        customerGridPane.setHgap(5);

        //Setting the Grid alignment 
        customerGridPane.setAlignment(Pos.CENTER);

        button1.setOnAction((ActionEvent event) -> {
            if (roleChoice.getValue().equals("Manager")) {
                Manager manager = new Manager();
                boolean managerLoginSuccess = manager.login(usernameField.getText(), passwordField.getText());
                if (!managerLoginSuccess) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText("Login Failed");
                    alert.setContentText("Incorrect username & password entered");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {

                        }
                    });
                } else {
                    stage.setTitle("Manager Account");

                    Text newUsernameText = new Text("Username");

                    //creating label password 
                    Text newPasswordText = new Text("Password");

                    //Creating Text Filed for Username        
                    TextField newUsernameField = new TextField();

                    //Creating Text Filed for password        
                    PasswordField newPasswordField = new PasswordField();

                    //Creating Text Filed for Role        
                    //TextField textField3 = new TextField();
                    //Creating Buttons 
                    Button addUserButton = new Button("Add User");

                    addUserButton.setOnAction(event1 -> {
                        try {
                            manager.addCustomer(newUsernameField.getText(), newPasswordField.getText());
                        } catch (IOException ex) {
                            Logger.getLogger(BankAccountApplication.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    Text deleteUsernameText = new Text("Delete Username");
                    TextField deleteUsername = new TextField();
                    Button deleteUserButton = new Button("Delete User");

                    deleteUserButton.setOnAction(event2 -> {
                        manager.deleteCustomer(deleteUsername.getText());
                    });

                    Button logoutManagerButton = new Button("Logout");

                    logoutManagerButton.setOnAction(logoutManagerEvent -> {
                        stage.setTitle("Login");
                        //Adding scene to the stage 
                        stage.setScene(scene);
                        //Displaying the contents of the stage 
                        stage.show();
                    });

                    //Arranging all the nodes in the grid 
                    managerGridPane.add(newUsernameText, 0, 0);
                    managerGridPane.add(newUsernameField, 1, 0);
                    managerGridPane.add(newPasswordText, 0, 1);
                    managerGridPane.add(newPasswordField, 1, 1);
                    managerGridPane.add(addUserButton, 0, 7);
                    managerGridPane.add(deleteUsernameText, 0, 8);
                    managerGridPane.add(deleteUsername, 1, 8);
                    managerGridPane.add(deleteUserButton, 0, 9);
                    managerGridPane.add(logoutManagerButton, 0, 10);

                    //Adding scene to the stage 
                    Scene managerScene = new Scene(managerGridPane);

                    stage.setScene(managerScene);
                    //Displaying the contents of the stage 
                    stage.show();
                }

            } else {

                final Customer customer = Customer.getCustomer(usernameField.getText());
                boolean customerLoginSuccess = customer.login(usernameField.getText(), passwordField.getText());

                if (!customerLoginSuccess) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText("Login Failed");
                    alert.setContentText("Incorrect username & password entered");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {

                        }
                    });
                } else {
                    stage.setTitle("Customer Account");

                    Text depositText = new Text("Deposit Amount");
                    TextField depositField = new TextField();
                    Button depositButton = new Button("Deposit");

                    depositButton.setOnAction(event3 -> {
                        final double money = Double.valueOf(depositField.getText());
                        customer.depositMoney(money);
                    });

                    Text withdrawText = new Text("Withdraw Amount");
                    TextField withdrawField = new TextField();
                    Button withdrawButton = new Button("Withdraw");

                    withdrawButton.setOnAction(event4 -> {
                        final double money = Double.valueOf(withdrawField.getText());
                        customer.withdrawMoney(money);
                    });

                    Text onlinePurchaseText = new Text("Online Purchase Amount");
                    TextField onlinePurchaseField = new TextField();
                    Button onlinePurchaseButton = new Button("OnlinePurchase");

                    onlinePurchaseButton.setOnAction(event5 -> {
                        final double money = Double.valueOf(onlinePurchaseField.getText());
                        customer.onlinePurchase(money);
                    });

                    Button getBalanceButton = new Button("Get Balance");
                    getBalanceButton.setOnAction(event6 -> {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Account Balance");
                        alert.setHeaderText("Account Balance");
                        alert.setContentText("Balance = " + customer.getBalance() + " Level = " + customer.getLevel());
                        alert.showAndWait().ifPresent(rs -> {
                            if (rs == ButtonType.OK) {
                                
                            }
                        });

                    });

                    Button logoutCustomerButton = new Button("Logout");

                    logoutCustomerButton.setOnAction(logoutCustomerEvent -> {
                        stage.setTitle("Login");
                        //Adding scene to the stage 
                        stage.setScene(scene);
                        //Displaying the contents of the stage 
                        stage.show();
                    });

                    customerGridPane.add(depositText, 0, 0);
                    customerGridPane.add(depositField, 1, 0);
                    customerGridPane.add(depositButton, 0, 2);

                    customerGridPane.add(withdrawText, 3, 0);
                    customerGridPane.add(withdrawField, 4, 0);
                    customerGridPane.add(withdrawButton, 3, 2);

                    customerGridPane.add(onlinePurchaseText, 5, 0);
                    customerGridPane.add(onlinePurchaseField, 6, 0);
                    customerGridPane.add(onlinePurchaseButton, 5, 2);

                    customerGridPane.add(getBalanceButton, 0, 3);
                    customerGridPane.add(logoutCustomerButton, 0, 4);

                    Scene customerScene = new Scene(customerGridPane);

                    stage.setScene(customerScene);
                    //Displaying the contents of the stage 
                    stage.show();
                }

            }

        });
    }

    public static void main(String args[]) {
        launch(args);
    }
}
