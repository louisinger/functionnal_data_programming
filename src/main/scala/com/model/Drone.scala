package com.model

class Drone(val name: String, var position: Coord) {
  var currentState: State.Value = State.Rest

  def initPosition(initialRow: Int, initialCol: Int) = {
    position = new Coord(initialRow, initialCol)
  }

  def changeState(newState: State.Value): Unit = {
    currentState = newState
  }

  def move(dr: Int, dc: Int): Unit = {
    position.move(dr, dc)
  }

  override def toString: String = {
    var str: String = "Drone: " + name + " | pos: " + position + " | state: " + currentState
    return str
  }



}
