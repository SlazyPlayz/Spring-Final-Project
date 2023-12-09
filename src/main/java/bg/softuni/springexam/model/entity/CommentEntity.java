package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RecipeEntity recipe;
}
