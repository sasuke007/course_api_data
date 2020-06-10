package io.javabrains.course_api_data.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topics> topics= new ArrayList(Arrays.asList(
            new Topics("01", "spring" , "something"),
            new Topics("02","mvc","something"),
            new Topics("03","java","something")
    ));

    public List<Topics> getAllTopics() {
        List<Topics> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topics getTopic(String id){
//        for(Topics topic:this.topics){
//            if(topic.getId().equals(id)){
//                return topic;
//            }
//        }
//        return this.topics.get(0);
        Optional<Topics> topic=topicRepository.findById(id);
        return topic.orElse(null);
    }

    public void addTopic(Topics topic) {
        topicRepository.save(topic);
    }

    public Topics updateTopic(String id,Topics subject){
//        for(int i=0;i<topics.size();++i){
//            Topics topic=topics.get(i);
//            if(topic.getId().equals(id)){
//                topics.set(i,subject);
//            }
//        }
//        return subject;
        topicRepository.save(subject);
        return subject;
    }

    public void deleteTopic(String id){
//        Topics deletedTopic=null;
//        for(int i=0;i<topics.size();++i){
//            Topics topic=topics.get(i);
//            if(topic.getId().equals(id)){
//                deletedTopic=topic;
//                topics.remove(i);
//            }
//        }
//        return deletedTopic;
        topicRepository.deleteById(id);
    }
}
