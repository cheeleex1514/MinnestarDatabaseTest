package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;
import model.ModelFactory;
import view.MainPanel;

public class Container{
	private MainPanel theView;
	private Client client;
	private ModelFactory factory;
	
	public Container() {
		factory = new ModelFactory();
		this.client = new Client(factory.getDatabaseConnection());
		this.theView = new MainPanel();
		
		this.theView.addFormOneButtonListener(new ListenerForFormOneButton());
		this.theView.addFormTwoButtonListener(new ListenerForFormTwoButton());
		this.theView.addFormThreeButtonListener(new ListenerForFormThreeButton());
	}
	
	public void run(){
	}
	
	class ListenerForFormOneButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Performing formOne cardLayoutSwap.");
			theView.setCardLayout("formOne");
			
			ResultSet databaseResponse = client.initiateSelectQuery("select * from view_client");
			
			ArrayList<ArrayList> results = new ArrayList<ArrayList>();
			
			try {
	    		while(databaseResponse.next()){
	    			ArrayList<String> temp = new ArrayList<String>();
	    			
					for(int x = 1; x <= databaseResponse.getMetaData().getColumnCount();x++){
						temp.add(databaseResponse.getString(x));
					}
					
					results.add(temp);			
				}
	    		
			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
			
			System.out.println("Size: "+results.size());
			
			theView.getFormOne().setQueryResults(results);
			theView.getFormOne().getClientIdTextField().setText(results.get(0).get(0).toString());
			theView.getFormOne().getClientFirstNameTextField().setText(results.get(0).get(1).toString());
			theView.getFormOne().getClientMiddleNameTextField().setText(results.get(0).get(2).toString());
			theView.getFormOne().getClientLastNameTextField().setText(results.get(0).get(3).toString());
			theView.getFormOne().getClientEmailTextField().setText(results.get(0).get(4).toString());
		}
	}
	
	class ListenerForFormTwoButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Performing formTwo cardLayoutSwap.");
			theView.setCardLayout("formTwo");
			
			String secondQuery ="select branch.branch_name as 'Branch', count(employee.emp_id) as 'Employee count' from branch join employee on branch.branch_id = employee.branch_id group by branch.branch_name";
			ResultSet databaseResponse = client.initiateSelectQuery(secondQuery);
			
			ArrayList<ArrayList> resultsTwo = null;
			resultsTwo = new ArrayList<ArrayList>();
			
			try {
	    		while(databaseResponse.next()){
	    			ArrayList<String> temp = new ArrayList<String>();
	    			
					for(int x = 1; x <= databaseResponse.getMetaData().getColumnCount();x++){
						temp.add(databaseResponse.getString(x));
					}
					
					resultsTwo.add(temp);			
				}
	    		
			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
			
			theView.getFormTwo().getBranchOneCount().setText(resultsTwo.get(0).get(1).toString());
			theView.getFormTwo().getBranchTwoCount().setText(resultsTwo.get(1).get(1).toString());
			theView.getFormTwo().getBranchThreeCount().setText(resultsTwo.get(2).get(1).toString());
		}
	}
	
	class ListenerForFormThreeButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Performing formThree cardLayoutSwap.");
			theView.setCardLayout("formThree");
			theView.getFormThree().setClient(client);
		}
	}

}
