package com.fiap.biblioteca_backend.dto;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String isbn;
}
