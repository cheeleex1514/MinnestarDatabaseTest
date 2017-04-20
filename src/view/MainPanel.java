package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JFrame{
	private CardLayout cardLayout = null;
	private JPanel introPanel=null, formOnePanel=null, formTwoPanel=null, formThreePanel=null,
				   baseNorthPanel=null, baseCenterPanel=null, baseSouthPanel=null, baseWestPanel=null, baseEastPanel=null,
				   containerPanel=null, cardLayoutPanel=null;
	
	private JButton formOneButton=null, formTwoButton=null, formThreeButton=null;	
	
	private FormOnePanel formOne = null; 
	private FormTwoPanel formTwo = null;
	private FormThreePanel formThree = null;
	
	//constructor
	public MainPanel(){	
        this.formOneButton 		= new JButton("FormOne");
        this.formTwoButton 		= new JButton("FormTwo");
        this.formThreeButton 	= new JButton("FormThree");
		
        //initiailize containerPanel
        containerPanel = new JPanel();
        
		//initialize opening panel
		this.introPanel = new JPanel();
		introPanel.setLayout(new GridBagLayout());
		JLabel intro = new JLabel("Minnestar Emotional Health Services");
		introPanel.add(intro);
		
		//initialize form one panel
		this.formOne = new FormOnePanel();
		this.formOnePanel = formOne;
		
		//initialize form two panel
		this.formTwo = new FormTwoPanel();
		this.formTwoPanel = formTwo;
		
		//initialize form three panel
		this.formThree = new FormThreePanel();
		this.formThreePanel = formThree;
		
		//initialize center container panel, this will swap the forms
		this.cardLayout = new CardLayout();
		this.cardLayoutPanel = new JPanel();
		this.cardLayoutPanel.setLayout(cardLayout);
		
		this.cardLayoutPanel.add(introPanel, "intro");
		this.cardLayoutPanel.add(formOnePanel, "formOne");
		this.cardLayoutPanel.add(formTwoPanel, "formTwo");
		this.cardLayoutPanel.add(formThreePanel, "formThree");
		
		this.cardLayout.show(cardLayoutPanel, "intro");
		
		//initialize base panels for boarder layout
		this.baseNorthPanel = new JPanel();
		
		this.baseCenterPanel = new JPanel();
		this.baseCenterPanel.add(cardLayoutPanel, BorderLayout.CENTER);
		
		this.baseSouthPanel = new JPanel();
		
		this.baseWestPanel = new JPanel();
		this.baseWestPanel.setLayout(new GridLayout(0,1));
		this.baseWestPanel.add(this.formOneButton);
		this.baseWestPanel.add(this.formTwoButton);
		this.baseWestPanel.add(this.formThreeButton);
		
		this.baseEastPanel = new JPanel();
		
		//add base containers to boarderLayout
		containerPanel.setLayout(new BorderLayout());
		containerPanel.add(baseNorthPanel, BorderLayout.NORTH);
		containerPanel.add(baseCenterPanel, BorderLayout.CENTER);
		containerPanel.add(baseSouthPanel, BorderLayout.SOUTH);
		containerPanel.add(baseWestPanel, BorderLayout.WEST);
		containerPanel.add(baseEastPanel, BorderLayout.EAST);
		
		//add to JFrame
		this.add(containerPanel);
		this.setTitle("Minnestar Database");
		this.pack();
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addFormOneButtonListener(ActionListener listenContinueDayButton){
		this.formOneButton.addActionListener(listenContinueDayButton);
	}
	
	public void addFormTwoButtonListener(ActionListener listenContinueDayButton){
		this.formTwoButton.addActionListener(listenContinueDayButton);
	}
	
	public void addFormThreeButtonListener(ActionListener listenContinueDayButton){
		this.formThreeButton.addActionListener(listenContinueDayButton);
	}	
	
	public void setCardLayout(String name)
	{
		System.out.println("Passing string: "+name);
		if(name == "formOne"){
			System.out.println("Setting formOne");
			this.cardLayout.show(cardLayoutPanel, "formOne");
		}
		
		if(name == "formTwo"){
			System.out.println("Setting formTwo");
			this.cardLayout.show(cardLayoutPanel, "formTwo");
		}
		
		if(name == "formThree"){
			System.out.println("Setting formThree");
			this.cardLayout.show(cardLayoutPanel, "formThree");
		}
		
	}

	public FormOnePanel getFormOne() {
		return formOne;
	}

	public FormTwoPanel getFormTwo() {
		return formTwo;
	}

	public FormThreePanel getFormThree() {
		return formThree;
	}
		
		
}
