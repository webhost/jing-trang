package com.thaiopensource.relaxng.impl;

import org.xml.sax.Locator;

class RestrictionViolationException extends Exception {
  private String messageId;
  private Locator loc;
  private Name name;

  RestrictionViolationException(String messageId) {
    this.messageId = messageId;
  }

  RestrictionViolationException(String messageId, Name name) {
    this.messageId = messageId;
    this.name = name;
  }

  String getMessageId() {
    return messageId;
  }

  Locator getLocator() {
    return loc;
  }

  void maybeSetLocator(Locator loc) {
    if (this.loc == null)
      this.loc = loc;
  }

  Name getName() {
    return name;
  }
}
  
