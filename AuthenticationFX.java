import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AuthenticationFX extends Application {
	
	private int attempt=0;
	public enum AccountType {
		SelectAccount, Administrator, Student, Staff, Guest
		}
	
	public static void main(String[] args) {
		
			launch(args);
			
	}
	@Override
	public void start(Stage primaryStage) {
		final int LIMIT = 3;
		Alert alert = new Alert(AlertType.INFORMATION);
		String correctUName = "abdul";
		String correctPw = "password";
		AccountType correctAcType =AccountType.Student;
		
		TextField usernameTxt = new TextField();
		usernameTxt.setText("Username");
		PasswordField passwordField = new PasswordField();
		passwordField.setText("password");
		ComboBox <AccountType>comboBox = new ComboBox<>();
		comboBox.getItems().addAll(AccountType.SelectAccount, AccountType.Administrator, AccountType.Student, AccountType.Staff, AccountType.Guest);
		comboBox.setValue(AccountType.SelectAccount);
		comboBox.setVisible(false);
		
		Button submitBtn = new Button("Log in");
		submitBtn.setOnAction(e-> {
			if(usernameTxt.getText().equals(correctUName) && passwordField.getText().equals(correctPw) && attempt<=LIMIT) {
				comboBox.setVisible(true);
			
			} else if (attempt<LIMIT){
				alert.setContentText("Your username or password is incorrect!");
				alert.showAndWait();
				attempt++;
			} else if(attempt>=LIMIT) {
				alert.setContentText("Please contact your administrator to unlock your account!");
				alert.showAndWait();
			}
	});
		comboBox.setOnAction(e-> {
			if(comboBox.getValue().equals(correctAcType)) {
				alert.setContentText("Welcome " + correctUName + "!");
				alert.showAndWait();
				} else if(!comboBox.getValue().equals(correctAcType)) {
					alert.setContentText("Wrong Account Type! Please select the account type again!");
					alert.showAndWait();
				
		}
		});
		
		VBox pane = new VBox();
		pane.getChildren().addAll(usernameTxt,passwordField,comboBox,submitBtn);
		
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Authentication");
			primaryStage.setScene(scene);	
			primaryStage.show();
	}
}
	
					


