/**
 * 
 */
package vgDBApp;

/**
 * @author NathanClarke
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class ShowData extends Frame implements ActionListener, WindowListener{

	Label lbl_top = new Label();
	Button returnBtn = new Button();
	Label lbl_name = new Label();
	Label lbl_releaseDate = new Label();
	Button btnShowImage = new Button();
	BufferedImage img = null;
	Label lbl_meta = new Label();
	Label nameTxt = new Label();
	Label rDateTxt = new Label();
	TextArea game_desc = new TextArea();
	Label meta_URL = new Label();
	Graphics g = null;
	String imageUrl;
	String[] appSettings;
	
	public ShowData(String name, String rDate, String imgURL, String desc, String m_URL) throws InterruptedException, IOException, MalformedURLException {
		int guiSize = initGUI();
		imageUrl = imgURL;
		this.addWindowListener(this);
		initWidgets(guiSize, name, rDate, imgURL, desc, m_URL);
		this.setVisible(true);
	}
	
	public int initGUI() {
		setTitle("Video Game Database Application: Game Information");
		
		Dimension a = getToolkit().getScreenSize();
		double width = a.getWidth();
		double height = a.getHeight();
		
		int size = 1000;
		
		if(size != 620) {
			size = 620;
		}
		
		width = (width - size) / 2;
		height = (height - size) / 2;
		
		int x = (int)width;
		int y = (int)height;
		
		setBounds(x, y, size, size);
		setVisible(true);
		setLayout(null);
		return size;
	}
	
	public void initWidgets(int size, String name, String release, String imageURL, String desc, String meta) throws MalformedURLException, IOException {
		lbl_top = new Label("Game Info:");
		lbl_top.setAlignment(Label.CENTER);
		lbl_top.setBounds(0, 30, size, 100);
		lbl_top.setBackground(Color.BLACK);
		lbl_top.setForeground(Color.WHITE);
		Font f = new Font("Centaur", Font.BOLD, 24);
		lbl_top.setFont(f);
		
		lbl_name = new Label("Game Name: ");
		lbl_name.setBounds(10, 150, 100, 25);
		
		lbl_releaseDate = new Label("Release Date: ");
		lbl_releaseDate.setBounds(10, 200, 100, 25);
		
//		lbl2 = new JLabel();
//		lbl2.setText("");
//		lbl2.setBounds(10, 250, 100, 250);
//		lbl2.setVisible(true);
		
		
		lbl_meta = new Label("Metacritic URL: ");
		lbl_meta.setBounds(10, 525, 100, 25);
		
		nameTxt = new Label();
		nameTxt.setBounds(200, 150, size - 240, 25);
		nameTxt.setText(name);
		
		rDateTxt = new Label();
		rDateTxt.setBounds(200, 200, size - 240, 25);
		rDateTxt.setText(release);
		
		game_desc = new TextArea();
		game_desc.setBounds(10, 250, size - 20, 250);
		game_desc.setFocusable(false);
		game_desc.setText(desc);
		
		meta_URL = new Label();
		meta_URL.setBounds(200, 525, size - 240, 25);
		meta_URL.setText(meta);
		
		returnBtn = new Button("Return");
		returnBtn.setBounds(size - 116, 575, 75, 25);
		returnBtn.setName("btnReturn");
		returnBtn.addActionListener(this);
		
		btnShowImage = new Button("Show Image");
		btnShowImage.setBounds(10, 575, 75, 25);
		btnShowImage.setName("btnShow");
		btnShowImage.addActionListener(this);
		
		addWidgets();
	}
	
	public void addWidgets() {
		add(lbl_top);
		add(lbl_name);
		add(lbl_releaseDate);
		add(btnShowImage);
		add(lbl_meta);
		add(nameTxt);
		add(rDateTxt);
		add(game_desc);
		add(meta_URL);
		add(returnBtn);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		switch(((Button)e.getSource()).getName()){
			default:
				break;
			case "btnReturn":
				this.dispose();
				break;
			case "btnShow":
				ShowImg appC = new ShowImg(imageUrl);
				break;
		}
		
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
