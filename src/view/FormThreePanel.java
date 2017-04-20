package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Client;

public class FormThreePanel extends JPanel{
	private JLabel assetTableLabel = null, assetMakerLabel = null, assetTypeLabel = null, assetEmpIdLabel = null, emptyLabel = null;
	private JButton submitButton = null;
	private JTextField assetIdSelectionField = null, assetMakerTextField = null, assetTypeTextField = null, assetEmpId = null;
	private GroupLayout layout;
	private Client client;
	
	public FormThreePanel(){
		//initialize JLabels
		this.assetTableLabel = new JLabel("Asset Code:");
		this.assetMakerLabel = new JLabel("Asset Maker:");
		this.assetTypeLabel = new JLabel("Asset Type:");
		this.assetEmpIdLabel = new JLabel("Employee Assigned:");
		this.emptyLabel = new JLabel("");
		
		//initialize JtextFields
		this.assetIdSelectionField = new JTextField("");
		
		this.assetMakerTextField = new JTextField("null");
		this.assetMakerTextField.setEditable(false);
		
		this.assetTypeTextField = new JTextField("null");
		this.assetTypeTextField.setEditable(false);
		
		this.assetEmpId = new JTextField("null");
		this.assetEmpId.setEditable(false);
		
		//initialize JButton
		this.submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String thirdQuery = "select * from asset where asset_id = '"+assetIdSelectionField.getText()+"'";
				System.out.println("Submitting query: "+thirdQuery);
				
				ArrayList<ArrayList> results = new ArrayList<ArrayList>();
				
				try {
					ResultSet databaseResponse = client.initiateSelectQuery(thirdQuery);
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
				
				System.out.println("submitButton pressed: "+ results.size());
				
				if(results.size() > 0)
				{
					assetMakerTextField.setText(results.get(0).get(1).toString());
					assetTypeTextField.setText(results.get(0).get(2).toString());
					assetEmpId.setText(results.get(0).get(3).toString());
				}else{
					assetMakerTextField.setText("null");
					assetTypeTextField.setText("null");
					assetEmpId.setText("null");
				}
								
			} 
		});
		
		this.layout = new GroupLayout(this);
		
		this.setPreferredSize(new Dimension(500,250));
		constructPanel();
	}

	private void constructPanel() {
		this.setLayout(layout);
		this.layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//horizontal group
		this.layout.setHorizontalGroup(layout.createSequentialGroup()
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE )
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.assetTableLabel)
				.addComponent(this.assetIdSelectionField)
				.addComponent(this.emptyLabel)
				.addComponent(this.assetMakerLabel)
				.addComponent(this.assetTypeLabel)
				.addComponent(this.assetEmpIdLabel)
				)
		
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.emptyLabel)
				.addComponent(this.submitButton)
				.addComponent(this.emptyLabel)
				.addComponent(this.assetMakerTextField)
				.addComponent(this.assetTypeTextField)
				.addComponent(this.assetEmpId)
				)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE )
		);
		
		//vertical group
		this.layout.setVerticalGroup(layout.createSequentialGroup()	
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.assetTableLabel)
					.addComponent(this.emptyLabel))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.assetIdSelectionField)
					.addComponent(this.submitButton))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.emptyLabel)
					.addComponent(this.emptyLabel))
					
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.assetMakerLabel)
					.addComponent(this.assetMakerTextField))
					
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.assetTypeLabel)
					.addComponent(this.assetTypeTextField))
					
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.assetEmpIdLabel)
					.addComponent(this.assetEmpId))
		);		
	}

	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
