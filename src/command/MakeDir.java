package command;

import java.util.List;
import system.Directory;

public class MakeDir extends Command {

  @Override
  public void Execute(List<String> spl) {
    if (spl.size() == 2 && (!currentDir.containsFolder(spl.get(1)))
        && v.isValidName(spl.get(1))) {
      Directory newDirectory = new Directory(spl.get(1), currentDir);
      currentDir.addDirectory(newDirectory);
    } else if (spl.size() > 2) {
      for (int i = 1; i < spl.size(); i++) {
        if (!currentDir.containsFolder(spl.get(i))
            && v.isValidName(spl.get(i))) {
          Directory newDirectory = new Directory(spl.get(i), currentDir);
          currentDir.addDirectory(newDirectory);
        } else if (currentDir.containsFolder(spl.get(i))) {
          System.out.println(
              "A folder by the name " + spl.get(i) + " already exists.");
        } else if (!v.isValidName(spl.get(i))) {
          System.out.println("The folder name " + spl.get(i) + " is not valid. "
              + "Do not use special characters such as !@$&*()?:[]\"<>'`|="
              + "{}\\/,.; or white space .");
        }
      }
    } else {
      System.out.println("Invalid Command");
    }
  }
}
