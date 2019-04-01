package com.model

class Simulation(val numberOfDrones: Int, val area: Area, val maxTime: Int) {
  val fleet = new Fleet(numberOfDrones, area)


  def launch(t: Int = 0): Unit = {
    if(t < maxTime) {
      println("--- t = " + t + " ---")
      fleet.doTurn
      launch(t + 1)
    }
  }

}
