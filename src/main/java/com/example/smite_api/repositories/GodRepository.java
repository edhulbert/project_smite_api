package com.example.smite_api.repositories;

import com.example.smite_api.models.God;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GodRepository extends JpaRepository<God, Long> {
}
