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

import IOOperations.TxtSearch;

public class TxtSearchTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
		try {
			FileWriter myWriter = new FileWriter("txtSearchTest.txt");
			myWriter.write("hello from file!");
			myWriter.close();

		} catch (IOException e) {
		}
	}

	@Test
	public void searchShouldFindTheWordHello() {
		// arrange
		TxtSearch search = new TxtSearch();
		// act
		search.search("hello", "txtSearchTest", ".txt");
		// assert
		assertEquals("The word hello is found", outputStreamCaptor.toString().trim());
	}

	@Test
	public void searchShouldFindTheWordHelloInFolder() {
		// arrange
		TxtSearch search = new TxtSearch();
		// act
		search.search("hello", "D:\\Programing test\\java\\SoftwareAg", ".txt");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word hello is found"));
	}

	@Test
	public void searchShouldNotFindAMatch() {
		// arrange
		TxtSearch search = new TxtSearch();
		// act
		search.search("notsuchword", "txtSearchTest", ".txt");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith(""));
	}

	@Test
	public void searchShouldThrowFileNotFoundException() {
		// arrange
		TxtSearch search = new TxtSearch();
		// act
		search.search("hello", "notrealfile", ".txt");
		// assert
		assertEquals("NO SUCH FILE OR DIRECTORY.Please Try again", outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void dispose() {
		File file = new File("txtSearchTest.txt");
		file.delete();
	}

}
