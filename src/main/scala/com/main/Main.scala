package com.main

import com.model.{Area, Coord, Fleet}

object Main {

  def main(args: Array[String]): Unit = {
    var area = new Area(20, 20)
    println(area.isOnTheMap(new Coord(-3, 5)))

    val myFleet = new Fleet(5, area)
    println(myFleet)
  }
}
