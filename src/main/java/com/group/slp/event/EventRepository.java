package com.group.slp.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT obj FROM Event obj WHERE obj.date BETWEEN :min AND :max")
    Page<Event> findAllBetweenDate(LocalDate min, LocalDate max, Pageable pageable);

}
