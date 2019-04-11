package com.main

import com.model.{Area, Coord, Fleet, Simulation}
import java.util.Properties
import org.apache.kafka.clients.producer.ProducerConfig

object Main {

  def main(args: Array[String]): Unit = {
    val area = new Area(20, 20)
    val simulation = new Simulation("simu2", 3, area, 50)
    simulation.launch()
  }

}
