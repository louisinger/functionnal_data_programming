package com.model

class Coord(var r: Int, var c: Int){

  def move(dr: Int, dc: Int) = {
    r = r + dr
    c = c + dc
  }

  override def equals(o: Any): Boolean = {
    o match {
      case coord: Coord => if(coord.c == this.c && coord.r == this.r) true else false
      case _ => false
    }

  }

  override def toString: String = "(" + r + "," + c + ")"
}
