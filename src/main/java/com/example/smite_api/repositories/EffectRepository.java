package com.example.smite_api.repositories;

import com.example.smite_api.models.Effect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffectRepository extends JpaRepository<Effect, Long> {
}
