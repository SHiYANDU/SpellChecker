package spellChecker;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/** The awt window showing the word to be correct and editable textfield to enter correction
 *  This is a frame and is set up in constructor, the window will close once the correction has been proposed. Closing the window assume no change is needed
 * @author ShiYan
 * @version 1.0
 * @since 2017-04-30
 */
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
	/**Constructor of the class, setting the display of components
	 * it takes a string for the wrong word display empty textfield for correction
	 * @param wrong the wrong word to be corrected
	 */
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
	
	/** get the correction from textfield and signal a change in flag
	 *  so it can be put into correction map
	 */
	@Override

	public void actionPerformed(ActionEvent arg0) {
//		get the correction from textfield
		output = corrSpace.getText();
		setVisible(false);
//		flag that the action have been performed
		performed=true;
		
	}
	/** return the correction as string
	 * 
	 * @return proposed correction
	 */
//	method to get output from external
	public String getCorrection(){
		return output;
	}
	/**return the boolean showing if correction has been made
	 * 
	 * @return boolean action performed or not
	 */
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
	/**respond to closing the window
	 * this make the output to be put in map equal to the wrong word so no change happens
	 */
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
