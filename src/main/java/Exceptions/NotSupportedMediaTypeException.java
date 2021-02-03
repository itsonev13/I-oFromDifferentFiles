package Exceptions;

public class NotSupportedMediaTypeException extends Exception {
	public NotSupportedMediaTypeException() {
		System.out.println("This media type is not supported please choose between .html,htm,.xml,.txt,.bin");
	}

}
