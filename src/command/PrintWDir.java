package command;

import system.Directory;
import java.util.*;

public class PrintWDir extends Command 
{
  @Override
  public void Execute(List<String> spl) 
  {  
    //stores the different parts  of the path
    List<String> path = new ArrayList<String>(); 
    //finds the current working directory
    Directory currentDirectory = Command.getCurrentDir();
    //final return string of the whole path
    String fullPath = "";
    
    //Finds the parent of the current working directory, then finds the 
    //parents as it goes up in hierarchy until it reaches the root node
    //whose parent is null.
    while(currentDirectory != null)
    {
      path.add(currentDirectory.getFileName());
      currentDirectory = currentDirectory.getParent();
    }
    
    //Adds all the nodes from the path to a String for the user. 
    for(int i = path.size() - 1; i >= 0; i--){
      fullPath += path.get(i) + "/";
    }
    System.out.println(fullPath);
  }
}
