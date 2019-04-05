package com.serializer

import java.util

import com.model.Message
import org.apache.kafka.common.serialization.Serializer

class MessageSerializer extends Serializer[Message]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def serialize(topic: String, data: Message): Array[Byte] = {

  }

  override def close(): Unit = {

  }
}
