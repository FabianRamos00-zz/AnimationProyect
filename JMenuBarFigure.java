package GUI;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Properties.Language;

public class JMenuBarFigure extends JMenuBar{
	
	private Language language;
	
	private String defaultL = "Español";
	
	private JMenu jMenuFigure;
	private JMenu jMenuFrame;
	private JMenu jMenuHelp;
	private JMenu jMenuLanguage;
	
	public JMenuItem jMenuItemFigureRdm;
	public JMenuItem jMenuItemFigureDet;
	public JMenuItem jMenuItemDelete;
	public JMenuItem jMenuItemDeleteAll;
	public JMenuItem jMenuItemFramePosition;
	public JMenuItem jMenuItemFrameSize;
	public JMenuItem jMenuItemFrameBackground;
	public JMenuItem jMenuItemSpanish;
	public JMenuItem jMenuItemEnglish;
	public JMenuItem jMenuItemHelp;
	public JMenuItem jMenuItemAbout;
	
	public JMenuBarFigure() {
		super();
		this.jMenuFigure = new JMenu();
		this.jMenuFrame = new JMenu();
		this.jMenuHelp = new JMenu();
		this.jMenuLanguage = new JMenu();
		this.jMenuItemFigureRdm = new JMenuItem();
		this.jMenuItemFigureDet = new JMenuItem();
		this.jMenuItemDelete = new JMenuItem();
		this.jMenuItemDeleteAll = new JMenuItem();
		this.jMenuItemFramePosition = new JMenuItem();
		this.jMenuItemFrameSize = new JMenuItem();
		this.jMenuItemFrameBackground = new JMenuItem();
		this.jMenuItemSpanish = new JMenuItem();
		this.jMenuItemEnglish = new JMenuItem();
		this.jMenuItemHelp = new JMenuItem();
		this.jMenuItemAbout = new JMenuItem();
		this.language = new Language(defaultL);
		loadLanguage();
		init();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
		loadLanguage();
	}
	
	public void loadLanguage(){
		this.jMenuFigure.setText(this.language.getProperty("Figure_Option"));
		this.jMenuFrame.setText(this.language.getProperty("Settings"));
		this.jMenuHelp.setText(this.language.getProperty("Help_Option"));
		this.jMenuLanguage.setText(this.language.getProperty("Settings_Language"));
		this.jMenuItemFigureRdm.setText(this.language.getProperty("Figure_Option_Random"));
		this.jMenuItemFigureDet.setText(this.language.getProperty("Figure_Option_Determinate"));
		this.jMenuItemDelete.setText(this.language.getProperty("Figure_Option_Delete"));
		this.jMenuItemDeleteAll.setText(this.language.getProperty("Figure_Option_DeleteAll"));
		this.jMenuItemFramePosition.setText(this.language.getProperty("Settings_Position"));
		this.jMenuItemFrameSize.setText(this.language.getProperty("Settings_Size"));
		this.jMenuItemFrameBackground.setText(this.language.getProperty("Settings_Background"));
		this.jMenuItemSpanish.setText(this.language.getProperty("Spanish_Language"));
		this.jMenuItemEnglish.setText(this.language.getProperty("English_Language"));
		this.jMenuItemHelp.setText(this.language.getProperty("Help"));
		this.jMenuItemAbout.setText(this.language.getProperty("About"));
	}
	
	public void init() {
		this.add(this.jMenuFigure);
		this.add(this.jMenuFrame);
		this.add(this.jMenuHelp);
		jMenuFigure();
		jMenuFrame();
		jMenuHelp();
		keyStrokes();
	}
	
	public void jMenuFigure() {
		this.jMenuFigure.add(jMenuItemFigureRdm);
		this.jMenuFigure.add(jMenuItemFigureDet);
		this.jMenuFigure.add(jMenuItemDelete);
		this.jMenuFigure.add(jMenuItemDeleteAll);
	}
	
	public void jMenuFrame(){
		this.jMenuFrame.add(jMenuItemFramePosition);
		this.jMenuFrame.add(jMenuItemFrameSize);
		this.jMenuFrame.add(jMenuItemFrameBackground);
		this.jMenuLanguage.add(jMenuItemSpanish);
		this.jMenuLanguage.add(jMenuItemEnglish);
		this.jMenuFrame.add(jMenuLanguage);
	}
	
	public void jMenuHelp(){
		this.jMenuHelp.add(jMenuItemHelp);
		this.jMenuHelp.addSeparator();
		this.jMenuHelp.add(jMenuItemAbout);
	}
	
	public void keyStrokes(){
		this.jMenuItemFigureDet.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));
		this.jMenuItemFigureRdm.setAccelerator(KeyStroke.getKeyStroke('B', ActionEvent.CTRL_MASK));
		this.jMenuItemDelete.setAccelerator(KeyStroke.getKeyStroke('M', ActionEvent.CTRL_MASK));
		this.jMenuItemDeleteAll.setAccelerator(KeyStroke.getKeyStroke('L', ActionEvent.CTRL_MASK));
		this.jMenuItemFramePosition.setAccelerator(KeyStroke.getKeyStroke('C', ActionEvent.ALT_MASK));
		this.jMenuItemFrameSize.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.ALT_MASK));
		this.jMenuItemFrameBackground.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.ALT_MASK));
		this.jMenuItemSpanish.setAccelerator(KeyStroke.getKeyStroke('X', ActionEvent.ALT_MASK));
		this.jMenuItemEnglish.setAccelerator(KeyStroke.getKeyStroke('Z', ActionEvent.ALT_MASK));
		this.jMenuItemHelp.setAccelerator(KeyStroke.getKeyStroke('Q', ActionEvent.SHIFT_MASK));
		this.jMenuItemAbout.setAccelerator(KeyStroke.getKeyStroke('R', ActionEvent.SHIFT_MASK));
	}
}
