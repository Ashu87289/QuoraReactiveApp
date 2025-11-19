package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private long id;
    private boolean completed;
    private String title;
}