package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormOnePanel extends JPanel{
	private JTextField clientIdTextField			=null, 
			   		   clientFirstNameTextField		=null, 
			   		   clientLastNameTextField		=null, 
			   		   clientMiddleNameTextField	=null, 
			   		   clientEmailTextField			=null;
	
	private JLabel clientIdLabel	= null,
			clientFirstNameLabel	= null, 
			clientLastNameLabel		= null, 
			clientMiddleNameLabel	= null, 
			clientEmailLabel		= null;
	
	private JButton firstButton = null,
					nextButton = null,
					previousButton = null,
					lastButton = null;
	
	private GroupLayout layout = null;
	
	private ArrayList<ArrayList> queryResults = null;
	private int indexCount;
	
	public FormOnePanel(){	
		indexCount = 0;
		
		//initialize jTextFields
		this.clientIdTextField 			= new JTextField("");
		this.clientIdTextField.setEditable(false);
		
		this.clientFirstNameTextField 	= new JTextField("");
		this.clientFirstNameTextField.setEditable(false);
		
		this.clientLastNameTextField 	= new JTextField("");
		this.clientLastNameTextField.setEditable(false);
		
		this.clientMiddleNameTextField 	= new JTextField("");
		this.clientMiddleNameTextField.setEditable(false);
		
		this.clientEmailTextField 		= new JTextField("");
		this.clientEmailTextField.setEditable(false);
		
		//initialize jbuttons
		this.firstButton 		= new JButton("First"); 
		firstButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				indexCount = 0;
				System.out.println("firstButton pressed: "+indexCount);
				clientIdTextField.setText(queryResults.get(indexCount).get(0).toString());
				clientFirstNameTextField.setText(queryResults.get(indexCount).get(1).toString());
				clientMiddleNameTextField.setText(queryResults.get(indexCount).get(2).toString());
				clientLastNameTextField.setText(queryResults.get(indexCount).get(3).toString());
				clientEmailTextField.setText(queryResults.get(indexCount).get(4).toString());			
			} 
		});
		
		this.nextButton 		= new JButton("Next");
		nextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(indexCount < queryResults.size()-1){
					indexCount++;
					System.out.println("nextButton pressed: "+indexCount);
					clientIdTextField.setText(queryResults.get(indexCount).get(0).toString());
					clientFirstNameTextField.setText(queryResults.get(indexCount).get(1).toString());
					clientMiddleNameTextField.setText(queryResults.get(indexCount).get(2).toString());
					clientLastNameTextField.setText(queryResults.get(indexCount).get(3).toString());
					clientEmailTextField.setText(queryResults.get(indexCount).get(4).toString());
				}			
			} 
		});
		
		this.previousButton 	= new JButton("Previous");
		previousButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(indexCount > 0){
					indexCount--;
					System.out.println("previousButton pressed: "+indexCount);
					clientIdTextField.setText(queryResults.get(indexCount).get(0).toString());
					clientFirstNameTextField.setText(queryResults.get(indexCount).get(1).toString());
					clientMiddleNameTextField.setText(queryResults.get(indexCount).get(2).toString());
					clientLastNameTextField.setText(queryResults.get(indexCount).get(3).toString());
					clientEmailTextField.setText(queryResults.get(indexCount).get(4).toString());
				}			
			} 
		});
		
		this.lastButton			= new JButton("Last");
		lastButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				indexCount = queryResults.size()-1;
				System.out.println("lastButton pressed: "+indexCount);
				clientIdTextField.setText(queryResults.get(indexCount).get(0).toString());
				clientFirstNameTextField.setText(queryResults.get(indexCount).get(1).toString());
				clientMiddleNameTextField.setText(queryResults.get(indexCount).get(2).toString());
				clientLastNameTextField.setText(queryResults.get(indexCount).get(3).toString());
				clientEmailTextField.setText(queryResults.get(indexCount).get(4).toString());
			} 
		});
		
		//initialize jLables
		this.clientIdLabel 			= new JLabel("Client Id:");
		this.clientFirstNameLabel 	= new JLabel("First name:");
		this.clientLastNameLabel 	= new JLabel("Last name: ");
		this.clientMiddleNameLabel 	= new JLabel("Middle: ");
		this.clientEmailLabel 		= new JLabel("Email: ");
		
		//initialize layout
		this.layout = new GroupLayout(this);
		
		this.setPreferredSize(new Dimension(500,250));
		constructPanel();
		
	}
	
	private void constructPanel(){
		this.setLayout(layout);
		this.layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//horizontal group
		this.layout.setHorizontalGroup(layout.createSequentialGroup()
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE )
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.clientIdLabel)
				.addComponent(this.clientFirstNameLabel)
				.addComponent(this.clientMiddleNameLabel)
				.addComponent(this.clientLastNameLabel)
				.addComponent(this.clientEmailLabel)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(this.firstButton)
						.addComponent(this.nextButton)))
				)
		
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.clientIdTextField)
				.addComponent(this.clientFirstNameTextField)
				.addComponent(this.clientMiddleNameTextField)
				.addComponent(this.clientLastNameTextField)
				.addComponent(this.clientEmailTextField)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(this.previousButton)
						.addComponent(this.lastButton)))
				)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE )
		);
		
		//vertical group
		this.layout.setVerticalGroup(layout.createSequentialGroup()	
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.clientIdLabel)
					.addComponent(this.clientIdTextField))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.clientFirstNameLabel)
					.addComponent(this.clientFirstNameTextField))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.clientMiddleNameLabel)
					.addComponent(this.clientMiddleNameTextField))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.clientLastNameLabel)
					.addComponent(this.clientLastNameTextField))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.clientEmailLabel)
					.addComponent(this.clientEmailTextField))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(this.firstButton)
						.addComponent(this.nextButton)))
					
					.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(this.previousButton)
						.addComponent(this.lastButton)))
					)
		);
	}

	public JTextField getClientIdTextField() {
		return clientIdTextField;
	}

	public JTextField getClientFirstNameTextField() {
		return clientFirstNameTextField;
	}

	public JTextField getClientLastNameTextField() {
		return clientLastNameTextField;
	}

	public JTextField getClientMiddleNameTextField() {
		return clientMiddleNameTextField;
	}

	public JTextField getClientEmailTextField() {
		return clientEmailTextField;
	}

	public void setQueryResults(ArrayList<ArrayList> results) {
		this.queryResults = results;
	}

	//add buttonListeners
	public void addFirstButtonListener(ActionListener listenForStartButton){
		this.firstButton.addActionListener(listenForStartButton);
	}
	
	public void addNextButtonListener(ActionListener listenContinueNightButton){
		this.nextButton.addActionListener(listenContinueNightButton);
	}
	
	public void addPreviousButtonListener(ActionListener listenContinueDayButton){
		this.previousButton.addActionListener(listenContinueDayButton);
	}
	
	public void addLastButtonListener(ActionListener listenContinueDayButton){
		this.lastButton.addActionListener(listenContinueDayButton);
	}
}
