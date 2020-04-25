package command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import system.Directory;
import system.File;

public class Validator {
  static Pattern p = Pattern.compile("\\p{Punct}");
  static Matcher m;
  static Directory userDirectoryLocation;

  
  /**
   * Returns True if the Directory Path is correct.
   * 
   * @param path can be relative or absolute path.
   * @return boolean.
   */
  public boolean PathFindDirectory(String path) {
    Directory dir = null;
    if (!path.contains("/")) {
      dir = Command.getCurrentDir().getDirectoryObject(path);

    } else {
      if (isAbsolutePath(path)) {
        dir = Command.getRootDir();
        path = path.substring(1); // get rid of beginning "/"
        
      } else {
        dir = Command.getCurrentDir();
      }
      
      // start looking for directories
      String[] spl = path.trim().split("/");
      for (String location : spl) {
        if (location.equals("..")) {
          if (dir.getParent() != null) {
            dir = dir.getParent();
          }
        } else if (!location.equals(".")) {
          dir = dir.getDirectoryObject(location);
          if (dir == null){return false;} 
        }
      }
    }
    userDirectoryLocation = dir; // for File Path
    return dir != null;
  }
  
  /**
   * Returns True if the File Path is correct.
   * 
   * @param path can be relative or absolute path.
   * @return boolean.
   */
  public boolean PathFindFile(String path) {
    File userFile = null;
    if (!path.contains("/")) {
      userFile = Command.getCurrentDir().getFileObject(path);
    } else {

      int i = path.lastIndexOf("/");
      String newPath = path.substring(0, i); // returns path without last item in path
      if (PathFindDirectory(newPath)) {
        userFile = userDirectoryLocation
            .getFileObject(path.substring(i + 1, path.length())); // sends end argument to check if it exists in file
      }
    }
    return userFile != null;
  }

  /**
   * Returns True if the Folder name is valid.
   * 
   * @param String name.
   * @return boolean.
   */
  // True if file or directory name is Valid according to client specification.
  public boolean isValidName(String name) {
    m = p.matcher(name);
    return !m.find();
  }
  
  /**
   * Returns True if the Path is absolute.
   * 
   * @param String path.
   * @return boolean.
   */
  public boolean isAbsolutePath(String path) {
    return path.startsWith("/"); // true means -> Absolute path
  }
  
  /**
   * Returns True if folderName is not a path.
   * 
   * @param String folderName.
   * @return boolean.
   */
  public boolean isNotPath(String folderName) {
    return !folderName.contains("/"); 
  }
  
  // testing only ** make methods to static if using this test **
  /*public static void main(String [] args){
    Command.initiateRootDir();
    Directory root = Command.getRootDir();
    Directory f = new Directory("newDir", root);
    root.addDirectory(f);
    File n = new File("newFile");
    f.addFile(n);
    System.out.println(PathFindDirectory("/./newDir/../newDir/"));
  }*/
}


