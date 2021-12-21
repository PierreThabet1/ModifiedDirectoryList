package modifieddirectorylist;

import java.io.File;
import java.util.Scanner;

/**
 * This class is a modified version for the DirectoryList.
 * 
 * 
 * @author Pierre
 *
 */
public class ModifiedDirectoryList { // Begin of class.


	public static void main(String[] args) { // Begin of main.

		String directoryName;  // Directory name entered by the user.
		File directory;        // File object referring to the directory.
		String[] files;        // Array of file names in the directory.
		Scanner scanner;       // For reading a line of input from the user.

		scanner = new Scanner(System.in);  // scanner reads from standard input.

		System.out.print("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);

		if (directory.isDirectory() == false) {
			if (directory.exists() == false)
				System.out.println("There is no such directory!");
			else
				System.out.println("That file is not a directory.");
		}
		
		else {
			
			recursiveDirectoryList(directory);
			
		}

	} // End of main.

	/**
	 * This method list directories and subdirectories till to the last
	 * file in the subdirectory.
	 * 
	 * @param dir
	 */
	public static void recursiveDirectoryList(File dir) {
		
		String[] fnames;
		
		fnames = dir.list();
		
		for (int i = 0; i < fnames.length; i++) {
			
			File rf = new File(dir, fnames[i]);
			
			if (rf.isDirectory()) {
				
				recursiveDirectoryList(rf);
				
			}
			
			else {
				
				System.out.println(" " + fnames[i]);
				
			}
			
		}
		
	}
	
} // End of ModifiedDirectoryList class.
