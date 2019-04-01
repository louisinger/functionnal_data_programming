package com.main

import com.model.{Area, Coord, Fleet, Simulation}

object Main {

  def main(args: Array[String]): Unit = {
    val area = new Area(20, 20)
    println(area.isOnTheMap(new Coord(-3, 5)))

    val simulation = new Simulation(3, area, 20)

    simulation.launch()
  }

}
