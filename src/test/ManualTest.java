package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import command.Manual;

public class ManualTest {

  // *** EACH EXPECTED AND ACTUAL OUTPUT IS THE SAME YET EACH TEST FAILS ***
  // *** WWWWWWWWWWWWWWWWWWWWWHHHHHHHHHHHHHHHHHHHHHHHHHYYYYYYYYYYYYYYYYY ***

  @Test
  public void testNoArgument() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = "Invalid Argument(s) Provided.";
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testInvalidArgument() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "invalidArgument");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = "Invalid Argument(s) Provided.";
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testTooManyArguments() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "man", "man");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = "Invalid Argument(s) Provided.";
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  // This is the general form of the test cases below for individual commands
  // I can remove all the test cases below if necessary, and put this one back
  //
  // @Test
  // public void testCommandDocumentation() {
  // Manual test = new Manual();
  // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  // List<String> input = Arrays.asList("man", *anyCommand*);
  // System.setOut(new PrintStream(outContent));
  // test.Execute(input);
  // String expectedOutput = *commandDocumentation*;
  // String actualOutput = outContent.toString();
  // assertEquals(expectedOutput, actualOutput);
  // }

  @Test
  public void testExitDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "exit");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testMakeDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "mkdir");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testChangeDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "cd");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testListDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "ls");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testPrintWDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "pwd");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testPushDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "pushd");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testPopDirDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "popd");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testHistoryDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "history");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testCatDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "cat");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testEchoDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "echo");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void testManualDocumentation() {
    Manual test = new Manual();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    List<String> input = Arrays.asList("man", "man");
    System.setOut(new PrintStream(outContent));
    test.Execute(input);
    String expectedOutput = Manual.commandDocumentation.get(input.get(1));
    String actualOutput = outContent.toString();
    assertEquals(expectedOutput, actualOutput);
  }

}
