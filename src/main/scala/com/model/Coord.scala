package com.model

class Coord(var r: Int, var c: Int){

  def move(dr: Int, dc: Int) = {
    r = r + dr
    c = c + dc
  }

  override def toString: String = "(" + r + "," + c + ")"
}
