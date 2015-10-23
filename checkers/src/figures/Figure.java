package figures;
import java.awt.Image;

import javax.swing.ImageIcon;

import game.Console;
import game.Field;
import game.FigureColor;
import game.Player;
import game.Player.Position;


public abstract class Figure {
	protected Player player;
	protected ImageIcon icon;
	protected FigureColor color;
	protected Field field;
	protected int figureX, figureY;
	protected Image image;
	
	public int getFigureX() {
		
		return figureX;
	}

	public int getFigureY() {
		
		return figureY;
	}

	

	public FigureColor getColor() {
		
		return color;
	}


	
	public boolean isCapturePossibility() {
		if(figureX+2 <8 && figureY+2<8 && field.getValueAt(figureX+2, figureY+2)==null && field.getValueAt(figureX+1, figureY+1)!=null && field.getValueAt(figureX+1, figureY+1).getColor()!=getColor())
			return true;
		if(figureX+2 <8 && figureY-2>=0 && field.getValueAt(figureX+2, figureY-2)==null && field.getValueAt(figureX+1, figureY-1)!=null && field.getValueAt(figureX+1, figureY-1).getColor()!=getColor())
			return true;
		if(figureX-2 >=0 && figureY-2>=0 && field.getValueAt(figureX-2, figureY-2)==null && field.getValueAt(figureX-1, figureY-1)!=null && field.getValueAt(figureX-1, figureY-1).getColor()!=getColor())
			return true;
		if(figureX-2 >=0 && figureY+2<8 && field.getValueAt(figureX-2, figureY+2)==null && field.getValueAt(figureX-1, figureY+1)!=null && field.getValueAt(figureX-1, figureY+1).getColor()!=getColor())
			return true;
	return false;
	}

	public Figure(Player player, Field field, FigureColor color, int figX, int figY){
		this.player=player;
		this.color=color;
		this.figureX=figX;
		this.figureY=figY;
		this.field=field;
	}

	
	
	public void move(int x, int y){
		
			
		if(field.getTurn()==color){
			if(isCapturePossibility())
				captureEnemyChecker(x, y);
			else
				moveToEmptyCell(x, y);
			convertToKings();
		}
	}
	
	private void moveToEmptyCell(int x, int y) {
		
		if (field.isBrownCell(x, y) && isLegalDistance(x,y) && isEmptyCell(x,y) && isLegalDirection(x, y) && (!field.needsToCapture())){
			field.setValueAt(null, figureX, figureY);
			field.setValueAt(this, x, y);
			Console.writeMessage(player + " moved from " + (char)(figureX+97) + (8-figureY) + " to " + (char)(x+97) + (8-y));
			figureX=x;
			figureY=y;
			deselect();
			field.changeTurn();
			
			
		}
		
	}

	public void convertToKings(){
		if((player.getPosition()==Position.top && figureY==7) || (player.getPosition()==Position.down && figureY==0))
			field.setValueAt(new Kings(player, field, player.getColor(), figureX, figureY), figureX, figureY);
	}
	public abstract boolean isLegalDistance(int x, int y);

	public abstract boolean isLegalDirection(int x, int y);
	public boolean isEmptyCell(int x, int y){
		
		if(field.getValueAt(x, y)==null)
			return true;
		return false;
	}
	public void select(){
		
		field.setSelected(this);
	}
	
	public ImageIcon getIcon() {
		
		return this.icon;
	}
	
	public abstract void captureEnemyChecker(int x, int y);
		

	public void deselect() {
		// TODO Auto-generated method stub
		field.setSelected(null);
	}
	
}
