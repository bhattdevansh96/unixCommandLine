package command;

import java.util.Arrays;
import java.util.List;

import system.Directory;
import system.File;

/**
 * Initializes main File System.
 */
public abstract class Command {

  protected Validator v = new Validator();
  protected static Directory rootDir;
  protected static Directory currentDir;


  public static void initiateRootDir() {
    rootDir = new Directory("", null);
    currentDir = rootDir;
  }
  
  public boolean isValid(List<String> spl) {
    return false;
    // Leave empty for now
  }

  public void Execute(List<String> spl) {
    // Leave empty for now
  }


  /**
   * Returns the root directory.
   * 
   * @return rootDir
   */
  public static Directory getRootDir() {
    return rootDir;
  }


  /**
   * Returns the current directory.
   * 
   * @return currentDir
   */
  public static Directory getCurrentDir() {
    return currentDir;
  }


  /**
   * Returns Directory object reference.
   * 
   * @param path can be relative or absolute path.
   * @return Directory Object.
   */
  protected Directory getObjectDIR(String path) {  // TODO: Refactor Code. Use userDirectoryLocation variable
    Directory position = null;
    List<String> splPath;

    // checks if path is absolute or relative;
    // sets starting position accordingly.
    if (v.isAbsolutePath(path)) {
      position = rootDir;
      path = path.substring(1);
    } else {
      position = currentDir;
    }

    splPath = Arrays.asList(path.trim().split("/"));
    // Finds and goes into the next directory in path.
    for (String dir : splPath) {
      if (dir.contentEquals("..")) {
        if (!position.equals(rootDir)) {
          position = position.getParent();
        }
      } else if (!dir.matches(".")) {
        position = position.getDirectoryObject(dir);
      }
    }

    return position;
  }


  /**
   * Returns File object reference.
   * 
   * @param path can be relative or absolute.
   * @return File object.
   */
  public File getObjectFILE(String path) {
    Directory position = null;
    Directory parent = null;
    List<String> splPath;
    String newPath;
    String fileWanted;
    File result = null;

    // checks if path is absolute or relative;
    // sets starting position accordingly.
    if (v.isAbsolutePath(path)) { 
      position = rootDir;
      newPath = path.substring(1);
    } else {
      position = currentDir;
      newPath = path;
    }

    splPath = Arrays.asList(newPath.trim().split("/"));
    fileWanted = splPath.get(splPath.size() - 1);

    // if the path is only a file name
    if (splPath.size() == 1) {
      result = position.getFileObject(fileWanted);
      // gets parent of file, then file, with help of getObjectDIR.
    } else {
      parent = getObjectDIR(
          path.substring(0, (path.length() - fileWanted.length() - 1)));
      result = parent.getFileObject(fileWanted);
    }

    return result;
  }
}
