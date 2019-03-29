package com.model

object State extends Enumeration {
  type State = Value
  val Rest: State = Value("Rest")
  val Surveil: State = Value("Surveil")
  val Alert: State = Value("Alert")
}
