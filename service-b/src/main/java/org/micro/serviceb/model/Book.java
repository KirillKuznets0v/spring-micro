package org.micro.serviceb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Book {
    private String id;
    private String title;
    private String description;
    private String imageLink;
}
