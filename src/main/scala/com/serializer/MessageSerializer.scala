package com.serializer

import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.model.Message
import org.apache.kafka.common.serialization.Serializer

class MessageSerializer extends Serializer[Message]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def serialize(topic: String, data: Message): Array[Byte] = {
    try {
      if(data == null) null else {
        val objectMapper = new ObjectMapper()
        objectMapper.writeValueAsString(data).getBytes
      }
    } catch {
      case e: Exception => throw new Exception(e.getMessage)
    }
  }

  override def close(): Unit = {

  }
}
