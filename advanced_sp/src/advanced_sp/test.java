package advanced_sp;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test extends JFrame {

	private static final long serialVersionUID = 1L;

	public test() {

		// set flow layout for the frame
		this.getContentPane().setLayout(new FlowLayout());

		JButton button1 = new JButton("Recommended Study Path");

		JButton button2 = new JButton("Advanced Study Path");

		// add buttons to frame
		add(button1);
		add(button2);
        
		
	}

	private static void createAndShowGUI() {

  //Create and set up the window.

  JFrame frame = new test();

  //Display the window.

  frame.pack();

  frame.setVisible(true);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

	public static void main(String[] args) {

  //Schedule a job for the event-dispatching thread:

  //creating and showing this application's GUI.

  javax.swing.SwingUtilities.invokeLater(new Runnable() {

public void run() {

    createAndShowGUI(); 

}

  });
    }

}
