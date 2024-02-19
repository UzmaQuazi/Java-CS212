
// Quazi Uzma Nadeem 22D
import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.*;

public class WordGUI extends JFrame {
	public JMenuItem opener = new JMenuItem("Open File");
	public JMenuItem addw;
	public WordGUI(String title, int height, int width)
	{
		setTitle(title);
		setSize(height, width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JMenuBar bar=new JMenuBar();

		JMenu menu=new JMenu("File Menu");
		bar.add(menu);

		//JMenuItem opener = new JMenuItem("Open File");
		JMenuItem exit=new JMenuItem("Quit Application");
		menu.add(opener);
		menu.add(exit);

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});


		JMenu edit=new JMenu("Edit");
		addw=new JMenuItem("AddWord");
		edit.add(addw);
		bar.add(edit);
		

		setJMenuBar(bar);
		repaint();
		
	}
}
