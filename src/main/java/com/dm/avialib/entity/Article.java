package com.dm.avialib.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "article_id", nullable = false)
    private Long articleId;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "content", nullable = true, length = -1)
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category categoryByCategoryId;
    @Column(name = "publication_date", nullable = true)
    private Date publicationDate;
    @Column(name = "photo", nullable = true, length = -1)
    private String photo;

}
