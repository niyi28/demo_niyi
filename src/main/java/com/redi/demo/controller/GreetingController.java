package com.redi.demo.controller;

import com.redi.demo.domain.GreetingStatistic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*@RequestMapping("api")*/
@RestController
public class GreetingController {
    Map <String, Long> greetingStats = new HashMap<>();
    List <String> statList = new ArrayList<>();
     @GetMapping("greeting")
    public List<String> greet(@RequestParam(value = "banana", defaultValue = "Tosin") String name){
         Long count =  GreetingStatistic.processStats(name, greetingStats);
         greetingStats.put(name, count);
         statList = GreetingStatistic.publishGreetingStats(greetingStats);
         return statList;
     }
}
