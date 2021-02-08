package com.softwareag.SoftwareAg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IOOperations.BinarySearch;
import inits.BitFile;

public class BinSearchTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
		BitFile file = new BitFile();
	}

	@Test
	public void searchShouldFindTheWordJourneyTwice() {
		// arrange
		BinarySearch search = new BinarySearch();
		// act
		search.search("journey", "test", ".bin");
		// assert
		assertEquals("The word journey is found\r\nThe word journey is found", outputStreamCaptor.toString().trim());
	}

	@Test
	public void searchShouldFindTheWordJourneyTwiceWhenGivenFolder() {
		// arrange
		BinarySearch search = new BinarySearch();
		// act
		search.search("journey", "../", ".bin");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word journey is found"));
	}

	@Test
	public void searchShouldNotFindAMatch() {
		// arrange

		BinarySearch search = new BinarySearch();
		// act
		search.search("nosuchword123", "test", ".bin");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith(""));
	}

	@Test
	public void searchShouldThrowFileNotFoundException() {
		// arrange
		BinarySearch search = new BinarySearch();
		// act
		search.search("journey", "notrealfile123", ".bin");
		// assert
		assertEquals("NO SUCH FILE OR DIRECTORY.Please Try again", outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void dispose() {
		File file = new File("test.bin");
		file.delete();

	}

}
