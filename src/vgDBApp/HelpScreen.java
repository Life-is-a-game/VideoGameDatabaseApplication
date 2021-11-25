package vgDBApp;

import java.awt.*;
import java.awt.event.*;

public class HelpScreen extends Frame implements ActionListener, WindowListener{

	public HelpScreen(){
		initGUI();
	}
	
	public void initGUI() {
		setTitle("Video Game Database Application: Help");
		
		Dimension a = getToolkit().getScreenSize();
		double width = a.getWidth();
		double height = a.getHeight();
		
		int size = 600;
		
		if(size != 600) {
			size = 600;
		}
		
		if(size > height) {
			size = (int)height - 250;
		}
		
		width = (width - size) / 2;
		height = (height - size) / 2;
		
		int x = (int)width;
		int y = (int)height;
		
		setBounds(x, y, size, size);
		setVisible(true);
		setLayout(null);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.dispose();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
