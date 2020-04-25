package command;

import java.util.Hashtable;

public class CommandTable {

  public Hashtable<String, Object> cmds = new Hashtable<String, Object>();

  public void isValidCommand() {

    cmds.put("mkdir", new MakeDir());
    cmds.put("cat", new Cat());
    cmds.put("cd", new ChangeDir());
    cmds.put("pushd", new DirStack());
    cmds.put("popd", new DirStack());
    cmds.put("echo", new Echo());
    cmds.put("history", new History());
    cmds.put("ls", new ListDir());
    cmds.put("man", new Manual());
    cmds.put("pwd", new PrintWDir());

   
      
  }
}
