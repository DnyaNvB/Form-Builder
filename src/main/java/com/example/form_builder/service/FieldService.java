package com.example.form_builder.service;

import com.example.form_builder.dto.FieldDTO;
import com.example.form_builder.dto.FormDTO;
import com.example.form_builder.exception.ResourceNotFoundException;
import com.example.form_builder.model.Field;
import com.example.form_builder.model.Form;
import com.example.form_builder.repository.FormRepository;
import com.example.form_builder.util.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldService {

    private final FormRepository formRepository;

    public FieldService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<FieldDTO> getFieldsByFormId(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));

        return form.getFields()
                .stream()
                .map(DTOConverter::convertToFieldDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public FormDTO updateFields(Long formId, List<FieldDTO> fieldDTOs) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));

        form.getFields().clear();
        List<Field> updatedFields = fieldDTOs.stream()
                .map(DTOConverter::convertToFieldEntity)
                .collect(Collectors.toList());
        form.getFields().addAll(updatedFields);
        Form updatedForm = formRepository.save(form);
        return DTOConverter.convertToFormDTO(updatedForm);
    }
}
