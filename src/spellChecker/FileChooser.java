package spellChecker;
import javax.swing.*;
import javax.swing.filechooser.*;


import java.io.*;
//choose a file by GUI
public class FileChooser {
//	static file chooser method to be used to get path
	public static String chooseFile(){
//		initialize Filechooser
		JFileChooser chooser= new JFileChooser();
//		set the default directory
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
//		add filter to limit file extension to text and csv files
		FileNameExtensionFilter filter= new FileNameExtensionFilter("text files","txt","csv");
		chooser.setFileFilter(filter);
//		open dialogue box
		int result = chooser.showOpenDialog(null);
//		if user chose a file
		if (result == JFileChooser.APPROVE_OPTION){
			File selected = chooser.getSelectedFile();
//			return the absolute path of the file
			String path = selected.getAbsolutePath();
			return path;
		}
//		if no file selected return null
		else{
			return null;
		}
	}

}
