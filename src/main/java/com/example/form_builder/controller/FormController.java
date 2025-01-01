package com.example.form_builder.controller;

import com.example.form_builder.dto.FormDTO;
import com.example.form_builder.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/")
    public ResponseEntity<List<FormDTO>> getAllForms() {
        List<FormDTO> forms = formService.getAllForms();
        return ResponseEntity.ok(forms);
    }

    @PostMapping("/")
    public ResponseEntity<FormDTO> createForm(@RequestBody FormDTO formDTO) {
        FormDTO createdForm = formService.createForm(formDTO);
        return ResponseEntity.ok(createdForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormDTO> getFormById(@PathVariable Long id) {
        FormDTO form = formService.getFormById(id);
        return ResponseEntity.ok(form);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormDTO> updateForm(@PathVariable Long id, @RequestBody FormDTO formDTO) {
        FormDTO updatedForm = formService.updateForm(id, formDTO);
        return ResponseEntity.ok(updatedForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        formService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/publish")
    public ResponseEntity<FormDTO> publishForm(@PathVariable Long id, @RequestParam boolean publish) {
        FormDTO updatedForm = formService.publishForm(id, publish);
        return ResponseEntity.ok(updatedForm);
    }

    @GetMapping("/published")
    public ResponseEntity<List<FormDTO>> getPublishedForms() {
        List<FormDTO> publishedForms = formService.getPublishedForms();
        return ResponseEntity.ok(publishedForms);
    }
}
