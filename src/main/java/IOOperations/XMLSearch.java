package IOOperations;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FileUtils;

import Utils.XmlParser;
import dtos.Car;
import dtos.Cars;
import dtos.Student;
import dtos.Students;

public class XMLSearch implements Search {

	static final XmlParser xmlparser = new XmlParser();

	@Override
	public void search(String word, String path, String extension) {
		Pattern pattern = null;
		Matcher matcher = null;
		Cars cars = null;
		Students students = null;
		try {
			students = xmlparser.parseXml(Students.class, path + extension);
		} catch (javax.xml.bind.UnmarshalException e) {
		} catch (JAXBException e) {
		} catch (java.lang.IllegalArgumentException e) {
			fileTraveres(word, path, extension);
		}
		try {
			cars = xmlparser.parseXml(Cars.class, path + extension);
		} catch (javax.xml.bind.UnmarshalException e) {
		} catch (JAXBException e) {
		} catch (java.lang.IllegalArgumentException e) {

		}
		if (students != null) {
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
		}
		if (cars != null) {
			for (Car car : cars.getEntries()) {
				pattern = Pattern.compile(word);
				matcher = pattern.matcher(car.getBrand());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
				matcher = pattern.matcher(car.getModel());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
				matcher = pattern.matcher(car.getYearOfProduction().toString());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
				matcher = pattern.matcher(car.getZeroToSixty().toString());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
				matcher = pattern.matcher(car.getEngine().getCode());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
				matcher = pattern.matcher(car.getEngine().getCubature().toString());
				if (matcher.find()) {
					System.out.println("The word " + word + " is found in file: ");
				}
			}
		}
	}

	private static void fileTraveres(String word, String path, String extension) {
		File root = new File(path);
		Pattern pattern = null;
		Matcher matcher = null;
		Students students = null;
		Cars cars = null;
		Collection<File> files = null;
		try {
			files = FileUtils.listFiles(root, null, true);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("NO SUCH FILE OR DIRECTORY.Please Try again");
			return;
		}
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
					students = null;
				}
			}
			if (file.getName().endsWith(extension)) {
				try {
					cars = xmlparser.parseXml(Cars.class, file.getAbsolutePath());
				} catch (javax.xml.bind.UnmarshalException e) {
				} catch (JAXBException e) {
				}
				if (cars != null) {
					for (Car car : cars.getEntries()) {
						pattern = Pattern.compile(word);
						matcher = pattern.matcher(car.getBrand());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(car.getModel());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(car.getYearOfProduction().toString());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(car.getZeroToSixty().toString());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(car.getEngine().getCode());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
						matcher = pattern.matcher(car.getEngine().getCubature().toString());
						if (matcher.find()) {
							System.out.println("The word " + word + " is found in file: " + file.getAbsolutePath());
						}
					}
					cars = null;
				}
			}
		}
	}
}
