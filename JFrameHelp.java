package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Properties.Language;

public class JFrameHelp extends JFrame{
	
	private static final int WIDTH_HELP = 800;
	private static final int HEIGHT_HELP = 500;
	private static final String ICON = "/images/icon.jpg";
	
	private Language language;
	
	public JFrameHelp(Language language) {
		super();
		this.language = language;
		loadLanguage();
		init();
	}
	
	public void loadLanguage(){
		this.setTitle(this.language.getProperty("Help"));
	}
	
	public void init(){
		this.setSize(WIDTH_HELP, HEIGHT_HELP);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		this.setVisible(true);
	}
}
