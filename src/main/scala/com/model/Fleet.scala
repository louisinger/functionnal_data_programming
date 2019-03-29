package com.model

class Fleet(val numberOfDrone:Int) {
  val drones = initFleet

  private def initFleet: Array[Drone] = {
    var returnDrones = new Array[Drone](numberOfDrone)
    for(i <- 0 until numberOfDrone) {
      returnDrones(i) = new Drone("FL" + i, new Coord(0, 0))
    }
    return returnDrones
  }

  override def toString: String = {
    var str: String = ""
    for(i <- 0 until numberOfDrone) {
      str = str + drones(i) + "\n"
    }
    return str
  }
}
