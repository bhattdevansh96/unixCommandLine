package command;

import java.util.List;
import system.Directory;
import system.File;

public class ListDir extends Command {

  @Override
  public void Execute(List<String> spl) {

    // Check to see if any arguments at all are given
    if (spl.size() > 1) {

      // Create a list of only the arguments
      List<String> listOfPaths = spl.subList(1, spl.size());

      for (String individualPath : listOfPaths) {

        // If p specifies a directory, print p, a colon,
        // then the contents of that directory, then an extra new line
        if (v.PathFindDirectory(individualPath)) {

          Directory dirToPrint = getObjectDIR(individualPath);

          System.out.println(individualPath + ": ");

          List<String> listOfContents = dirToPrint.listOfAllFoldersAndFiles();

          for (String name : listOfContents) {
            System.out.print(name + ", ");
          }

          System.out.println();

          // If p specifies a file, print p (i.e. the name of the file only)
        } else if (v.PathFindFile(individualPath)) {

          File fileToPrint = getObjectFILE(individualPath);
          System.out.println(
              individualPath + ": " + fileToPrint.getFileName() + "/n");

        } else

          // If p does not exist, print a suitable error message
          System.out.println(individualPath + ": Invalid Path /n");
      }
    } else {

      // If no paths are given, print the contents (file or directory)
      // of the current directory, with a new line following each of
      // the content (file or directory)
      List<String> listOfContents = currentDir.listOfAllFoldersAndFiles();
      
      for (String name : listOfContents) {
        System.out.println(name);
      }
    }
  }
}

