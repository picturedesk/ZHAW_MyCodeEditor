package ch.picturedesk.myEditor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuArea extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 835572973667864369L;
	private EditorFrame editorFrame;

	public MenuArea(EditorFrame editorFrame) {
		super();
		this.editorFrame = editorFrame;

	    this.add(fileMenu());   
	}

	private JMenu fileMenu() {
		JMenu fileMenu = new JMenu("File");
		
	    JMenuItem newItem = new JMenuItem("New File");
	    fileMenu.add(newItem);
	    newItem.addActionListener(new ActionListener() {
	      
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  	editorFrame.getFileHandler().saveFile(editorFrame);
	      }
	    });
	    
	    JMenuItem loadItem = new JMenuItem("Open File");
	    fileMenu.add(loadItem);
	    loadItem.addActionListener(new ActionListener() {
	      
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        editorFrame.getFileHandler().openFile(editorFrame);
	      }
	    });
	    
	    JMenuItem saveItem = new JMenuItem("Save File");
	    fileMenu.add(saveItem);
	    saveItem.addActionListener(new ActionListener() {
	      
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  	editorFrame.getFileHandler().saveFile(editorFrame, editorFrame.getWorkArea().getPath());
	      }
	    });
	    
	    JMenuItem exitItem = new JMenuItem("Exit");
	    fileMenu.add(exitItem);
	    exitItem.addActionListener(new ActionListener() {
	      
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  	int wertInt = JOptionPane.showConfirmDialog(null, "You want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
			if (wertInt == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
	      }
	    });
	    
		return fileMenu;
	}
}
