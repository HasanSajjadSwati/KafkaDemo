package com.kalsym.hasansajjadswati.merchantstore.helpcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hasan
 */
@Entity
@Table(name = "topic")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    
    @Column(name = "heading")
    private String heading;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "topicLevel")
    private String topicLevel;
    
    @Column(name = "parentId")
    private String parentId;
}
