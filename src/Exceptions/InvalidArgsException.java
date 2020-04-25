package Exceptions;

public class InvalidArgsException extends NullPointerException {
  
  private static final long serialVersionUID = 6105407006091281727L;

  public InvalidArgsException(String commandName){
    System.out.println(commandName + "Invalid Argument(s) Provided.");
  }
  
}
