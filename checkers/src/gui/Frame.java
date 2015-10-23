package gui;





import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;



import figures.Figure;
import game.Console;
import game.Field;


public class Frame extends JFrame {
	private Cell[][] labels;
	private Field field;
	private Console console;
	public Frame(){
		setLayout(new BorderLayout());
		GridLayout layout = new GridLayout(10,10);
		JPanel panel = new JPanel();
		panel.setLayout(layout);
		
		labels = new Cell[8][8];
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		
		//header
		JLabel lab = new JLabel(new ImageIcon("fieldWhite.jpg"));		
		panel.add(lab);
		for(char c='a';c<'i';c++){
			JLabel l = new JLabel(new ImageIcon("fieldWhite.jpg"));			
			l.setText(String.valueOf(c));
			l.setHorizontalTextPosition(JLabel.CENTER);
			l.setVerticalTextPosition(JLabel.CENTER);
			panel.add(l);		
		}
		lab = new JLabel(new ImageIcon("fieldWhite.jpg"));		
		panel.add(lab);
		
		
		 //drawing black and white cells 
	  	for(int y=0;y<8;y++){
	  		lab = new JLabel(new ImageIcon("fieldWhite.jpg"));	
	  		lab.setText(String.valueOf(8-y));
			lab.setHorizontalTextPosition(JLabel.CENTER);
			lab.setVerticalTextPosition(JLabel.CENTER);
			panel.add(lab);
	    	  for(int x=0;x<8;x++){
	    		  Cell label = new Cell(x,y);
	    		  labels[y][x] = label;
	    		  label.addMouseListener(new MouseAdapter()  
	    		  {  
	    		      public void mouseClicked(MouseEvent e)  
	    		      {  
	    		     // System.out.println(label.getCellX() + " " + label.getCellY());
	    		    	  Figure figure = field.getValueAt(label.getCellX(), label.getCellY());
	    		       if(field.getSelected()==null){
	    		    	   if(figure!=null)
	    		    		   figure.select();
	    		       } else if (field.getSelected().equals(figure))
	    		    	   figure.deselect();
	    		       else {field.getSelected().move(label.getCellX(), label.getCellY());}
	    		      }  
	    		  }); 
	    		  panel.add(label);
	    	  }
	    	  lab = new JLabel(new ImageIcon("fieldWhite.jpg"));	
		  		lab.setText(String.valueOf(8-y));
				lab.setHorizontalTextPosition(JLabel.CENTER);
				lab.setVerticalTextPosition(JLabel.CENTER);
				panel.add(lab);
	      }
	  	
	  	lab = new JLabel(new ImageIcon("fieldWhite.jpg"));		
		panel.add(lab);
	  	for(char c='a';c<'i';c++){
			JLabel l = new JLabel(new ImageIcon("fieldWhite.jpg"));			
			l.setText(String.valueOf(c));
			l.setHorizontalTextPosition(JLabel.CENTER);
			l.setVerticalTextPosition(JLabel.CENTER);
			panel.add(l);		
		}
		lab = new JLabel(new ImageIcon("fieldWhite.jpg"));		
		panel.add(lab);
	  	
		panel.setSize(500, 500);
		
		add(panel, BorderLayout.NORTH);
		JTextArea area = new JTextArea();
		Console.setArea(area);
		JScrollPane scroll = new JScrollPane(area);
		
		scroll.setSize(500, 200);
		add(scroll);
		
		setSize(500, 700);
		setVisible(true);
	}
	public void drawCell(int x, int y, Figure figure){
		if(figure==null){
			 if( ((y+1)%2!=0 && (x+1)%2==0)   ||   ((y+1)%2==0 && (x+1)%2!=0))
				 labels[y][x].setIcon(new ImageIcon("fieldBrown.jpg"));
			 else
				 labels[y][x].setIcon(new ImageIcon("fieldWhite.jpg"));
		}
			
		else
			labels[y][x].setIcon(figure.getIcon());
	}
	public void setField(Field field) {
		// TODO Auto-generated method stub
		this.field=field;
	}
	public void drawSelected(int figureX, int figureY) {
		// TODO Auto-generated method stub
		labels[figureY][figureX].setIcon(new ImageIcon("selected.jpg"));
	}
}
