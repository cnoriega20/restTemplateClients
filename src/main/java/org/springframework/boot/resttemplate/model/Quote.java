package org.springframework.boot.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Quote implements Serializable {

    private Long id;
    private boolean dialogue;
    private List<String> tags;
    private String url;
    private int favorites_count;
    private int upvotes_count;
    private String downvotes_count;
    private String author;
    private String author_permalink;
    private String body;






}
