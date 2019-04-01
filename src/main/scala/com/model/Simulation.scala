package com.model

class Simulation(val numberOfDrones: Int, val area: Area, val maxTime: Int) {
  var time: Int = 0
  val fleet = new Fleet(numberOfDrones, area)


  def launch: Unit = {
    for(t <- 0 until maxTime) {
      time = t

    }
  }
}
