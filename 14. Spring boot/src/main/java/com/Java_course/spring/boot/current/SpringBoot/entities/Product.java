package com.Java_course.spring.boot.current.SpringBoot.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private int price;

}
