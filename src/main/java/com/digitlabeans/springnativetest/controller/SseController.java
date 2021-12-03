package com.digitlabeans.springnativetest.controller;

import com.digitlabeans.springnativetest.entity.Data;
import com.digitlabeans.springnativetest.service.DataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class SseController {

    @Autowired
    DataGeneratorService dataGeneratorService;



    @GetMapping(path = "/sse/{range}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Data> stringFlux(@PathVariable Integer range) {
//        return Flux.interval(Duration.ofSeconds(1))
//                .map(sequence -> "Flux - " + LocalTime.now().toString());

        return dataGeneratorService.generateNewFluxData(range);
    }
}
