package com.thaiopensource.relaxng.edit;

public class SourceLocation {
  public final String uri;
  public final int lineNumber;
  public final int columnNumber;

  public SourceLocation(String uri, int lineNumber, int columnNumber) {
    this.uri = uri;
    this.lineNumber = lineNumber;
    this.columnNumber = columnNumber;
  }

  public String getUri() {
    return uri;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public int getColumnNumber() {
    return columnNumber;
  }
}
