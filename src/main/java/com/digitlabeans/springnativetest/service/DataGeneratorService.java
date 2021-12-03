package com.digitlabeans.springnativetest.service;

import com.digitlabeans.springnativetest.entity.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

@Service
public class DataGeneratorService {
    private final Random random = new Random();

    public Data generateNewData(Integer id) {
        Integer delay = random.nextInt(1000);
        return new Data(id, delay, LocalTime.now().toString());
    }


    public Flux<Data> generateNewFluxData(Integer range) {
        return Flux
                .range(1, range)
                .delayUntil(id -> Mono.just(1).delayElement(Duration.ofMillis(random.nextInt(1000))))
                .doOnNext(id -> System.out.println("Processed: " + id))
                .map(this::generateNewData);
    }
}
