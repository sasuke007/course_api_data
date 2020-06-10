package io.javabrains.course_api_data.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
    public List<Topics> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topics getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST , value="/topics")
    public void addTopic(@RequestBody Topics topic){
        //System.out.println(topic);
        topicService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
    public Topics updateTopic(@PathVariable("id") String id,@RequestBody Topics topic){
        return topicService.updateTopic(id,topic);
    }

    @RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
    public void deleteTopic(@PathVariable("id") String id){
         topicService.deleteTopic(id);
    }

}
