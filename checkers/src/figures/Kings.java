package figures;


import game.FigureColor;
import game.Player;

import javax.swing.ImageIcon;

import game.Field;

public class Kings extends Figure {

	public Kings(Player player, Field field, FigureColor color, int x, int y) {
		super(player, field, color, x, y);
		if(color == FigureColor.b)
			super.icon=new ImageIcon("blackKings.jpg");
		else
			super.icon = new ImageIcon("whiteKings.jpg");
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return this.getColor().name().toUpperCase();
	}

	@Override
	public boolean isLegalDistance(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void captureEnemyChecker(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLegalDirection(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
