package com.example.form_builder.repository;

import com.example.form_builder.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
