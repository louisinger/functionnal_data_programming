package com.model

class Area(var nbRows: Int, var nbCols: Int) {
  private var theMap: Array[Array[Cell.Value]] = initialMap(0.1)

  private def initialMap(incidentWeight: Double): Array[Array[Cell.Value]] = {
    val random = scala.util.Random
    var returnMap = Array.ofDim[Cell.Value](nbRows, nbCols)

    def initCell(c: Coord): Unit = {
      val cellValue = if(incidentWeight < random.nextDouble()) Cell.Incident else Cell.Empty
      returnMap(c.r)(c.c) = cellValue
    }

    var coordCursor = null

    for (row <- 0 until (nbRows-1)) {
      for (col <- 0 until (nbCols - 1)) {
        initCell(new Coord(row, col))
      }
    }
    return returnMap
  }

  override def toString: String = {
    var str = null

    for (row <- 0 until (nbRows-1)) {
      for (col <- 0 until (nbCols-1)) {
        str += this.theMap(row)(col)
      }
      str += "\n"
    }

    return str
  }
}
