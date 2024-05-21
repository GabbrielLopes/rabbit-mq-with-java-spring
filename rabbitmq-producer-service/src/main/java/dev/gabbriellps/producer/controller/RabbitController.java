package dev.gabbriellps.producer.controller;

import dev.gabbriellps.producer.service.interfaces.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class RabbitController {

    private final StringProducerService service;


    @PostMapping
    public ResponseEntity<String> produceString(@RequestParam("message") String message){
        service.produceString(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sending message..");
    }

}
