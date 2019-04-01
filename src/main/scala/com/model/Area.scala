package com.model

class Area(var nbRows: Int, var nbCols: Int) {
  private var theMap: Array[Array[Cell.Value]] = initialMap(0.1)

  private def initialMap(incidentWeight: Double): Array[Array[Cell.Value]] = {
    val random = scala.util.Random
    var returnMap = Array.ofDim[Cell.Value](nbRows, nbCols)

    def initCell(c: Coord): Unit = {
      val cellValue = if(random.nextDouble() < incidentWeight) {
        Cell.Incident
      } else {
        Cell.Empty
      }
      returnMap(c.r)(c.c) = cellValue
    }


    var coordCursor = null

    for (row <- 0 until nbRows) {
      for (col <- 0 until nbCols) {
        val coordonnee = new Coord(row, col)
        initCell(coordonnee)
        //println("initialisation de la cell: " + coordonnee)
      }
    }
    return returnMap
  }

  def isOnTheMap(coord: Coord): Boolean = try {this.theMap(coord.r)(coord.c) != null} catch {case e:Exception => false}

  def nearestCells(coord: Coord): List[Coord] = {
    var returnCoords: List[Coord] = List()
    // On vérifie d'abord que la coord est bien sur la map
    if (!isOnTheMap(coord)) return returnCoords
    // Si c'est le cas, on calcule les cells adjacentes
    val modifiers = List((1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, 1), (-1, 1), (1, -1))
    modifiers.foreach {
      modifier => {
        val (dr, dc) = modifier
        var newCoord = new Coord(coord.r + dr, coord.c + dc)
        if(isOnTheMap(newCoord)) {returnCoords = newCoord :: returnCoords}
      }
    }
    return returnCoords
  }


  override def toString: String = {
    var str: String = ""

    for (row <- 0 until nbRows) {
      for (col <- 0 until nbCols) {
        str = str + this.theMap(row)(col) + " "
      }
      str = str + "\n"
    }
    return str
  }
}
