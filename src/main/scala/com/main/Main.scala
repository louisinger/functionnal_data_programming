package com.main

import com.model.{Area, Coord, Fleet}

object Main {

  def main(args: Array[String]): Unit = {
    var area = new Area(20, 20)
    println(area.isOnTheMap(new Coord(-3, 5)))

    val myFleet = new Fleet(5, area)
    println(myFleet)
    println("Test pour la coordonnée: (0,4): " + area.nearestCells(new Coord(0, 4)))
    println("Test pour la coordonnée: (10,3): " + area.nearestCells(new Coord(10, 3)))
  }
}
