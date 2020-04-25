package command;

import java.util.ArrayList;
import java.util.List;

import Exceptions.InvalidArgsException;
import system.File;

public class Cat extends Command {

  Validator v;

  /**
   * Checks if given arguments are valid for cat to execute correctly.
   */
  public void isValid(List<String> spl) throws InvalidArgsException {
    if (spl.size() != 2) {
      throw new InvalidArgsException("cat : ");
    //} else if (!v.PathFindFile(spl.get(1))) {
    //  throw new InvalidArgsException("cat2 : ");
    }
  }


  /**
   * Prints out contents of file, one line at a time.
   */
  public void Execute(List<String> spl) {
    try {
      isValid(spl);
      File fileObject = getObjectFILE(spl.get(1));
      ArrayList<String> fileContents = fileObject.getTextFileContents();
      for (String line : fileContents) {
        System.out.println(line);
      }
    } catch (InvalidArgsException e) {
      System.out.println("Invalid Argument(s) Provided (Code 1).");
    } catch (Exception e) {
      System.out.println("Invalid Argument(s) Provided (Code 2).");

    }
    
  }
}
