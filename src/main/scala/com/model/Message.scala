package com.model

class Message(val droneName: String, val value: String, val isIncident: Boolean) {

  override def toString: String = {
    var str: String = ""
    if (isIncident) str = s"[INCIDENT] "
    str += s"$droneName: $value"
    str
  }
}
