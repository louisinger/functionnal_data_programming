package com.main

import com.model.{Area, Coord, Fleet}

object Main {

  def main(args: Array[String]): Unit = {
    val area = new Area(20, 20)
    println(area)

    val myFleet = new Fleet(5)
    println(myFleet)
  }
}
