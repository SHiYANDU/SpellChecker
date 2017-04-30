package spellChecker;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//ask operator to propose correction to word, an AWT program so extending frame
@SuppressWarnings("serial")
public class CorrectionProposer extends Frame implements ActionListener, WindowListener{
//	declare components
	private Label wrongWord;
	private TextField wordSpace;
	private Label corrWord;
	private TextField corrSpace;
	private Button submit;
	
//	the wrong word to be corrected
	private String input;
//	the correction proposed
	private String output;
//	flag indicating if the correction has been submitted
	private boolean performed=false;
//	constructor to initialize target word and setup GUI components
	public CorrectionProposer(String wrong){
		input=wrong;
//		set the layout to flow layout
		setLayout(new FlowLayout());
//		construct and add label components
		wrongWord = new Label("Wrong");
		add(wrongWord);
//		construct and add read only field for display the wrong word
		wordSpace= new TextField(input,20);
		wordSpace.setEditable(false);
		add(wordSpace);
//		label for correction
		corrWord = new Label("Correction");
		add(corrWord);
//		construct text field to ask input
		corrSpace= new TextField("",20);
		corrSpace.setEditable(true);
		add(corrSpace);
//		add actionlistner to corrSpace, so actionPerformed method will be called
		corrSpace.addActionListener(this);
//		add the button
		submit = new Button("submit");
		add(submit);
//		add the actionlistner to the button so we can also call the method by pressing submit
		submit.addActionListener(this);
//		add window listener
		addWindowListener(this);
//		set title, size, position and show GUI
		setTitle("Correction");
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		get the correction from textfield
		output = corrSpace.getText();
		setVisible(false);
//		flag that the action have been performed
		performed=true;
		
	}
//	method to get output from external
	public String getCorrection(){
		return output;
	}
	
	public boolean performed(){
		return performed;
	}

//	following methods are implemented to respond window event, some are not implemented but left blank as not used
//	if the window is closed without entering correction, it is assumed that no correction is needed
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {

	}


	@Override
	public void windowClosing(WindowEvent arg0) {
//		assume no correction is needed so output=input
		output = input;
		setVisible(false);
//		flag that the action have been performed
		performed=true;
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
