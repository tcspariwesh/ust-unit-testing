package com.ust;

public class Account {

  public boolean withdraw(float amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    } else return true;
  }

 
}
