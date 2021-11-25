package vgDBApp;

/**
 * 
 * @author NathanClarke
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class VGDBApp extends Frame implements ActionListener, WindowListener{

	/**
	 * TODO:
	 * Fix showing image to user
	 */
	private static final long serialVersionUID = 1L;
	
	Label lbl = new Label();
	JLabel lbl_help = new JLabel();
	boolean check = true;
	TextField gameChoice = new TextField();
	Button btn_sub = new Button();
	
	String name = "";
	String releaseDate = "";
	String desc_raw = "";
	String metaURL = "";
	String imageURL = "";
	java.util.List<String> settingList = new ArrayList<String>();
	
	public VGDBApp(){
		initGUI();
		this.addWindowListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		String btnName = ((Button)event.getSource()).getName();
		
		switch(btnName) {
			default:
				break;
			case "SubmitBtn":
				try {
					
					String choice = gameChoice.getText();
					connectToAPI(choice);
					
					if(check == true) {
						ShowData appB = new ShowData(name, releaseDate, imageURL, desc_raw, metaURL);
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				catch(InterruptedException iE) {
					
				}
				break;
		}
	}
	
	public void initGUI() {
		setTitle("Video Game Database Application");
		
		Dimension a = getToolkit().getScreenSize();
		double width = a.getWidth();
		double height = a.getHeight();
		
		int size = 200;
		
		if(size != 200) {
			size = 200;
		}
		
		if(size > height) {
			size = (int)height - 250;
		}
		
		width = (width - size) / 2;
		height = (height - size) / 2;
		
		int x = (int)width;
		int y = (int)height;
		
		setBounds(x, y, size * 2, size);
		setVisible(true);
		setLayout(null);
		
		initWidgets(size, size * 2);
	}
	
	public void initWidgets(int height, int width) {
		lbl = new Label("Input Game Here:");
		lbl.setBounds(10, 50, 150, 25);
		
		gameChoice = new TextField();
		gameChoice.setBounds(175, 50, width - 10 - 175 , 25);
		
		btn_sub = new Button("Submit");
		btn_sub.setBounds(width - 111, 110, 100, 25);
		btn_sub.setName("SubmitBtn");
		btn_sub.setForeground(Color.WHITE);
		btn_sub.setBackground(Color.BLACK);
		btn_sub.addActionListener(this);
		
		lbl_help = new JLabel();
		lbl_help.setText("");
		lbl_help.setBounds(10, 340, 50, 50);
		
		
		add(lbl);
		add(lbl_help);
		add(gameChoice);
		add(btn_sub);
	}
	
	public void connectToAPI(String str) throws IOException {
		String getId = recieveJSON(str, 0);
		
		if(getId.startsWith("0", 9)) {
			System.err.println("There were no results for that search term, please try again.\n");
			check = false;
		}
		else {	
			JSONObject jsonObj = new JSONObject(getId);
			
			JSONArray results = jsonObj.getJSONArray("results");
			
			int gID = results.getJSONObject(0).getInt("id");
			
			String trueJSON = recieveJSON(str, gID);
			
			
			JSONObject finalObj = new JSONObject(trueJSON);
			
			name = finalObj.getString("name");
			
			
			if(finalObj.isNull("released")) {
				releaseDate = "N/A";
			}
			else {
				releaseDate = finalObj.getString("released");
			}
			
			desc_raw = finalObj.getString("description_raw");
			desc_raw = desc_raw.replaceAll("’", "'");
			desc_raw = desc_raw.replaceAll("™", "");
			
			if(desc_raw.equals("")) {
				desc_raw = finalObj.getString("description");
			}
			
			metaURL = finalObj.getString("metacritic_url");
			
			
			
			if(finalObj.isNull("background_image")) {
				imageURL = "N/A";
			}
			else {
				imageURL = finalObj.getString("background_image");
			}
			
			if(metaURL.equals("")) {
				metaURL = "N/A";
			}
			
			check = true;
		}
	}
	
	public String recieveJSON(String searchParam, int id) throws IOException {
		if(id == 0) {
			String searchExact = searchParam;
			
			searchExact = searchExact.replaceAll(" ", "%20");
			
			URL url = new URL("https://api.rawg.io/api/games?key=efac59c034d14b71a4a8628d2ea3e185&search="+ searchExact +"&search_exact=true&page_size=1");
			
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
				StringBuffer buff = new StringBuffer();
				int read;
				char[] chars = new char[1024];
				
				while((read = reader.read(chars)) != -1) {
					buff.append(chars, 0, read);
				}
				
				return buff.toString();
			}
			finally {
				if(reader != null) {
					reader.close();
				}
			}
		}
		else {
			int gameID = id;
			
			URL url = new URL("https://api.rawg.io/api/games/" + gameID + "?key=efac59c034d14b71a4a8628d2ea3e185");
			
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
				StringBuffer buff = new StringBuffer();
				int read;
				char[] chars = new char[1024];
				
				while((read = reader.read(chars)) != -1) {
					buff.append(chars, 0, read);
				}
				
				return buff.toString();
			}
			finally {
				if(reader != null) {
					reader.close();
				}
			}
		}
	}
	
	public BufferedImage resize(BufferedImage img) {
		Image tmp = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2D = dimg.createGraphics();
		g2D.drawImage(tmp, 0, 0, null);
		g2D.dispose();
		
		return dimg;
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
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
	public static void main(String[] args) {
		VGDBApp app = new VGDBApp();
	}
}
