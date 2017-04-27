package Controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import GUI.FigureGUI;
import GUI.JFrameAbout;
import GUI.JFrameDetFigure;
import GUI.JFrameFigureApp;
import GUI.JFrameHelp;
import GUI.JFrameSettigs;
import GUI.JWindowSplash;
import Model.Area;
import Model.Coord;
import Model.Figure;
import Model.OnOff;

public class Controller implements ActionListener, MouseListener {
	
	private JFrameFigureApp jFrameFigureApp;
	private JFrameDetFigure jFrameDetFigure;
	
	public Controller(){
		new JWindowSplash();
		this.jFrameFigureApp = new JFrameFigureApp();
		this.jFrameFigureApp.getjMenuBarFigure().setLanguage(jFrameFigureApp.getLanguage());
		init();
	}

	public void init() {
		this.jFrameFigureApp.getjPanelFigure().addMouseListener(this);
		jMenuListeners();
	}
	
	public void jMenuListeners(){
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemSpanish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeLangue("Español");
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemEnglish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeLangue("Ingles");
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemFigureRdm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addRandomFigure();
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemFigureDet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrameDetFigure = new JFrameDetFigure();
				jFrameDetFigure.jButton.addActionListener(this);
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrameFigureApp.getjPanelFigure().figureGUIGroup.delete();
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemDeleteAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				jFrameFigureApp.getjPanelFigure().figureGUIGroup.deleteAll();
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemFramePosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				new JFrameSettigs("position", jFrameFigureApp.getLanguage());
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemFrameSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JFrameSettigs("size", jFrameFigureApp.getLanguage());
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JFrameAbout(jFrameFigureApp.getLanguage());
			}
		});
		this.jFrameFigureApp.getjMenuBarFigure().jMenuItemHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JFrameHelp(jFrameFigureApp.getLanguage());
			}
		});
		
	}
	
	private void addRandomFigure() {
		Random random = new Random();
		Figure figure = new Figure(random.nextInt(100)+10, 
				Math.toRadians(random.nextInt(360)), 
				((double)random.nextInt(130)+10), 
				new Coord((double)random.nextInt(1000)+20,(double)random.nextInt(500)+20),
				(random.nextBoolean() ? OnOff.ON : OnOff.OFF));
		figure.setMoving(true);
		figure.setArea(new Area(20,20,Toolkit.getDefaultToolkit().getScreenSize().width/2,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		this.jFrameFigureApp.getjPanelFigure().addFigure(new FigureGUI(figure, random.nextBoolean()? Color.BLUE : Color.GREEN));
		this.jFrameFigureApp.getjPanelFigure().init();
	}
	
	public void addFigure(){
		Figure figure = new Figure(Integer.parseInt(this.jFrameDetFigure.jTextField_Sz.getText()),
				Double.parseDouble(this.jFrameDetFigure.jTextField_Dr.getText()), 
				Double.parseDouble(this.jFrameDetFigure.jTextField_Sp.getText()),
				new Coord(Double.parseDouble(this.jFrameDetFigure.jTextField_Px.getText()), 
						Double.parseDouble(this.jFrameDetFigure.jTextField_Py.getText())), 
				OnOff.ON);
		figure.setMoving(true);
		figure.setArea(new Area(20,20,800,600));
		this.jFrameFigureApp.getjPanelFigure().addFigure(new FigureGUI(figure, 
				this.jFrameDetFigure.jTextField_Cl.getText().equals("Azul")? Color.BLUE : Color.GREEN));
		this.jFrameFigureApp.getjPanelFigure().init();
	}
	
	private void changeLangue(String language) {
		this.jFrameFigureApp.changeLanguage(language);
		this.jFrameFigureApp.getjMenuBarFigure().setLanguage(this.jFrameFigureApp.getLanguage());
		this.jFrameFigureApp.getjPanelFigure().setLanguage(this.jFrameFigureApp.getLanguage());
	}
	
	public void actionButton(ActionEvent event){
		if (event.getSource() == this.jFrameDetFigure.jButton) {
			addFigure();
			this.jFrameDetFigure.dispose();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.isMetaDown()) {
			this.jFrameFigureApp.getjPanelFigure().popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}else{
			this.addRandomFigure();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
