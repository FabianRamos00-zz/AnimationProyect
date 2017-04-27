package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Properties.Language;

public class JFrameSettigs extends JFrame{
	
	private static final String TITLE = "Figure App";
	private static final String ICON = "/images/icon.jpg";
	private static final int WIDTH = 180;
	private static final int HEIGHT = 200;
	
	private JLabel jLabel;
	private JLabel jLabel2;
	public JTextField jTextField;
	public JTextField jTextField2;
	private JButton jButton;
	private JPanel jPanel;
	
	private Language language;
	
	public JFrameSettigs(String option, Language language){
		super();
		this.jLabel = new JLabel();
		this.jLabel2 = new JLabel();
		this.jTextField = new JTextField(10);
		this.jTextField2 = new JTextField();
		this.jButton = new JButton();
		this.jPanel = new JPanel(new GridLayout(5, 1));
		this.language = language;
		loadLanguage(option);
		init();
	}
	
	public void loadLanguage(String option){
		if (option.equalsIgnoreCase("size")) {
			this.jLabel.setText(language.getProperty("Width_Frame"));
			this.jLabel2.setText(language.getProperty("Height_Frame"));
			this.setTitle(language.getProperty("Settings_Size"));
		}else {
			this.setTitle(language.getProperty("Settings_Position"));
			this.jLabel.setText(language.getProperty("Position_X"));
			this.jLabel2.setText(language.getProperty("Position_X"));
		}
		this.jButton.setText(language.getProperty("Ok"));
	}
	
	public void init(){
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		jpanelAdd();
		this.add(this.jPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void jpanelAdd(){
		this.jPanel.add(this.jLabel);
		this.jPanel.add(this.jTextField);
		this.jPanel.add(this.jLabel2);
		this.jPanel.add(this.jTextField2);
		this.jPanel.add(this.jButton);
	}
}

