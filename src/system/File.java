package system;

import java.util.ArrayList;

public class File {

  // Create a new "file" that is empty and can have text "written" to it

  private ArrayList<String> textFile = new ArrayList<String>();
  
  private String fileName;

  public File(String a) {
    this.fileName = a;
  }

  public void addText(String str) {
    textFile.add(str);
  }

  public String getFileName() {
    return this.fileName;
  }

  public void printContentsOfFile() {
    for (String line : textFile) {
      System.out.println(line);
    }
    
  }
  
  public ArrayList<String> getTextFileContents() {
    return textFile;
  }

  // Makes File object empty (for Echo usage)
  public void clearFile() {
    this.textFile.clear();
  }

}
