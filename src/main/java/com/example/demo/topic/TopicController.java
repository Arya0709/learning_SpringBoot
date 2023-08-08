package com.example.demo.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("Spring","Spring Framework","Spring Framework Description")
        );
    }
}
