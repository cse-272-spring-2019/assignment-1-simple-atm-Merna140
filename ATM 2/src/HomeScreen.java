import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScreen {
	
	Stage stage;
	Scene scene;
	Scene scene2,scene3,scene4,scene5;
	MyATM authentaction;
	LoginForm loginForm;
	
	public HomeScreen(Stage stage) {
		this.stage=stage;
	}

	public void prepareScene() {
		
		authentaction= new MyATM();
		
	//drawing--------------------------------------------------------------------------			
		Button deposit = new Button("Deposit");
		Button withdrawal = new Button("Withdrawal");
		Button balanceInquiry = new Button("Balance Inquiry");
		Button next = new Button("Next");
		Button previous = new Button("Previous");
		
		GridPane grid = new GridPane();
		grid.add(deposit,0,0);
		grid.add(withdrawal,2,0);
		grid.add(balanceInquiry,1,1);
		grid.add(next,2,2);
		grid.add(previous,0,2);
    //end of drawing--------------------------------------------------------------------------		
		
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				
		    //drawing--------------------------------------------------------------------------		
      			Label depositArea = new Label("Enter your deposit amount");
				TextField depositAmount = new TextField(); 		
				Button okay = new Button("Okay");
				Label validationLabel = new Label();
				
				GridPane grid2 = new GridPane();
				grid2.add(depositArea,0,0);
				grid2.add(depositAmount,2,0);
				grid2.add(okay,2,1);
				grid2.add(validationLabel,2,2);
		    //end of drawing--------------------------------------------------------------------------		
						
			okay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
			public void handle(ActionEvent arg0) {								
				   try {
						double Damount = Double.parseDouble(depositAmount.getText()); 
						if(Damount<0) {
							validationLabel.setText("Error.Invalid deposit amount");									
						}
						  else {					        
						    stage.setScene(getScene());
							authentaction.deposit(Damount);						
					   	}
				   } catch (NumberFormatException e) {
					validationLabel.setText("Error.Invalid deposit amount");									
					}
				}
					});						
				scene2=new Scene (grid2,600,400);			 
				stage.setScene(scene2);			
			}
			});		
		
		withdrawal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				
		    //drawing--------------------------------------------------------------------------		
      			Label withdrawalArea = new Label("Enter your withdrawal amount");
				TextField withdrawalAmount = new TextField(); 		
				Button okay = new Button("Okay");
				Label validationLabel = new Label();
				
				GridPane grid2 = new GridPane();
				grid2.add(withdrawalArea,0,0);
				grid2.add(withdrawalAmount,2,0);
				grid2.add(okay,2,1);
				grid2.add(validationLabel,2,2);
		    //end of drawing--------------------------------------------------------------------------		
						
			okay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
			public void handle(ActionEvent arg0) {										
			      try {
					 double Wamount = Double.parseDouble(withdrawalAmount.getText()); 
					 double checkBalance = authentaction.balance();
											
					 if(Wamount<0 || Wamount>checkBalance) {
					 validationLabel.setText("Error.Invalid withdrawal amount");
					 }														
					 
					  else {
					   stage.setScene(getScene());
					   authentaction.withdrawal(Wamount);
					  }
				  } catch (NumberFormatException e) {
					validationLabel.setText("Error.Invalid withdrawal  amount");									
				   }
			}
					});				
				scene2=new Scene (grid2,600,400);			 
				stage.setScene(scene2);		
			}
			});	
				
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {				
	      //drawing--------------------------------------------------------------------------		
				Label showingBalance = new Label();
				Button okay = new Button("Okay");

				GridPane grid3 = new GridPane();
				grid3.add(showingBalance,2,2);
				grid3.add(okay,2,3);
		 //end of drawing--------------------------------------------------------------------------		
	
				double balance =authentaction.balance();
				showingBalance.setText("Your Balance Is "+balance+"L.E");
				
				okay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {				
					        stage.setScene(getScene());
						}
					});	
				scene3=new Scene (grid3,600,400);			 
				stage.setScene(scene3);
			}
			});
		
		previous.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {				
		 //drawing--------------------------------------------------------------------------		
				Label showingTransaction = new Label();
				Button okay = new Button("Okay");

				GridPane grid4 = new GridPane();
				grid4.add(showingTransaction,2,2);
				grid4.add(okay,2,3);
		 //end of drawing--------------------------------------------------------------------------		

				String name = authentaction.TransactionName1();
				double value =authentaction.TransactionValue1();
				showingTransaction.setText("Your Transaction Is "+ name + value);
				
				okay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {				
					        stage.setScene(getScene());
						}
					});	
				
				scene4=new Scene (grid4,600,400);			 
				stage.setScene(scene4);
			}
			});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {				
	    //drawing--------------------------------------------------------------------------		
				Label showingTransaction = new Label();
				Button okay = new Button("Okay");

				GridPane grid5 = new GridPane();
				grid5.add(showingTransaction,2,2);
				grid5.add(okay,2,3);
		 //end of drawing--------------------------------------------------------------------------		

				String name = authentaction.TransactionName2();
				double value =authentaction.TransactionValue2();
				showingTransaction.setText("Your Transaction Is "+ name + value);
				
				okay.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {				
					        stage.setScene(getScene());
						}
					});					
				scene5=new Scene (grid5,600,400);			 
				stage.setScene(scene5);
			}
			});
		 scene=new Scene (grid,600,400);	 
   }
	
	public Scene getScene() {return this.scene;}
		
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm=loginForm;
	}	
}