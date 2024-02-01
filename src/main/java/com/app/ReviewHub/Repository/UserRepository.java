package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Person, UUID> {
}
