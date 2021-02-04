package com.softwareag.SoftwareAg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IOOperations.XMLSearch;

public class XmlSearchTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
		try {
			FileWriter myWriter = new FileWriter("xmlTest1.xml");
			myWriter.write("<?xml version ='1.0'?>\r\n" + "<cars>\r\n" + "\r\n" + " <car>\r\n"
					+ "   <brand>mazda</brand>\r\n" + "   <model>6</model>\r\n"
					+ "   <yearOfProduction>2006</yearOfProduction>\r\n" + "   <engine code=\"123qwe\">\r\n"
					+ "    <cubature>2.0</cubature>\r\n" + "   </engine>\r\n" + "   <zerotosixty>7.5 </zerotosixty>\r\n"
					+ " </car>\r\n" + "\r\n" + " <car>\r\n" + "   <brand>bmw</brand>\r\n" + "   <model>3</model>\r\n"
					+ "   <yearOfProduction>2012</yearOfProduction>\r\n" + "   <engine code=\"124qwe\">\r\n"
					+ "    <cubature>2.3</cubature>\r\n" + "   </engine>\r\n" + "   <zerotosixty>6.0 </zerotosixty>\r\n"
					+ " </car>\r\n" + "\r\n" + " <car>\r\n" + "   <brand>Buggati</brand>\r\n"
					+ "   <model>Veyron</model>\r\n" + "   <yearOfProduction>20017</yearOfProduction>\r\n"
					+ "   <engine code=\"1111q\">\r\n" + "    <cubature>5.2</cubature>\r\n" + "   </engine>\r\n"
					+ "   <zerotosixty>2.3 </zerotosixty>\r\n" + " </car>\r\n" + "\r\n" + "</cars>");
			myWriter.close();
			FileWriter myWriter2 = new FileWriter("xmlTest2.xml");
			myWriter2.write("<?xml version ='1.0'?>\r\n" + "<students>\r\n" + " <student>\r\n"
					+ "   <name>Rick Grimes</name>\r\n" + "   <age>35</age>\r\n"
					+ "   <avrageMarks>3.5</avrageMarks>\r\n" + " </student>\r\n" + " <student>\r\n"
					+ "   <name>Daryl Dixon </name>\r\n" + "   <age>33</age>\r\n"
					+ "   <avrageMarks>3.5</avrageMarks>\r\n" + " </student>\r\n" + " <student>\r\n"
					+ "   <name>Maggie</name>\r\n" + "   <age>36</age>\r\n" + "   <avrageMarks>3.5</avrageMarks>\r\n"
					+ " </student>\r\n" + "</students>");
			myWriter2.close();

		} catch (IOException e) {
		}
	}

	@Test
	public void searchShouldFindTheWordRickGrimesWhenSearchingFileName() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("Rick Grimes", "xmlTest2", ".xml");
		// assert
		assertEquals("The word Rick Grimes is found", outputStreamCaptor.toString().trim());
	}

	@Test
	public void searchShouldFindTheAttributeOfEngineWhenSearchingFileName() {
		XMLSearch search = new XMLSearch();
		// act
		search.search("123qwe", "xmlTest1", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word 123qwe is found"));

	}

	@Test
	public void searchShouldFindTheCubatureWhenSearchingFileName() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("2.3", "xmlTest1", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word 2.3 is found"));

	}

	@Test
	public void searchShouldFindTheZeroToSixtyWhenSearchingFileName() {
		// arrange

		XMLSearch search = new XMLSearch();
		// act
		search.search("6.0", "xmlTest1", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word 6.0 is found"));
	}

	@Test
	public void searchShouldFindTheModelWhenSearchingFileName() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("mazda", "xmlTest1", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word mazda is found"));
	}

	@Test
	public void searchShouldFindTheWordRickGrimesWhenSearchingInFolder() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("Rick Grimes", "D:\\Programing test\\java", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word Rick Grimes is found"));
	}

	@Test
	public void searchShouldNOTFindTheWordRickGrimesWhenSearchingInNotExistingFile() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("Rick Grimes123", "xmlTest2", ".xml");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith(""));
	}

	@Test
	public void searchShouldThrowFileNotFoundException() {
		// arrange
		XMLSearch search = new XMLSearch();
		// act
		search.search("Rick Grimes", "notrealfile123", ".bin");
		// assert
		assertEquals("NO SUCH FILE OR DIRECTORY.Please Try again", outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void dispose() {
		File file = new File("xmlTest1.html");
		file.delete();
		File file2 = new File("xmlTest2.html");
		file2.delete();

	}
}
