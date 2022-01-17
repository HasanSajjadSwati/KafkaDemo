package com.kalsym.hasansajjadswati.merchantstore.helpcenter.repository;

import com.kalsym.hasansajjadswati.merchantstore.helpcenter.model.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hasan
 */
public interface TopicRepository extends JpaRepository<Topic, String> {
    List<Topic> findByHeading(String heading);
    List<Topic> findByTopicLevel(String topicLevel);
    List<Topic> findByContent(String content);
    List<Topic> findByParentId(String parentId);
}
