package themeMaker;

import javax.swing.JOptionPane;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Genorator g = new Genorator();
		String newTheme = JOptionPane.showInputDialog("Enter New theme Name: ");
		g.MakeNewTheme(newTheme);
	}

}
