package com.example.form_builder.controller;

import com.example.form_builder.dto.FieldDTO;
import com.example.form_builder.dto.FormDTO;
import com.example.form_builder.service.FieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms/{formId}/fields")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/")
    public ResponseEntity<List<FieldDTO>> getFieldsByFormId(@PathVariable Long formId) {
        List<FieldDTO> fields = fieldService.getFieldsByFormId(formId);
        return ResponseEntity.ok(fields);
    }

    @PutMapping("/")
    public ResponseEntity<FormDTO> updateFields(@PathVariable Long formId, @RequestBody List<FieldDTO> fieldDTOs) {
        FormDTO updatedForm = fieldService.updateFields(formId, fieldDTOs);
        return ResponseEntity.ok(updatedForm);
    }
}
