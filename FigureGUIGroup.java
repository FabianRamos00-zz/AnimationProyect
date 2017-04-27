package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Model.Figure;

public class FigureGUIGroup {
	
	private FigureGUI[] figuresGUI;
	
	public FigureGUIGroup() {
		super();
		this.figuresGUI = new FigureGUI[0];
	}
	
	public void add(FigureGUI figureGUI){
		FigureGUI[] figuresGUIAux = this.figuresGUI;
		this.figuresGUI = new FigureGUI[this.figuresGUI.length+1];
		for (int i = 0; i < figuresGUIAux.length; i++) {
			this.figuresGUI[i] = figuresGUIAux[i];
		}
		this.figuresGUI[this.figuresGUI.length-1] = figureGUI;
	}
	
	public void stopDelete(){
		for (int i = 0; i < this.figuresGUI.length; i++) {
			if (this.figuresGUI[i].getSpeed() <= 0) {
				deleteFigure(i);
			}
		}
	}
	
	public void deleteFigure(int j){
		FigureGUI[] figureGUIAux = this.figuresGUI;
		this.figuresGUI = new FigureGUI[figureGUIAux.length-1];
		for (int i = 0; i < this.figuresGUI.length; i++) {
			if (i != j) {
				if (i < j) {
					this.figuresGUI[i] = figureGUIAux[i];
				}else {
					this.figuresGUI[i] = figureGUIAux[i+1];
				}
			}
		}
	}
	
	
	public void delete(){
		FigureGUI[] figureGUIAux = this.figuresGUI;
		this.figuresGUI = new FigureGUI[this.figuresGUI.length-1];
		for (int i = 0; i < this.figuresGUI.length; i++) {
			this.figuresGUI[i] = figureGUIAux[i];
		}
	}
	
	public void deleteAll(){
		this.figuresGUI = new FigureGUI[0];
	}
	
	
	public void init(){
	    for (int i = 0; i < figuresGUI.length; i++) {
	    	this.figuresGUI[i].init();
	    }
	}
	
	public void draw(Graphics graphics){
		for(FigureGUI figureGUI : figuresGUI) {
			figureGUI.draw(graphics);
		}
	}
}
