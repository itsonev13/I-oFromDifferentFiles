package IOOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class TxtSearch implements Search {

	public void search(String word, String path, String extension) {
		String data;
		Pattern pattern = null;
		Matcher matcher = null;
		Scanner input = null;
		boolean isFolder = false;
		try {
			input = new Scanner(new File(path + extension));
			if (isFolder == false) {
				while (input.hasNextLine()) {
					data = input.nextLine();
					pattern = Pattern.compile(word);
					matcher = pattern.matcher(data);
					if (matcher.find()) {
						System.out.println("The word " + word + " is found");
					}
				}
			}
		} catch (FileNotFoundException e) {
			isFolder = true;
			fileTraveres(word, path, extension);
		}

	}

	private static void fileTraveres(String word, String path, String extension) {
		File root = new File(path);
		Scanner input;
		String data;
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			Collection<File> files = FileUtils.listFiles(root, null, true);
			for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				if (file.getName().endsWith(extension)) {
					input = new Scanner(file);
					while (input.hasNextLine()) {
						data = input.nextLine();
						pattern = Pattern.compile(word);
						matcher = pattern.matcher(data);
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getName());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}