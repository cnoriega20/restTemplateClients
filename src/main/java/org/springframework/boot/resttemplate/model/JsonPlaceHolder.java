package org.springframework.boot.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JsonPlaceHolder {

    private Long id;
    private String title;
    private String body;
    private Long userId;
}
