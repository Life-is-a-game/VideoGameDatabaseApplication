package vgDBApp;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowImg extends Frame implements ActionListener, WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2286601659223351908L;
	
	JLabel img_lbl;
	BufferedImage u_img = null;
	
	public ShowImg(String imageURL) {
		initGUI();
		
		img_lbl = new JLabel();
		img_lbl.setText("");
		img_lbl.setBounds(50, 50, 400, 400);
		img_lbl.setVisible(true);
		
		add(img_lbl);
		
		if(imageURL.equals("N/A")) {
			
		}
		else {
			BufferedImage buff = imageGet(imageURL);
			BufferedImage trueBuff = resize(buff);
			
			img_lbl.setIcon(new ImageIcon(trueBuff));
		}

		this.addWindowListener(this);
	}
	
	public BufferedImage imageGet(String imageURL) {
		try {
			URL iURL = new URL(imageURL);
			u_img = ImageIO.read(iURL);
		}
		catch(MalformedURLException mE){
			
		}
		catch(IOException iE) {
			
		}
		
		return u_img;
	}
	
	public BufferedImage resize(BufferedImage img) {
		Image tmp = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2D = dimg.createGraphics();
		g2D.drawImage(tmp, 0, 0, null);
		g2D.dispose();
		
		return dimg;
	}
	
	public void initGUI() {
		setTitle("Video Game Database Application: Game Image");
		
		Dimension a = getToolkit().getScreenSize();
		double width = a.getWidth();
		double height = a.getHeight();
		
		int size = 500;
		
		if(size != 500) {
			size = 500;
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
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
