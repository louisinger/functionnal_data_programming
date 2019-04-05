package com.model

import scala.annotation.tailrec

class Simulation(val numberOfDrones: Int, val area: Area, val maxTime: Int) {
  val fleet = new Fleet(numberOfDrones, area)

  @tailrec final def launch(time: Int = 0): Unit = {
    if(time < maxTime) {
      println("--- t = " + time + " ---")
      fleet.doTurn()
      Thread.sleep(1000)
      launch(time + 1)
    }
  }
}
