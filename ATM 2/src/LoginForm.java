
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm {

	Stage stage;
	Scene scene;
	MyATM authentaction;
	HomeScreen homeScreen;
	
	public LoginForm(Stage stage) {
		this.stage=stage;
	}

	public void prepareScene() {
		
		authentaction= new MyATM();
		
	//drawing--------------------------------------------------------------------------		
		Label cardNumberLabel = new Label ("Enter your card number:");
		TextField cardNumberField = new TextField(); 		
		Button loginButton = new Button("Login");
		Label validationLabel = new Label();
		
		GridPane grid = new GridPane();
		grid.add(cardNumberLabel,0,1);
		grid.add(cardNumberField,1,1);
		grid.add(loginButton,1,2);
		grid.add(validationLabel,6,3);
    //end of drawing--------------------------------------------------------------------------		
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				String cardNumber = cardNumberField.getText();
				boolean valid =authentaction.validate(cardNumber);
				
				if(valid) 
				     stage.setScene(homeScreen.getScene());
				
				else
					validationLabel.setText("Error.Invalid card number");
			}
			});	
		scene=new Scene (grid,600,400);
	}

	public Scene getScene() {return this.scene;}
	
	public void setHomeScreen(HomeScreen homeScreen) {
		this.homeScreen=homeScreen;
	}
}
