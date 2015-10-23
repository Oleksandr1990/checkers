package game;

import gui.Frame;



public class Checkers {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Checkers checkers = new Checkers();		
	}
	
	 public Checkers(){
		
		 Frame frame = new Frame();
		 Field field = new Field(8,8, frame);
		 frame.setField(field);
		 
		
	 }
}
