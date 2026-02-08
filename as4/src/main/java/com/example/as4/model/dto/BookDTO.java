package com.example.as4.model.dto;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private Integer publishedYear;
}
