/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kalsym.hasansajjadswati.kafka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author hasan
 */
public class Consumer {

    static final String TOPIC = "demo";
    static final String GROUP = "demoGroup";
    static final int RECORDS = 10000;
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUP);
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try ( KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);) {
            consumer.subscribe(Arrays.asList(TOPIC));

            for (int i = 0; i < RECORDS; i++) {
                ConsumerRecords<String, String> records = consumer.poll(1000L);
                for (ConsumerRecord<String,String> record : records){
                    System.out.println("Received Message: " + record.value());
                }
            }
        }
        System.out.println("End");

    }
}
