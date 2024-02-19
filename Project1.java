
// Quazi Uzma Nadeem (22D)

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project1 {

	public static void main(String[] args) throws FileNotFoundException {

		// Array List of Strings to store lines of file
		ArrayList<String> lines = new ArrayList<String>();

		File file1 = new File("input.txt");

		// Open a file named "input.txt"
		Scanner sc = new Scanner(file1);

		// Loop as long as file has lines in it
		while(sc.hasNextLine())
		{
			// Add every single line to a Array list of strings
			lines.add(sc.nextLine());
		}

		// Create a new JFrame instance using WordGUI Class
		WordGUI f = new WordGUI("Grid", 500, 500);	

		// setting grid layout of 2 rows and 3 columns
		f.setLayout(new GridLayout(2,3));
		f.setSize(500,500);
		f.setVisible(true); 

		// 2 Dimensional array to hold JPanels into it
		JPanel[][] frameHolder = new JPanel[2][3];

		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 3; j++)
			{ 
				// Create a new JPanel
				frameHolder[i][j] = new JPanel();

				// Add that JPanel to particular location in 2 dimensional array
				f.add(frameHolder[i][j]);
			}
		}

		// Loop through each line of file which are stored in array list
		for(String line : lines)
		{
			// If word starts with 'a' or 'A', store it at location 0th Row and 0th Column in 2 Dimensional array
			if(line.charAt(0) == 'A' || line.charAt(0) == 'a')
			{
				frameHolder[0][0].add(new JLabel(line));

				// If word starts with 'e' or 'E', store it at location 0th Row and 1st Column in 2 Dimensional array
			}else if(line.charAt(0) == 'E' || line.charAt(0) == 'e')
			{
				frameHolder[0][1].add(new JLabel(line));

				// If word starts with 'i' or 'I', store it at location 0th Row and 2nd Column in 2 Dimensional array
			}else if(line.charAt(0) == 'I' || line.charAt(0) == 'i')
			{
				frameHolder[0][2].add(new JLabel(line));

				// If word starts with 'o' or 'O', store it at location 1st Row and 0th Column in 2 Dimensional array
			}else if(line.charAt(0) == 'O' || line.charAt(0) == 'o')
			{
				frameHolder[1][0].add(new JLabel(line));

				// If word starts with 'u' or 'U', store it at location 1st Row and 1st Column in 2 Dimensional array
			}else if(line.charAt(0) == 'U' || line.charAt(0) == 'u')
			{
				frameHolder[1][1].add(new JLabel(line));

				// If word does not starts with vowel, store it at location 1st Row and 2nd Column in 2 Dimensional array
			}else
			{
				frameHolder[1][2].add(new JLabel(line));	
			}
		}

		// Close the file
		sc.close();
	}
}
