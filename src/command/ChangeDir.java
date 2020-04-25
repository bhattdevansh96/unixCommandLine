package command;

import java.util.List;

public class ChangeDir extends Command {


  public void Execute(List<String> spl) {
    if (isValid(spl)) {
      currentDir = getObjectDIR(spl.get(1));
    } else {
      System.out.println("not valid path");
    }
  }

  public boolean isValid(List<String> spl) {
    return (spl.size() == 2 && v.PathFindDirectory(spl.get(1)));
  }
}


