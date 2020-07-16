package org.springframework.boot.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuoteOffDayResponse implements Serializable {
    private String qotd_date;
    private Quote quote;
}
