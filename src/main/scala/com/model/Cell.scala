package com.model

object Cell extends Enumeration {
  type Cell = Value
  val Empty: Cell = Value("0")
  val Incident: Cell = Value("1")
}
