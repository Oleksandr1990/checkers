package game;

public class Player {
	
	public enum Position{top, down;}
	private Position position;
	private FigureColor color;
	
	public Position getPosition(){
		return this.position;
	}
	
	public FigureColor getColor(){
		return this.color;
	}
	
	public Player(Position position, FigureColor color){
		this.position=position;
		this.color=color;
	}
	
	@Override
	public String toString() {
		if(position == Position.down)
			return "Player1";
		else
			return "Player2";
	}
}
