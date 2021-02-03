package IOOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLSearch implements Search {

	public void search(String word, String path, String extension) {
		Pattern pattern = null;
		Matcher matcher = null;
		boolean isFolder = false;
		try {
			if (isFolder == false) {
				Document doc = Jsoup.parse(new File(path + extension), "UTF-8");
				Elements elements = doc.getAllElements();
				for (Element element : elements) {
					pattern = Pattern.compile(word);
					matcher = pattern.matcher(element.text());
					if (matcher.find()) {
						System.out.println("The word " + word + " is found");
					}
				}
			}
		} catch (FileNotFoundException e) {
			isFolder = true;
			fileTraveres(word, path, extension);
		} catch (IOException e) {

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
					Document doc = Jsoup.parse(file, "UTF-8");
					Elements elements = doc.getAllElements();
					for (Element element : elements) {
						pattern = Pattern.compile(word);
						matcher = pattern.matcher(element.text());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}