package command;

import java.util.ArrayList;
import java.util.List;

import system.File;

public class History extends Command {

  private static File h = new File("History");; // storing commands in a File

  /**
   * Prints out the history of commands entered from JShell. Prints out specific
   * number commands specified by user.
   * 
   * @param List of strings containing user input
   *
   */
  public void Execute(List<String> spl) {
    if (spl.size() < 3) {
      try {
        
        if (spl.size() == 1) {
          h.printContentsOfFile();

        } else if (Integer.parseInt(spl.get(1)) > -1) {
          int i = Integer.parseInt(spl.get(1));
          printContents(i);
        }
        
      } catch (NumberFormatException e) {
        System.out.println(e);
      }
    } else {
      // throw exception that there are more than 2 arguments given
    }
  }

  /**
   * Adds user commands into a File storage system
   * 
   * @param cmd is the command inputed by the user
   * 
   */
  public void addCommand(String cmd) {
    h.addText(cmd);
  }

  /**
   * Prints out the list of commands
   * 
   * @param numOfHistoryToPrint are specific number of commands to be printed
   * 
   */
  public void printContents(int numOfHistoryToPrint) {
    ArrayList<String> histry = h.getTextFileContents();
    if (numOfHistoryToPrint > histry.size()) {
      h.printContentsOfFile();
    } else {
      for (int i = histry.size() - numOfHistoryToPrint; i < histry
          .size(); i++) {
        System.out.println(histry.get(i));
      }
    }
  }

}
