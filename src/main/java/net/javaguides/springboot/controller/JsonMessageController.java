package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message has been successfully sent to the topic ");
    }
}
