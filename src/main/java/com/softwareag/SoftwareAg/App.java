package com.softwareag.SoftwareAg;

import java.io.File;
import java.util.Scanner;

import Exceptions.IncorrectExtensionException;
import Exceptions.NotSupportedMediaTypeException;
import IOOperations.BinarySearch;
import IOOperations.TxtSearch;
import IOOperations.XMLSearch;

public class App {
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		Scanner scanner = new Scanner(System.in);
		String path = null;
		System.out.println("Please enter the word that you are looking for");
		String word = scanner.nextLine();
		String extension = null;
		boolean isValidExtension = false;

		System.out.println("Please enter file or folder path");
		path = scanner.nextLine();

		do {
			System.out.println("Please enter what kind of extension ");
			extension = scanner.nextLine();
			isValidExtension = isValidExtension(extension);
		} while (isValidExtension != true);
		File file = null;
		Scanner input = null;
		switch (extension) {
		case ".txt":
			TxtSearch txtSearch = new TxtSearch();
			txtSearch.search(word, path, extension);
			break;
		case ".xml":
			XMLSearch xmlSearch = new XMLSearch();
			xmlSearch.search(word, path, extension);
			break;
		case ".html":
		case ".htm":
			System.out.println("htm test");
			break;
		case ".bin":
			BinarySearch binarySearch = new BinarySearch();
			binarySearch.search(word, path, extension);
			break;
		}
	}

	private static boolean isValidExtension(String extension) {
		try {
			if (extension.charAt(0) != '.') {
				throw new IncorrectExtensionException();
			}
			if (extension.length() > 5) {
				throw new IncorrectExtensionException();
			}
			if (!(extension.equals(".html") || extension.equals(".htm") || extension.equals(".bin")
					|| extension.equals(".txt") || extension.equals(".xml"))) {
				throw new NotSupportedMediaTypeException();
			} else
				return true;
		} catch (IncorrectExtensionException e) {
			return false;
		} catch (NotSupportedMediaTypeException e) {
			return false;

		}
	}
}
