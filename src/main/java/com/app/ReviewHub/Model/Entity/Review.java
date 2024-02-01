package com.app.ReviewHub.Model.Entity;

import com.app.ReviewHub.Model.Enum.ReactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public final class Review {
    @Id
    @UuidGenerator
    private UUID id;

    @FutureOrPresent(message = "Date can't be in the past")
    @NotNull
    private LocalDate date;

    @NotNull
    private String title;

    @NotNull
    private ReactionType reaction;

    @ManyToOne
    private Person user;
}
