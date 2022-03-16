package com.redi.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class GreetingStatistic {


    public static Long processStats(String name, Map <String, Long> greetingStats){
        long count = new AtomicLong().incrementAndGet();
        if (greetingStats.containsKey(name)) {
            count = count + greetingStats.get(name);
        }
        return count;
    }

    public static List<String> publishGreetingStats(Map <String, Long> greetingStats){
         List <String> statList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : greetingStats.entrySet()){
            statList.add("name: " + entry.getKey() + ", count:" + entry.getValue());
        }
        return statList;
    }
}
