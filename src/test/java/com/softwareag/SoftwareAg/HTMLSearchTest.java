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

import IOOperations.HTMLSearch;

public class HTMLSearchTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("index.html");
			myWriter.write("<!DOCTYPE html>\r\n" + "<html lang=\"en\" xmlns:th=\"http://www.thymleaf.org\">\r\n"
					+ "\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"../static/css/lux.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"../static/css/index.css\">\r\n"
					+ "    <link rel='icon' href='../static/img/jumpman-logo.png' type='image/x-icon' sizes=\"16x16\" />\r\n"
					+ "    <!-- libraries-->\r\n"
					+ "    <link href=\"https://fonts.googleapis.com/css2?family=Pacifico&display=swap\" rel=\"stylesheet\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n"
					+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n"
					+ "    <title>Document</title>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n"
					+ "    <nav class=\"navbar navbar-expand-lg navbar-dark mybg-primary\">\r\n"
					+ "        <a class=\"navbar-brand\" href=\"#\"><img class=\"logo\" src=\"../static/img/jumpman-logo.png\" alt=\"jumpman-logo\" /></a>\r\n"
					+ "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "          <span class=\"navbar-toggler-icon\"></span>\r\n" + "        </button>\r\n" + "\r\n"
					+ "        <div class=\"collapse navbar-collapse\" id=\"navbarColor01\">\r\n"
					+ "            <ul class=\"navbar-nav mr-auto\">\r\n"
					+ "                <li class=\"nav-item active\">\r\n"
					+ "                    <a class=\"nav-link\" href=\"index.html\">Home\r\n"
					+ "                <span class=\"sr-only\">(current)</span>\r\n" + "                    </a>\r\n"
					+ "                </li>\r\n" + "                <li class=\"nav-item\">\r\n"
					+ "                    <a class=\"nav-link\" href=\"shoes.html\">Shoes</a>\r\n"
					+ "                </li>\r\n" + "                <li class=\"nav-item\">\r\n"
					+ "                    <a class=\"nav-link\" href=\"about.html\">About</a>\r\n"
					+ "                </li>\r\n" + "                <li class=\"nav-item dropdown\">\r\n"
					+ "                    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Log in/Sign up</a>\r\n"
					+ "                    <div class=\"dropdown-menu\">\r\n"
					+ "                        <a class=\"dropdown-item\" href=\"#\">Log in</a>\r\n"
					+ "                        <div class=\"dropdown-divider\"></div>\r\n"
					+ "                        <a class=\"dropdown-item\" href=\"#\">Sign up</a>\r\n"
					+ "                    </div>\r\n" + "                </li>\r\n" + "            </ul>\r\n"
					+ "            <form class=\"form-inline my-2 my-lg-0\">\r\n"
					+ "                <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\r\n"
					+ "                <button class=\"btn btn-secondary my-2 my-sm-0\" type=\"submit\">Search</button>\r\n"
					+ "            </form>\r\n" + "        </div>\r\n" + "    </nav>\r\n"
					+ "    <div class=\"main-container\">\r\n"
					+ "        <div id=\"carouselExampleControls\" class=\"carousel slide\" data-ride=\"carousel\">\r\n"
					+ "            <div class=\"carousel-inner\">\r\n"
					+ "                <div class=\"carousel-item active\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"img/1.jpg\" alt=\"First slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/2.jpg\" alt=\"Second slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/3.jpg\" alt=\"Third slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/4.jpg\" alt=\"Forth slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/5.jpg\" alt=\"Fifth slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/6.jpg\" alt=\"Sixth slide\">\r\n"
					+ "                </div>\r\n" + "                <div class=\"carousel-item\">\r\n"
					+ "                    <img class=\"d-block w-100\" src=\"../static/img/7.jpg\" alt=\"Eighth slide\">\r\n"
					+ "                </div>\r\n" + "            </div>\r\n"
					+ "            <a class=\"carousel-control-prev\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"prev\">\r\n"
					+ "                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n"
					+ "                <span class=\"sr-only\">Previous</span>\r\n" + "            </a>\r\n"
					+ "            <a class=\"carousel-control-next\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"next\">\r\n"
					+ "                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n"
					+ "                <span class=\"sr-only\">Next</span>\r\n" + "            </a>\r\n"
					+ "        </div>\r\n" + "    </div>\r\n"
					+ "    <footer class=\"bg-light text-center text-lg-start\">\r\n"
					+ "        <!-- Grid container -->\r\n" + "        <div class=\"container p-4\">\r\n"
					+ "            <!--Grid row-->\r\n" + "            <div class=\"row\">\r\n"
					+ "                <!--Grid column-->\r\n"
					+ "                <div class=\"col-lg-6 col-md-12 mb-4 mb-md-0\">\r\n"
					+ "                    <h5 class=\"text-uppercase\">Never quit</h5>\r\n" + "\r\n"
					+ "                    <p>\r\n"
					+ "                        \"If you quit once it becomes a habit. Never quit!\" - Michael Jordan\r\n"
					+ "                    </p>\r\n" + "                </div>\r\n"
					+ "                <!--Grid column-->\r\n" + "\r\n" + "                <!--Grid column-->\r\n"
					+ "                <div class=\"col-lg-5 col-md-8 mb-5 mb-md-0\">\r\n"
					+ "                    <h5 class=\"text-uppercase\">You can buy jordans from:</h5>\r\n" + "\r\n"
					+ "                    <ul class=\"list-unstyled mb-0\">\r\n" + "                        <li>\r\n"
					+ "                            <a href=\"https://www.footlocker.eu/gdpr?c=BG&l=en\" class=\"text-dark\">FootLocker    <img class=\"shops-logo\" src=\"../static/img/footlocker-logo.png\" alt=\"footlocker-logo\"/></a>\r\n"
					+ "                        </li>\r\n" + "                        <li class=\"sportdepot\">\r\n"
					+ "                            <a href=\"https://www.sportdepot.bg/\" class=\"text-dark\">SportDepot<img class=\"shops-logo2\" src=\"../static/img/sportdepot-logo.png\" alt=\"sportdepot-logo\"/></a>\r\n"
					+ "                        </li>\r\n" + "                        <li>\r\n"
					+ "                            <a href=\"https://www.nike.com/bg/\" class=\"text-dark\">Nike    <img class=\"shops-logo\" src=\"../static/img/nike-logo.png\" alt=\"nike-logo\"/></a>\r\n"
					+ "                        </li>\r\n" + "                    </ul>\r\n"
					+ "                </div>\r\n" + "            </div>\r\n" + "            <!--Grid row-->\r\n"
					+ "        </div>\r\n" + "        <!-- Grid container -->\r\n" + "\r\n"
					+ "        <!-- Copyright -->\r\n"
					+ "        <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2)\">\r\n"
					+ "            © 2020 Copyright: IVAN TSONEV ALL RIGHTS RESERVED\r\n" + "        </div>\r\n"
					+ "        <!-- Copyright -->\r\n" + "    </footer>\r\n" + "    <!-- Footer -->\r\n" + "\r\n"
					+ "</body>\r\n" + "\r\n" + "</html>");
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void searchShouldFindTheWordJodranWhenSearchingFileName() {
		// arrange
		HTMLSearch search = new HTMLSearch();
		// act
		search.search("Jordan", "index", ".html");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word Jordan is found"));
	}

	@Test
	public void searchShouldFindTheWordJodranWhenSearchingInFolder() {
		// arrange
		HTMLSearch search = new HTMLSearch();
		// act
		search.search("Jordan", "../", ".html");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith("The word Jordan is found"));
	}

	@Test
	public void searchShouldNOTFindTheWordRickGrimesWhenSearchingInNotExistingFile() {
		// arrange
		HTMLSearch search = new HTMLSearch();
		// act
		search.search("JordanGordan", "index", ".html");
		// assert
		assertTrue(outputStreamCaptor.toString().trim().startsWith(""));
	}

	@Test
	public void searchShouldThrowFileNotFoundException() {
		// arrange
		HTMLSearch search = new HTMLSearch();
		// act
		search.search("Jordan", "nosuchfile", ".html");
		// assert
		assertEquals("NO SUCH FILE OR DIRECTORY.Please Try again", outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void dispose() {
		File file = new File("index.html");
		file.delete();

	}

}
