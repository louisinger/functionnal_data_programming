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
        println("initialisation de la cell: " + coordonnee)
      }
    }
    return returnMap
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
