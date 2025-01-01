package com.example.form_builder.service;

import com.example.form_builder.dto.FormDTO;
import com.example.form_builder.exception.ResourceNotFoundException;
import com.example.form_builder.model.Form;
import com.example.form_builder.repository.FormRepository;
import com.example.form_builder.util.DTOConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormService {

    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<FormDTO> getAllForms() {
        return formRepository.findAll()
                .stream()
                .map(DTOConverter::convertToFormDTO)
                .collect(Collectors.toList());
    }

    public FormDTO createForm(FormDTO formDTO) {
        Form form = DTOConverter.convertToFormEntity(formDTO);
        Form savedForm = formRepository.save(form);
        return DTOConverter.convertToFormDTO(savedForm);
    }

    public FormDTO getFormById(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));
        return DTOConverter.convertToFormDTO(form);
    }

    public FormDTO updateForm(Long formId, FormDTO formDTO) {
        Form existingForm = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));

        existingForm.setName(formDTO.getName());
        existingForm.setPublished(formDTO.isPublished());
        existingForm.setSubmitMethod(formDTO.getSubmitMethod());
        existingForm.setSubmitUrl(formDTO.getSubmitUrl());

        Form updatedForm = formRepository.save(existingForm);
        return DTOConverter.convertToFormDTO(updatedForm);
    }

    public void deleteForm(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));
        formRepository.delete(form);
    }

    public FormDTO publishForm(Long formId, boolean publishStatus) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with ID: " + formId));

        form.setPublished(publishStatus);
        Form updatedForm = formRepository.save(form);

        return DTOConverter.convertToFormDTO(updatedForm);
    }

    public List<FormDTO> getPublishedForms() {
        return formRepository.findAll()
                .stream()
                .filter(Form::isPublished)
                .map(DTOConverter::convertToFormDTO)
                .collect(Collectors.toList());
    }
}
