package com.model

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord, RecordMetadata}
import org.apache.kafka.common.serialization.StringSerializer

class Fleet(val numberOfDrone:Int, val area: Area) {

  val props = new Properties()
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])

  var visitedCells: List[Coord] = List()
  val drones: Array[Drone] = initFleet
  val producer = new KafkaProducer[String, String](props)


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
    returnDrones
  }

  def doTurn(): Unit = {
    drones.foreach(drone => {
      val message = new ProducerRecord[String, String]("main", null, drone.action)
      producer.send(message, (recordMetadata: RecordMetadata, exception: Exception) => {
        if(exception != null) {
          exception.printStackTrace()
        } else {
          println(s"Metadata about the sent record: $recordMetadata")
        }
      })
    })
  }

  override def toString: String = {
    var str: String = ""
    for(i <- 0 until numberOfDrone) {
      str = str + drones(i) + "\n"
    }
    str = str + "visitedCells: " + visitedCells
    str
  }

}
