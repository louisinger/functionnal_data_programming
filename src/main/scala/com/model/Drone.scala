package com.model

class Drone(val name: String, val area: Area, var position: Coord) {
  var currentState: State.Value = State.Surveil

  def initPosition(initialRow: Int, initialCol: Int): Unit = {
    position = new Coord(initialRow, initialCol)
  }

  def changeState(newState: State.Value): Unit = {
    currentState = newState
  }

  def move(dr: Int, dc: Int): Unit = {
    position.move(dr, dc)
  }

  def action: String = {
    currentState match {
      case State.Rest => "The drone " + name + " is resting."
      case State.Alert => {
        currentState = State.Surveil
        "The drone " + name + " signals an incident at " + position
      }
      case State.Surveil => {
        val rand = scala.util.Random
        val cells = area.nearestCells(position)
        val str = "The drone " + name + " moves from " + position + " to "
        position = cells(rand.nextInt(cells.length))
        if(area.incidentAt(position)) currentState = State.Alert
        str + position
      }
    }
  }

  override def toString: String = {
    val str: String = "Drone: " + name + " | pos: " + position + " | state: " + currentState
    str
  }



}
