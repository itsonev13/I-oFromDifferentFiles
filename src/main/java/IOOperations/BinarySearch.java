package IOOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class BinarySearch implements Search {
	public void search(String word, String path, String extension) {
		// BitFile bitFile = new BitFile();
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			InputStream input = new FileInputStream(path + extension);
			byte[] bytes = new byte[255];
			while (input.read(bytes) != -1) {
				String data = new String(bytes);
				pattern = Pattern.compile(word);
				matcher = pattern.matcher(data);
				if (matcher.find()) {
					System.out.println("The word " + word + " is found");
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			fileTraveres(word, path, extension);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fileTraveres(String word, String path, String extension) {
		File root = new File(path);
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			Collection<File> files = FileUtils.listFiles(root, null, true);
			for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				if (file.getName().endsWith(extension)) {
					InputStream input = new FileInputStream(file);
					byte[] bytes = new byte[255];
					while (input.read(bytes) != -1) {
						String data = new String(bytes);
						pattern = Pattern.compile(word);
						matcher = pattern.matcher(data);
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getName());
						}
					}
					input.close();
				}
			}
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("NO SUCH FILE OR DIRECTORY.Please Try again");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
