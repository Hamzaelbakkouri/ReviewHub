package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByFullName(String fullName);

    Page<Person> searchAllByFullNameLike(String fullName , Pageable pageable);
}
