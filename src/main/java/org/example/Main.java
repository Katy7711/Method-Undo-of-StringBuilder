package org.example;

public class Main {

  public static void main(String[] args) {
    StringsBuilder stringsBuilder = new StringsBuilder("vvv");
    StringsBuilder ab = stringsBuilder.append("aaa");
    ab.append("bbb");
    ab.append("fff");
    System.out.println(ab.getSnapshots());
    System.out.println(ab);
    ab.undo();
    System.out.println(ab.getSnapshots());
    System.out.println(ab);
    ab.reverse();
    System.out.println(ab);
    System.out.println(ab.getSnapshots());
    ab.undo();
    System.out.println(ab);



  }
}