package command;

import java.util.Hashtable;
import java.util.List;

public class Manual extends Command {

  public static Hashtable<String, String> commandDocumentation =
      new Hashtable<String, String>();

  {
    commandDocumentation.put("exit",
        "Command: exit\nArguments: NONE\nDescription: "
            + "Quits the program.");

    commandDocumentation.put("mkdir",
        "Command: mkdir\nArguments: DIR ...\nDescription: "
            + "Creates directories, each of which may be relative to the "
            + "current directory or may be a full path.");

    commandDocumentation.put("cd",
        "Command: cd\nArguments: DIR\nDescription: "
            + "Change directory to DIR, which may be relative "
            + "to the current directory or may be a full path. "
            + "As with Unix, (..) means a parent directory and a (.) "
            + "means the current directory. "
            + "The directory separator must be (/), the forward slash. "
            + "The root of the file system is a single slash: (/).");

    commandDocumentation.put("ls",
        "Command: ls\nArguments: [PATH ...]\nDescription: "
            + "If no paths are given, print the contents "
            + "(file or directory) of the current directory, "
            + "with a new line following each of the content "
            + "(file or directory). Otherwise, for each path p, "
            + "the order listed: If p specifies a file, print p "
            + "(i.e. the name of the file only). If p specifies "
            + "a directory, print p, a colon, then the contents "
            + "of that directory, then an extra new line. If p "
            + "does not exist, print a suitable error message.");

    commandDocumentation.put("pwd",
        "Command: pwd\nArguments: NONE\nDescription: "
            + "Print the current working directory path "
            + "(i.e. the whole absolute path).");

    commandDocumentation.put("pushd",
        "Command: pushd\nArguments: DIR\nDescription: "
            + "Saves the current working directory by pushing "
            + "onto the directory stack and then changes the "
            + "new current working directory to DIR. The push "
            + "must be consistent as per the LIFO behavior of "
            + "a stack. The pushd command saves the old current "
            + "working directory in directory of stack so that "
            + "it can be returned to at any time "
            + "(via the popd command). The size of the directory "
            + "stack is dynamic and dependent on the pushd and "
            + "popd commands.");

    commandDocumentation.put("popd",
        "Command: popd\nArguments: NONE\nDescription: "
            + "Remove the top entry from the directory stack, "
            + "and cd into it. The removal must be consistent "
            + "as per the LIFO behavior of a stack. "
            + "The popd command removes the top most directory "
            + "from the directory stack and makes it to the "
            + "current working directory. If there is no "
            + "directory onto the stack, then give appropriate "
            + "error message.");

    commandDocumentation.put("history",
        "Command: history\nArguments: [number]\nDescription: "
            + "This command will print out recent commands, one "
            + "command per line, where number is the amount of "
            + "previous commands to display.");

    commandDocumentation.put("cat",
        "Command: cat\nArguments: FILE\nDescription: "
            + "Display the contents of FILE in the shell.");

    commandDocumentation.put("echo",
        "Command: echo\nArguments: STRING [> OUTFILE] or "
            + "STRING >> OUTFILE\nDescription: If OUTFILE is not "
            + "provided, print STRING on the shell. Otherwise, put "
            + "STRING into file OUTFILE. STRING is a string of "
            + "characters surrounded by double quotation marks. "
            + "This creates a new file if OUTFILE does not exists "
            + "and erases the old contents if OUTFILE already exists. "
            + "In either case, the only thing in OUTFILE should be "
            + "STRING if the (>) operator is used. If (>>) is used "
            + "it appends to the outfile instead of overwriting.");

    commandDocumentation.put("man",
        "Command: man\nArguments: CMD\nDescription: "
            + "Print documentation for CMD.");
  }

  @Override
  public void Execute(List<String> spl) {

    // Check the amount of arguments and if the argument is valid
    if ((spl.size() == 2) && (commandDocumentation.containsKey(spl.get(1)))) {
      
      // Print the respective documentation for the desired command
      System.out.println(commandDocumentation.get(spl.get(1)));
      
    } else
      
      // Prompt user that the input is invalid
      System.out.println("Invalid Argument(s) Provided.");
  }
}
