
package com.kalsym.hasansajjadswati.merchantstore.helpcenter.controller;

import com.kalsym.hasansajjadswati.merchantstore.helpcenter.model.Topic;
import com.kalsym.hasansajjadswati.merchantstore.helpcenter.service.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hasan
 */
@RestController
@RequestMapping("/help-center/topics")
public class TopicController {
    
    @Autowired
    private TopicService topicService;
    
    @GetMapping("")
    public ResponseEntity<List<Topic>> getAllTopics(@RequestParam(required = false) String heading)throws Exception{
        return topicService.getAllTopics(heading);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable(name = "id") String id){
        return topicService.getTopicById(id);
    }
    
    @GetMapping("/top-level-topics")
    public ResponseEntity<List<Topic>> getAllTopLevelTopics() throws Exception{
        return topicService.getAllTopLevelTopics();
    }
    
    @GetMapping("/content/{id}")
    public ResponseEntity<String> getTopicContent(@PathVariable("id") String id){
        return topicService.getTopicContent(id);
    }
    
    @GetMapping("/subtopics/{parentId}")
    public ResponseEntity<List<Topic>> getSubtopic(@PathVariable("parentId") String parentId) throws Exception{
        return topicService.getSubTopics(parentId);
    }
    
    @PostMapping("")
    public ResponseEntity<String> createTopic(@RequestBody Topic topic) throws Exception{
        return topicService.createTopic(topic);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable("id") String id,@RequestBody Topic topic){
    	return topicService.updateTopic(id, topic);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") String id) throws Exception{
        return topicService.deleteTopic(id);
    }
}
