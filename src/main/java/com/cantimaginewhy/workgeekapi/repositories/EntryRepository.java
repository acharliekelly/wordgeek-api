package com.cantimaginewhy.workgeekapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantimaginewhy.workgeekapi.models.WordEntry;

public interface EntryRepository extends JpaRepository<WordEntry, Long> {
  
}
