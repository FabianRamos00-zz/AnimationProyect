package GUI;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class JWindowSplash extends JWindow{

	private static final int TIME = 100;
	private static final String ICON = "/images/icon.jpg";
	
	private JLabel jLabel;
	private JProgressBar jProgressBar;
	private ImageIcon icon;
	private JPanel jPanel;
	
	public JWindowSplash(){
		super();
		this.icon = new ImageIcon(getClass().getResource(ICON));
		this.jLabel = new JLabel(this.icon);
		this.jLabel.setLayout(new FlowLayout());
		this.jPanel = (JPanel)getContentPane();
		this.jProgressBar = new JProgressBar(0,100);
		this.jProgressBar.setValue(0);
		this.jProgressBar.setStringPainted(true);
		init();
	}
	
	public void init() {
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		this.setLocationRelativeTo(null);
		this.jLabel.add(jProgressBar);
		this.jPanel.add(jLabel);
		this.setVisible(true);
		for(int i = 0; i<101; i++){
			try {
				Thread.sleep((long) (TIME));
				jProgressBar.setValue(i);
             }catch (InterruptedException e) {} 
		}
		this.setVisible(false);
	}
}
