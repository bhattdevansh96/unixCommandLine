package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exceptions.InvalidArgsException;
import system.Directory;
import system.File;

public class Echo extends Command {

  Validator v;  
  
  public static String userString;

  /**
   * Checks if given arguments for Echo command are valid.
   * 
   * @param spl : Split array of arguments given by user.
   * @return true if given arguments are valid for program to execute
   */
  public void isValid(String s) {
    List<String> spl = Arrays.asList(s.trim().split("\""));
    int count = s.length() - s.replace("\"", "").length();
    if (count != 2) {
      throw new InvalidArgsException("echo : ");
    } else if (!(spl.size() == 2 || spl.size() == 3)) {
      throw new InvalidArgsException("echo : ");
    } else {
      int i = 0;
      for (String item : spl) {
        spl.set(i, item.trim());
        i++;
      }
      int count2 = spl.get(2).length() - spl.get(2).replace(">", "").length();
      if (!(0 < count2 && count2 < 3)) {
        throw new InvalidArgsException("echo : ");
      }
      //List<String> path = Arrays.asList(s.trim().split("\\s+"));
      //if (!v.PathFindFile(path.get(3)) || !v.PathFindDirectory(path.get(3))) {
      //  throw new InvalidArgsException("echo: ");
      } 
    }
 



  /**
   * Executes main functionality of Echo command.
   * 
   * @param spl : Split array of arguments given by user.
   */
  public void Execute(String s) {
    try {
      isValid(s);
      String sClean = echoArgsChecker(s);
      List<String> spl = Arrays.asList(sClean.trim().split("\\s+"));
      if (spl.contains("echo")) {
        System.out.println(userString);
      } else {
        List<String> splPath = Arrays.asList(spl.get(1).trim().split("/"));
        String fileWanted = splPath.get(splPath.size() - 1);
        // if (v.PathFindDirectory(s.substring(0, (s.length() -
        // fileWanted.length() - 1))))
        if (true) {
          Directory parentFolder = getObjectDIR(spl.get(1).substring(0,
              (spl.get(1).length() - fileWanted.length() - 1)));
          File file = parentFolder.getFileObject(fileWanted);
          if (file == null) {
            File newFile = new File(fileWanted);
            newFile.addText(userString);
            parentFolder.addFile(newFile);
          } else if (spl.get(0).equals(">")) {
            file.clearFile();
            file.addText(userString);
          } else if (spl.get(0).equals(">>")) {
            file.addText(userString);
          }
        }
      }
    } catch (InvalidArgsException e) {
    } catch (Exception e) {
    }

  }

  public String echoArgsChecker(String s) { // Tested (Works good)
    List<String> spl1 = new ArrayList<>(Arrays.asList(s.trim().split("\"")));
    userString = spl1.remove(1);
    return spl1.get(spl1.size() - 1).trim();
  }
}
