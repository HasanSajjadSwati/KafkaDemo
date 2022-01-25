/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kalsym.hasansajjadswati.kafka;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 *
 * @author hasan
 */
public class Producer {

    static final int RECORDS = 10000;
    Properties props = new Properties();

    public void init() throws InterruptedException {
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("kafka.topic.name", "demo");
        KafkaProducer<String, byte[]> producer = new KafkaProducer<String, byte[]>(this.props, new StringSerializer(), new ByteArraySerializer());

        for (int i = 1; i < RECORDS; i++) {
            byte[] payload = (i + " Hello Kafka " + new Date()).getBytes();
            ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>(props.getProperty("kafka.topic.name"), payload);
            producer.send(record);
            Thread.sleep(1000);
        }

        producer.close();

    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.init();
    }
}
