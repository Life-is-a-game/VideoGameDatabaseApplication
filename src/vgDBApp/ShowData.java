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
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class ShowData extends Frame implements ActionListener{

	Label lbl_top = new Label();
	Button returnBtn = new Button();
	Label lbl_name = new Label();
	Label lbl_releaseDate = new Label();
	Container game_img = new Container();
	BufferedImage img = null;
	Label lbl_meta = new Label();
	Label nameTxt = new Label();
	Label rDateTxt = new Label();
	TextArea game_desc = new TextArea();
	Label meta_URL = new Label();
	
	public ShowData(String name, String rDate, String imgURL, String desc, String m_URL) {
		int guiSize = initGUI();
		initWidgets(guiSize, name, rDate, imgURL, desc, m_URL);
	}
	
	public int initGUI() {
		setTitle("Video Game Database Application");
		
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
		//System.out.println(x);
		return size;
	}
	
	public void initWidgets(int size, String name, String release, String imageURL, String desc, String meta) {
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
		
		game_img = new Container();
		game_img.setBounds(10, 250, 100, 250);
		game_img.setVisible(true);
		
		
		lbl_meta = new Label("Metacritic Score: ");
		lbl_meta.setBounds(10, 525, 100, 25);
		
		nameTxt = new Label();
		nameTxt.setBounds(200, 150, size - 240, 25);
		nameTxt.setText(name);
		
		rDateTxt = new Label();
		rDateTxt.setBounds(200, 200, size - 240, 25);
		rDateTxt.setText(release);
		
		game_desc = new TextArea();
		game_desc.setBounds(200, 250, size - 240, 250);
		game_desc.setFocusable(false);
		game_desc.setText(desc);
		
		meta_URL = new Label();
		meta_URL.setBounds(200, 525, size - 240, 25);
		meta_URL.setText(meta);
		
		returnBtn = new Button("Return");
		returnBtn.setBounds(size - 116, 575, 75, 25);
		returnBtn.addActionListener(this);
		
		addWidgets();
		
		Graphics g = game_img.getGraphics();
		
		
		paint(imageURL, g);
		game_img.setIgnoreRepaint(true);
		
		System.err.println(imageURL);
		g.dispose();
		
	}
	
	public void paint(String imageURL, Graphics g) {
		game_img.paintComponents(g);
		game_img.setIgnoreRepaint(true);
		
		BufferedImage img = null;
		try {
			URL iURL = new URL(imageURL);
			img = ImageIO.read(iURL);
		}
		catch(IOException IE) {
			IE.printStackTrace();
		}
		
		g.drawImage(img, 0, 0, 100, 250, null);
		
		
		//game_img.paintComponents(g);
		
		
	}
	
	public void addWidgets() {
		add(lbl_top);
		add(lbl_name);
		add(lbl_releaseDate);
		add(game_img);
		add(lbl_meta);
		add(nameTxt);
		add(rDateTxt);
		add(game_desc);
		add(meta_URL);
		add(returnBtn);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		this.dispose();
		
	}
	
}
