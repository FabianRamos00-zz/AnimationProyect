package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Properties.Language;

public class JFrameAbout extends JFrame{
	
	private static final int WIDTH_ABOUT = 600;
	private static final int HEIGHT_ABOUT = 400;
	private static final String ICON = "/images/icon.jpg";

	private Language language;
	
	public JFrameAbout(Language language) {
		super();
		this.language = language;
		loadLanguage();
		init();
	}
	
	public void loadLanguage() {
		this.setTitle(language.getProperty("About"));
	}
	
	public void init(){
		this.setSize(WIDTH_ABOUT, HEIGHT_ABOUT);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		this.setVisible(true);
	}
}
