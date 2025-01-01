package com.example.form_builder.config;

import com.example.form_builder.dto.FieldDTO;
import com.example.form_builder.dto.FormDTO;
import com.example.form_builder.service.FormService;
import com.example.form_builder.model.FieldType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(FormService formService) {
        return args -> {
            if (formService.getAllForms().isEmpty()) { // Prevent duplicate data
                // Create fields
                FieldDTO usernameField = new FieldDTO();
                usernameField.setName("username");
                usernameField.setLabel("Username");
                usernameField.setType(FieldType.TEXT);
                usernameField.setDefaultValue("");

                FieldDTO ageField = new FieldDTO();
                ageField.setName("age");
                ageField.setLabel("Age");
                ageField.setType(FieldType.NUMBER);
                ageField.setDefaultValue("18");

                FieldDTO subscribeField = new FieldDTO();
                subscribeField.setName("subscribe");
                subscribeField.setLabel("Subscribe to newsletter");
                subscribeField.setType(FieldType.BOOLEAN);
                subscribeField.setDefaultValue("false");

                FieldDTO birthDateField = new FieldDTO();
                birthDateField.setName("birthdate");
                birthDateField.setLabel("Birth Date");
                birthDateField.setType(FieldType.DATE);
                birthDateField.setDefaultValue("");

                FormDTO form = new FormDTO();
                form.setName("Sample Form");
                form.setPublished(false);
                form.setSubmitMethod("POST");
                form.setSubmitUrl("/submit");
                form.setFields(List.of(usernameField, ageField, subscribeField, birthDateField));

                formService.createForm(form);
            }
        };
    }
}
