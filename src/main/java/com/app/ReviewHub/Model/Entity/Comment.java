package com.app.ReviewHub.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public final class Comment {
    @Id
    @UuidGenerator
    private UUID id;

    private String text;

    @ManyToOne
    private Person user;

    @ManyToOne
    private Comment parentComment;

    @FutureOrPresent(message = "comment must be in the present")
    private LocalDate date;

    @ManyToOne
    private Review review;

    private Boolean hide = false;

    @ManyToOne
    private Person blockedBy;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childComments;
}
