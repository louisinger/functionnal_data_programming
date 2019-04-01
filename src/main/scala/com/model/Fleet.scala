package com.model

class Fleet(val numberOfDrone:Int, val area: Area) {
  var visitedCells: List[Coord] = List()
  val drones = initFleet


  private def isVisited(coord: Coord): Boolean = visitedCells.contains(coord)

  private def getRandomCoord: Coord = {
    val random = scala.util.Random
    val r = random.nextInt(area.nbRows)
    val c = random.nextInt(area.nbCols)
    val theRandomCoord: Coord = new Coord(r, c)
    if(this.isVisited(theRandomCoord)) getRandomCoord else {
      visitedCells = theRandomCoord :: visitedCells
      theRandomCoord
    }
  }

  private def initFleet: Array[Drone] = {
    var returnDrones = new Array[Drone](numberOfDrone)
    for(i <- 0 until numberOfDrone) {
      returnDrones(i) = new Drone("FL" + i, area ,getRandomCoord)
    }
    return returnDrones
  }

  def doTurn: Unit = {
    drones.foreach(drone => {
      println(drone.action)
    })
  }

  override def toString: String = {
    var str: String = ""
    for(i <- 0 until numberOfDrone) {
      str = str + drones(i) + "\n"
    }
    str = str + "visitedCells: " + visitedCells
    return str
  }
}
