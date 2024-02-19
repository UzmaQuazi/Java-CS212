// Quazi Uzma Nadeem 22D

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;

import java.awt.event.*;

public class Project4 {
	public static File file=null;
	public static TreeMap<Word,Word> sortedwords=new TreeMap<Word,Word> ();

	public static void main(String[] args) throws FileNotFoundException {

	

		// Create a new JFrame instance using WordGUI Class
		final WordGUI f = new WordGUI("Grid", 600, 600);	
 
		// setting grid layout of 2 rows and 3 columns
		f.setLayout(new GridLayout(2,3));
		f.setSize(500,500);
		f.setVisible(true);

		final JFileChooser chooser=new JFileChooser();//The file chooser
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		
		
		f.opener.addActionListener(new ActionListener()//Action listener for the open menu item
			{
				public void actionPerformed(ActionEvent e)
				{
					if(chooser.showOpenDialog(null) == JFileChooser.OPEN_DIALOG)//opens the file explorer expecting a file to be selected
					{
						file=chooser.getSelectedFile();//gets the selected file
						if(file!=null){
							fetch();
							draw(f);//calls draw method if the file is not null
						}
					}


				}
			});

		f.addw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String str=JOptionPane.showInputDialog("Enter another word to add");
				try{
					Word w=new Word(str);
					sortedwords.put(w,null);

				}catch(IllegalWordsException ew)
				{
					//ew.printStackTrace();
					System.out.println(str);
				}
				draw(f);	
			}
		});





	}

	public static void fetch()
	{
		sortedwords=new TreeMap();//tree map
		try{


			Scanner sf=new Scanner(file);//scanner for the file
			String all="";
			while(sf.hasNextLine())
				all+=sf.nextLine()+"\n";

			StringTokenizer s = new StringTokenizer(all);
			
			while(s.hasMoreTokens())
			{
				String me=s.nextToken().trim();//gets each line and trims it 
				try{
				Word w=new Word(me);
				sortedwords.put(w,null);//adds the words to the tree map
				}catch(IllegalWordsException e)
				{
					System.out.println(me);
				}
			}
		}catch(IOException e)
		{

		}
		
	}

	public static void draw(WordGUI f)
	{

		


		f.getContentPane().removeAll();//clears the jframe for adding new items
		 
		// 2 Dimensional array to hold JPanels into it
		JPanel[][] frameHolder = new JPanel[2][3];
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				// Create a new JPanel
				frameHolder[i][j] = new JPanel();
				frameHolder[i][j].setLayout(new GridLayout(20,1));
				
				// Add that JPanel to particular location in 2 dimensional array
				f.add(frameHolder[i][j]);
			}
		}
		
		for(Map.Entry<Word,Word> w:sortedwords.entrySet())//loops through the sorted words
		{
			String line=w.getKey().toString();//gets the string from the word
		
			
			// If word starts with 'a' or 'A', store it at location 0th Row and 0th Column in 2 Dimensional array
			if(line.charAt(0) == 'A' || line.charAt(0) == 'a')
			{
				frameHolder[0][0].add(new JLabel(line,JLabel.CENTER));
							
			// If word starts with 'e' or 'E', store it at location 0th Row and 1st Column in 2 Dimensional array
			}else if(line.charAt(0) == 'E' || line.charAt(0) == 'e')
			{
				frameHolder[0][1].add(new JLabel(line,JLabel.CENTER));
							
			// If word starts with 'i' or 'I', store it at location 0th Row and 2nd Column in 2 Dimensional array
			}else if(line.charAt(0) == 'I' || line.charAt(0) == 'i')
			{
				frameHolder[0][2].add(new JLabel(line,JLabel.CENTER));
							
			// If word starts with 'o' or 'O', store it at location 1st Row and 0th Column in 2 Dimensional array
			}else if(line.charAt(0) == 'O' || line.charAt(0) == 'o')
			{
				frameHolder[1][0].add(new JLabel(line,JLabel.CENTER));
							
			}else if(line.charAt(0) == 'U' || line.charAt(0) == 'u')
			{
				frameHolder[1][1].add(new JLabel(line,JLabel.CENTER));
							
			// If word does not starts with vowel, store it at location 1st Row and 2nd Column in 2 Dimensional array
			}else
			{
				frameHolder[1][2].add(new JLabel(line,JLabel.CENTER));	
			}
			
		}
		f.getContentPane().revalidate();
		f.repaint();
	}
}

