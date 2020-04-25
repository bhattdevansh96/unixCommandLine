package command;

import java.util.List;
import java.util.Stack;
import system.Directory;

public class DirStack extends ChangeDir {
  private static Stack<Directory> dirStack = new Stack<Directory>();

  @Override
  public void Execute(List<String> spl) {

    if (spl.get(0).equals("pushd") && spl.size() == 2) {
      if (isValid(spl)) {
        super.Execute(spl); // fix so that pushD won't run if path is invalid
        pushD();
      }

    } else if (spl.get(0).equals("popd") && spl.size() == 1) {
      popD();
    }
  }

  public void pushD() {
    dirStack.push(currentDir);
  }

  public void popD() {
    if (!dirStack.isEmpty()) {
      currentDir = dirStack.pop();
    } else {
      System.out.println("Stack is empty");
    }
  }

}
