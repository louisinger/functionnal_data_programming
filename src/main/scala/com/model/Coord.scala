package com.model

class Coord(var r: Int, var c: Int){

  def move(dr: Int, dc: Int) = {
    r = r + dr
    c = c + dc
  }

  override def equals(o: Any): Boolean = {
    if(r == o.r && c == o.c) {
      return true
    } else {
      return false
    }
  }

  override def toString: String = "(" + r + "," + c + ")"
}
