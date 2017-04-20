package view;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class FormTwoPanel extends JPanel{
	private JTextField branchOneCount = null, branchTwoCount = null, branchThreeCount = null;
	private JLabel anokaLabel = null, minneapolisLabel = null, ramseyLabel = null, branchTitle = null, empTitle = null;
	private GroupLayout layout = null;
	
	public FormTwoPanel(){
		this.branchOneCount = new JTextField("");
		this.branchOneCount.setEditable(false);
		
		this.branchTwoCount = new JTextField("");
		this.branchTwoCount.setEditable(false);
		
		this.branchThreeCount = new JTextField("");
		this.branchThreeCount.setEditable(false);
		
		this.anokaLabel = new JLabel("Anoka Minnestar Emotional Health Services");
		this.minneapolisLabel = new JLabel("Minneapolis Minnestar Emotional Health Services");
		this.ramseyLabel = new JLabel("Ramsey Minnestar Emotional Health Services");
		this.branchTitle = new JLabel("Branches");
		this.empTitle = new JLabel("Employee Count");
		
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
				.addComponent(this.branchTitle)
				.addComponent(this.anokaLabel)
				.addComponent(this.minneapolisLabel)
				.addComponent(this.ramseyLabel)
				)
		
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.empTitle)
				.addComponent(this.branchOneCount)
				.addComponent(this.branchTwoCount)
				.addComponent(this.branchThreeCount)
				)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE )
		);
		
		//vertical group
		this.layout.setVerticalGroup(layout.createSequentialGroup()	
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.branchTitle)
					.addComponent(this.empTitle))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.anokaLabel)
					.addComponent(this.branchOneCount))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.minneapolisLabel)
					.addComponent(this.branchTwoCount))
			
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.ramseyLabel)
					.addComponent(this.branchThreeCount))
		);
	}

	
	public JTextField getBranchOneCount() {
		return branchOneCount;
	}

	public JTextField getBranchTwoCount() {
		return branchTwoCount;
	}

	public JTextField getBranchThreeCount() {
		return branchThreeCount;
	}

	
}
