package com.app.ReviewHub.Model.Dto.Review;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Person;
import com.app.ReviewHub.Model.Enum.ReactionType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDtoReq {
    private UUID id;

    @FutureOrPresent(message = "Date must be now or on future")
    private LocalDate date;

    @NotBlank(message = "Title must be not null")
    private String title;

    @NotBlank(message = "Reaction must be not null")
    private ReactionType reaction;

    @NotNull(message = "Reaction must be not null")
    private UUID user;

}
