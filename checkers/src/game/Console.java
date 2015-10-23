package game;

import javax.swing.JTextArea;

public class Console {
	private static JTextArea textArea;
	
	public static void writeMessage(String message) {
        textArea.append(message + "\n");
    }

	public static void setArea(JTextArea area) {
		// TODO Auto-generated method stub
		textArea=area;
		textArea.append("***Welcome to checkers!***\n");
	}
}
