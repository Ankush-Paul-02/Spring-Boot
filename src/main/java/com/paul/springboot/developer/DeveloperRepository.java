package com.paul.springboot.developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//? DATA ACCESS LAYER
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Query("select d from Developer d where d.email = ?1")
    Optional<Developer> findDeveloperByEmail(String email);
}
