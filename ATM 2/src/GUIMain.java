import javafx.application.Application;
import javafx.stage.Stage;

public class GUIMain extends Application {
	
	public static void main (String[]args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		primaryStage.setTitle("ATM Application");
		LoginForm loginForm = new LoginForm(primaryStage);
		HomeScreen homeScreen = new HomeScreen(primaryStage);

		loginForm.prepareScene();
		homeScreen.prepareScene();
		
		loginForm.setHomeScreen(homeScreen);

		primaryStage.setScene(loginForm.getScene());
		primaryStage.show();
	}
}
