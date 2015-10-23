package gui;

import javax.swing.JLabel;

public class Cell extends JLabel {
	private boolean isSelected = false;
	private int cellX, cellY;
	public int getCellX() {
		return cellX;
	}

	public int getCellY() {
		return cellY;
	}

	public Cell(int x, int y) {
		// TODO Auto-generated constructor stub
		this.cellX=x;
		this.cellY=y;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}
