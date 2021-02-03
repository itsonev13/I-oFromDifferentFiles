package IOOperations;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FileUtils;

import Utils.XmlParser;
import dtos.Student;
import dtos.Students;

public class XMLSearch implements Search {

	static final XmlParser xmlparser = new XmlParser();

	@Override
	public void search(String word, String path, String extension) {
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			Students students = xmlparser.parseXml(Students.class, path + extension);
			for (Student student : students.getEntries()) {
				pattern = Pattern.compile(word);
				matcher = pattern.matcher(student.getName());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found");
				}
				matcher = pattern.matcher(student.getAge().toString());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found");
				}
				matcher = pattern.matcher(student.getAvrageMarks().toString());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found");
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (java.lang.IllegalArgumentException e) {
			fileTraveres(word, path, extension);
		}

	}

	private static void fileTraveres(String word, String path, String extension) {
		File root = new File(path);
		Pattern pattern = null;
		Matcher matcher = null;
		Students students = null;
		Collection<File> files = FileUtils.listFiles(root, null, true);
		for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			if (file.getName().endsWith(extension)) {
				try {
					students = xmlparser.parseXml(Students.class, file.getAbsolutePath());
				} catch (javax.xml.bind.UnmarshalException e) {
				} catch (JAXBException e) {

				}
				if (students != null) {
					for (Student student : students.getEntries()) {
						pattern = Pattern.compile(word);
						matcher = pattern.matcher(student.getName());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(student.getAge().toString());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(student.getAvrageMarks().toString());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
					}
				}
			}
		}
	}
}
