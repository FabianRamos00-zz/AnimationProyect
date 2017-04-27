package GUI;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Properties.Language;

public class JFrameFigureApp extends JFrame{
	
	private static final String TITLE = "Figure App";
	private static final String ICON = "/images/icon.jpg";
	
	private static final String DEFAULT_L = "Español";
	
	private Language language;
	protected JMenuBarFigure jMenuBarFigure;
	protected JPanelFigure jPanelFigure;
	
	public JFrameFigureApp() {
		super();
		this.jMenuBarFigure = new JMenuBarFigure();
		this.jPanelFigure = new JPanelFigure();
		this.language = new Language(DEFAULT_L);
		init();
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public void changeLanguage(String idiom){
		this.language = new Language(idiom);
	}
	
	public JMenuBarFigure getjMenuBarFigure() {
		return jMenuBarFigure;
	}

	public void setjMenuBarFigure(JMenuBarFigure jMenuBarFigure) {
		this.jMenuBarFigure = jMenuBarFigure;
	}

	public JPanelFigure getjPanelFigure() {
		return jPanelFigure;
	}

	public void setjPanelFigure(JPanelFigure jPanelFigure) {
		this.jPanelFigure = jPanelFigure;
	}

	public void init() {
		this.setTitle(TITLE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		this.setResizable(false);
		this.setJMenuBar(this.jMenuBarFigure);
		this.add(this.jPanelFigure);
		this.jPanelFigure.init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}