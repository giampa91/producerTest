package com.example.provaProducer;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class ProducerController {

	@Value("${avro.topic.name}")
    private String avroTopicName;

    @Autowired
    private ProducerService producerService;

    @PostMapping("/createStudent")
    public String getDataForKafkaTopic(@RequestBody Student student){
        producerService.sendAvroData(avroTopicName, student);
        return "Data Posted";
    }

}
