// **********************************************************
// Assignment2:
// Student1: Darshan Mehta
// UTOR user_name: mehtada3
// UT Student #: 1001482031
// Author: Darshan
//
// Student2:
// UTOR user_name: bhattdev
// UT Student #: 1001442209
// Author: Devansh Bhatt
//
// Student3:
// UTOR user_name: pandyara
// UT Student #: 1001280008
// Author: Raj Pandya
//
// Student4: Daniel Guta
// UTOR user_name: gutadani
// UT Student #: 1001715879
// Author: Daniel Guta
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************
package driver;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import command.*;

public class JShell {
 
  private static Command c;
  private static CommandTable commandTable = new CommandTable();
  private static Command h = new History();

  
  public static void main(String[] args) {
    
    Command.initiateRootDir();
    commandTable.isValidCommand();

    // Get user input
    Scanner input = new Scanner(System.in);
    System.out.print("/# ");
    String userInput = input.nextLine(); 

    // While loop runs until user enters 'exit'
    while (!userInput.equals("exit")) {
      ((History) h).addCommand(userInput); // Adding to the history
      List<String> spl = Arrays.asList(userInput.trim().split("\\s+"));
      
      if (commandTable.cmds.containsKey(spl.get(0))) {
        // Echo Exception case; send echo command original userInput
        if (spl.get(0).equals("echo")) {
          Echo x = new Echo();
          x.Execute(userInput);
        // Execution for remaining commands
        } else {
          c = (Command) commandTable.cmds.get(spl.get(0));
          c.Execute(spl);
        }
      // Quick user notification for invalid inputs
      } else if (!spl.get(0).equals("")) {
        System.out.println(spl.get(0) + ": Invalid command name.");
      }

      System.out.print("/# ");
      userInput = input.nextLine();
    }
    input.close();
  }
}
