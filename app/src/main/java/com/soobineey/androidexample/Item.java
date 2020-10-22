package com.soobineey.androidexample;

public class Item {

  private String title;
  private String subscript;
  private Class className;

  public Item(String title, String subscript, Class className) {
    this.title = title;
    this.subscript = subscript;
    this.className = className;
  }

  public Class getClassName() {
    return className;
  }

  public void setClassName(Class className) {
    this.className = className;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubscript() {
    return subscript;
  }

  public void setSubscript(String subscript) {
    this.subscript = subscript;
  }
}
