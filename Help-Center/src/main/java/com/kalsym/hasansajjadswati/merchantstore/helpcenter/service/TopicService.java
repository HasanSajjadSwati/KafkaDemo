package com.kalsym.hasansajjadswati.merchantstore.helpcenter.service;

import com.kalsym.hasansajjadswati.merchantstore.helpcenter.model.Topic;
import com.kalsym.hasansajjadswati.merchantstore.helpcenter.repository.TopicRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author hasan
 */
@Service
public class TopicService {
    
    @Autowired TopicRepository topicRepository;
    
     public ResponseEntity<List<Topic>> getAllTopics(String heading) throws Exception{
        
    	try {
    		List<Topic> topics = new ArrayList<>();
    		
    		if(heading == null)
    			topicRepository.findAll().forEach(topics::add);
    		
    		else
    			topicRepository.findByHeading(heading).forEach(topics::add);
    		
    		if(topics.isEmpty())
    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		
    		return new ResponseEntity<>(topics,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
     
     public ResponseEntity<List<Topic>> getAllTopLevelTopics() throws Exception {
        
    	try {
    		List<Topic> topics = new ArrayList<>();
    		
                topicRepository.findByTopicLevel("0").forEach(topics::add);
    		
    		if(topics.isEmpty())
    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		
    		return new ResponseEntity<>(topics,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
     
     public ResponseEntity<Topic> getTopicById(String id){
    	Optional<Topic> topic = topicRepository.findById(id);
    	
    	if(topic.isPresent())
    		return new ResponseEntity<>(topic.get(),HttpStatus.OK);
    	
    	else
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     
     public ResponseEntity<String> getTopicContent(String id){
    	Optional<Topic> topic = topicRepository.findById(id);
    	
    	if(topic.isEmpty())
                return new ResponseEntity<>("topicId does not exists",HttpStatus.NOT_FOUND);
    	
    	else
    		return new ResponseEntity<>(topic.get().getContent(),HttpStatus.OK);
    }
     
     public ResponseEntity<List<Topic>> getSubTopics(String parentId) throws Exception{
         try {
    		List<Topic> subTopics = topicRepository.findByParentId(parentId);
    		
    		if(subTopics.isEmpty())
    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		
                else
                    return new ResponseEntity<>(subTopics,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
     }
     
     public ResponseEntity<String> createTopic(@RequestBody Topic topic) throws Exception{
    	List<Topic> topics = topicRepository.findAll();
        
        for(Topic findTopic : topics){
            if(findTopic.getHeading().equals(topic.getHeading())){
                return new ResponseEntity<>("Topic already Exists!",HttpStatus.CONFLICT);
            }
        }
    	try {
                Topic newTopic = topicRepository.save(topic);
    		
    		return new ResponseEntity<>("Created!\n" + topic.toString(),HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
     
     public ResponseEntity<Topic> updateTopic(String id, Topic topic){
    	Optional<Topic> topicDetails = topicRepository.findById(id);
    	
    	if(topicDetails.isPresent()) {
    		Topic updateTopic = topicDetails.get();
    		updateTopic.setHeading(topic.getHeading());
    		updateTopic.setDescription(topic.getDescription());
                updateTopic.setContent(topic.getContent());
                updateTopic.setTopicLevel(topic.getTopicLevel());
                updateTopic.setParentId(topic.getParentId());
                
    		return new ResponseEntity<>(topicRepository.save(updateTopic),HttpStatus.OK);
    		
    	}
    	else
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     
     public ResponseEntity<HttpStatus> deleteTopic(String id) throws Exception{
      try {
        topicRepository.deleteById(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } 
      catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
     
     
}
