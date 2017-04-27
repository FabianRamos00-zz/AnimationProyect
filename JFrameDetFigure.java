package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Properties.Language;

public class JFrameDetFigure extends JFrame {
	
	private static final String ICON = "/images/icon.jpg";
	private static final int WIDTH = 200;
	private static final int HEIGHT = 410;
	
	private String defaultL = "Español";
	
	private Language language;
	private JLabel[] jLabel;
	private JPanel jPanelP;
	private JPanel jPanel1;
	private JPanel jPanel2;
	public JButton jButton;
	public JComboBox comboBox;
	public JTextField jTextField_Px;
	public JTextField jTextField_Py;
	public JTextField jTextField_Sz;
	public JTextField jTextField_Sp;
	public JTextField jTextField_Dr;
	public JTextField jTextField_Cl;
	
	public JFrameDetFigure(){
		super();
		this.jPanelP = new JPanel();
		this.jPanel1 = new JPanel(new GridLayout(13,1));
		this.jPanel2 = new JPanel();
		this.jLabel =  new JLabel[6];
		this.jButton = new JButton();
		this.comboBox = new JComboBox();
		for (int i = 0; i < jLabel.length; i++) {
			this.jLabel[i] = new JLabel();
		}
		this.jTextField_Px = new JTextField(10);
		this.jTextField_Py = new JTextField();
		this.jTextField_Sz = new JTextField();
		this.jTextField_Sp = new JTextField();
		this.jTextField_Dr = new JTextField();
		this.jTextField_Cl = new JTextField();
		loadLanguage(defaultL);
		init();
    }
	
	public String getDefaultL() {
		return defaultL;
	}

	public Language getLanguage() {
		return language;
	}
	
	public void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		this.setResizable(false);
		this.setVisible(true);
		jPanel();  
		this.add(jPanelP);
	}
	
	public void loadLanguage(String idiom) {
		this.language = new Language(idiom);
		this.setTitle(this.language.getProperty("title"));
		this.jLabel[0].setText(this.language.getProperty("Position_X"));
		this.jLabel[1].setText(this.language.getProperty("Position_Y"));
		this.jLabel[2].setText(this.language.getProperty("Size"));
		this.jLabel[3].setText(this.language.getProperty("Speed"));
		this.jLabel[4].setText(this.language.getProperty("Direction"));
		this.jLabel[5].setText(this.language.getProperty("Color"));
		this.comboBox.addItem(this.language.getProperty("OnOff"));
		this.comboBox.addItem(this.language.getProperty("On"));
		this.comboBox.addItem(this.language.getProperty("Off"));
		this.jButton.setText(this.language.getProperty("Ok"));
	}
	
	public void jPanel(){
		this.jPanel1.add(this.jLabel[0], null);
	    this.jPanel1.add(this.jTextField_Px, null);
	    this.jPanel1.add(this.jLabel[1], null);
	    this.jPanel1.add(this.jTextField_Py, null);
	    this.jPanel1.add(this.jLabel[2], null);
	    this.jPanel1.add(this.jTextField_Sz, null);
	    this.jPanel1.add(this.jLabel[3], null);
	    this.jPanel1.add(this.jTextField_Sp, null);
	    this.jPanel1.add(this.jLabel[4], null);
	    this.jPanel1.add(this.jTextField_Dr, null);
	    this.jPanel1.add(this.jLabel[5], null);
	    this.jPanel1.add(this.jTextField_Cl, null);
	    this.jPanel1.add(this.comboBox, null);
		this.jPanel2.add(jButton);
		this.jPanelP.add(jPanel1);
		this.jPanelP.add(jPanel2);
	}
}
