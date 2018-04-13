package com.prasilius.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prasilius.jpa.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
