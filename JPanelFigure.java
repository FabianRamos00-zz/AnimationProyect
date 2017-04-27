package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Properties.Language;

public class JPanelFigure extends JPanel implements Runnable{
	
	public final static int REFRESH_TIME = 100;
	private String defaultL = "Español";
	private Language language;
	
	public JMenuItem jMenuItemDet;
	public JMenuItem jMenuItemRdm;
	public JMenuItem jMenuItemDel;
	public JMenuItem jMenuItemDA;
	public JPopupMenu popupMenu;
	
	public FigureGUIGroup figureGUIGroup;
	
	public JPanelFigure() {
		this.figureGUIGroup = new FigureGUIGroup();
		this.popupMenu = new JPopupMenu();
		this.setComponentPopupMenu(popupMenu);
		this.popupMenu.setVisible(true);
		this.jMenuItemDet = new JMenuItem();
		this.jMenuItemRdm = new JMenuItem();
		this.jMenuItemDel= new JMenuItem();
		this.jMenuItemDA = new JMenuItem();
		this.language = new Language(defaultL);
		loadLanguage();
		this.popupMenu.add(jMenuItemRdm);
		this.popupMenu.add(jMenuItemDet);
		this.popupMenu.add(jMenuItemDel);
		this.popupMenu.add(jMenuItemDA);
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
		loadLanguage();
	}
	
	public void loadLanguage(){
		this.jMenuItemDet.setText(this.language.getProperty("Figure_Option_Random"));
		this.jMenuItemRdm.setText(this.language.getProperty("Figure_Option_Determinate"));
		this.jMenuItemDel.setText(this.language.getProperty("Figure_Option_Delete"));
		this.jMenuItemDA.setText(this.language.getProperty("Figure_Option_DeleteAll"));
	}	

	public void init() {
		new Thread(this).start();
		this.figureGUIGroup.init();
	}
	
	public void addFigure(FigureGUI figureGUI){
		this.figureGUIGroup.add(figureGUI);
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		this.figureGUIGroup.draw(graphics);
		this.figureGUIGroup.stopDelete();
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
                Thread.sleep(REFRESH_TIME);
            } catch (InterruptedException ex) {}
		}
	}
}