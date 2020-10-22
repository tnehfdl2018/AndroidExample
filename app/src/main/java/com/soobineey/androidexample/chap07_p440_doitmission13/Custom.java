package com.soobineey.androidexample.chap07_p440_doitmission13;

public class Custom {

  private String name;
  private String birth;
  private String phoneNum;

  public Custom(String name, String birth, String phoneNum) {
    this.name = name;
    this.birth = birth;
    this.phoneNum = phoneNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }
}
