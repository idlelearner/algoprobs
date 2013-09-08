package code;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Count the number of files in my workspace
 * Just to know how much I practice :-)
 * @author Dhass
 *
 */
public class NoOfJavaFiles {
	public static void main(String[] args) {
		File f = new File("C:\\Dass\\Workspaces\\Practise\\");
		int javaCount = 0;
		LinkedList<File> folders = new LinkedList<File>();
		File subFiles[] = f.listFiles();
		if (subFiles != null)
			folders.addAll(Arrays.asList(subFiles));
		while (!folders.isEmpty()) {
			File curFile = folders.removeFirst();
			// if folder get its sub folder and add
			if (curFile.isDirectory()) {
				subFiles = curFile.listFiles();
				if (subFiles != null)
					folders.addAll(Arrays.asList(subFiles));
			} else {
				// if file and java file..add count
				if (curFile.getName().contains(".java")) {
					javaCount++;
					System.out.println(curFile.getPath());
				}
			}
		}

		System.out.println(javaCount);
	}
}
