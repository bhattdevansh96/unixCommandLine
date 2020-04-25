package system;

import java.util.*;

public class Directory {

  // parent of the children
  private Directory parent;
  
  // name of this directory
  private String workSpaceName;

  // References to other directories and files in this workSpace
  private List<Object> children = new ArrayList<Object>();
  private List<String> childrenName = new ArrayList<String>();

  // Initialize new directories, with parent node
  public Directory(String a, Directory parent) {
    this.workSpaceName = a;
    this.parent = parent;
  }

  // Add directory to current children
  public void addDirectory(Directory next) {
    children.add(next);
    childrenName.add(next.getFileName());
  }

  // Add file to current children
  public void addFile(File fileObject) {
    children.add(fileObject);
    childrenName.add(fileObject.getFileName());
  }

  // Prints all items in children
  public List<String> listOfAllFoldersAndFiles() {
    return childrenName;
  }

  // returns worksSpaceName
  public String getFileName() {
    return workSpaceName;
  }

  // returns parent of children
  public Directory getParent() {
    return parent;
  }
  
  public boolean containsFolder(String folderName){
    return childrenName.contains(folderName);
  }

  public Directory getDirectoryObject(String childName) {
    if (childName.equals("..") && parent == null){return this;}
    if (childrenName.contains(childName)) {
      if (children.get(childrenName.indexOf(childName)).getClass()
          .equals(Directory.class)) {
        return (Directory) children.get(childrenName.indexOf(childName));
      }
    }
    return null;
  }

  public File getFileObject(String childName) {
    if (childrenName.contains(childName)) {
      if (children.get(childrenName.indexOf(childName)).getClass()
          .equals(File.class)) {
        return (File) children.get(childrenName.indexOf(childName));
      }
    }
    return null;
  }
}

