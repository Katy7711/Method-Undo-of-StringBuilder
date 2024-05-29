package org.example;

import java.util.Stack;

public class StringsBuilder {

  private StringBuilder stringBuilder;
  private Stack<StringBuilder> snapshots = new Stack<>();

  public Stack<StringBuilder> getSnapshots() {
    return snapshots;
  }

  public StringsBuilder(String str) {
    this.stringBuilder = new StringBuilder(str);
  }
  public StringsBuilder(){

  }

  public StringsBuilder reverse() {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    stringBuilder.reverse();
    return this;
  }

  public StringsBuilder append(String str) {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    stringBuilder.append(str);
    return this;
  }

  public StringsBuilder appendCodePoint(int codePoint) {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    int lenghtBefore = stringBuilder.length();
    stringBuilder.appendCodePoint(codePoint);
    return this;
  }

  public StringsBuilder delete(int start, int end) {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    String deleted = stringBuilder.substring(start, end);
    stringBuilder.delete(start, end);
    return this;
  }

  public StringsBuilder replace(int start, int end, String str) {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    String deleted = stringBuilder.substring(start, end);
    stringBuilder.replace(start, end, str);
    return this;
  }

  public StringsBuilder insert(int offset, String str) {
    StringBuilder stringB = new StringBuilder(stringBuilder);
    snapshots.push(stringB);
    stringBuilder.insert(offset, str);
    return this;
  }

  public void undo() {
    if (!snapshots.isEmpty()) {
      stringBuilder = snapshots.lastElement();
      snapshots.pop();
    }
  }

  public String toString() {
    return stringBuilder.toString();
  }
}
