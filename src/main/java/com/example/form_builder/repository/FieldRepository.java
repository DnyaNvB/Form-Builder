package com.example.form_builder.repository;

import com.example.form_builder.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
