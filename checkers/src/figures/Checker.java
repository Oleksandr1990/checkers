package figures;

import javax.swing.ImageIcon;

import game.Checkers;
import game.Console;
import game.FigureColor;
import game.Player;
import game.Player.Position;
import game.Field;

public class Checker extends Figure {

	public Checker(Player player, Field field, FigureColor color, int x, int y) {
		super(player, field, color, x, y);
		if(color == FigureColor.b)
			super.icon=new ImageIcon("blackChecker.jpg");
		else
			super.icon = new ImageIcon("whiteChecker.jpg");
		// TODO Auto-generated constructor stub
	}
	

	
	public boolean isLegalDistance(int x, int y){
		
		if((Math.abs(figureX-x)==1 && Math.abs(figureY-y)==1))
			return true;		
		return false;
	}
	
	@Override
	public boolean isLegalDirection(int x, int y){
		if(player.getPosition()==Position.top &&  y>figureY)
				return true;
		if(player.getPosition()==Position.down &&  y<figureY)
			return true;	
		return false;
	}
	
	@Override
	public String toString() {
		
		return this.getColor().name();
	}
	
	@Override
	public void captureEnemyChecker(int x, int y){
		
		int distanceX=(x-figureX)/2;
		int distanceY=(y-figureY)/2;
		if(field.getValueAt(x, y)==null && field.getValueAt(figureX+distanceX, figureY+distanceY)!=null && field.getValueAt(figureX+distanceX, figureY+distanceY).getColor()!=getColor()){
			Console.writeMessage(player + " moved from " + (char)(figureX+97) + (8-figureY) + " to " + (char)(x+97) + (8-y) + " and captured checker at " + (char)(figureX+distanceX+97) + (8-(figureY+distanceY)));
			field.setValueAt(null, figureX+distanceX, figureY+distanceY);
			field.setValueAt(null, figureX, figureY);
			field.setValueAt(this, x, y);
			figureX=x;
			figureY=y;
		select();
			if(!isCapturePossibility()){
				field.changeTurn();
				deselect();
			}
		}
		
	}


	
}
