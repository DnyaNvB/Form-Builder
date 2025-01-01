package com.example.form_builder.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class FormDTO {

    private Long id;

    @NotNull(message = "Form name cannot be null.")
    @Size(min = 1, max = 100, message = "Form name must be between 1 and 100 characters.")
    private String name;

    private boolean isPublished;

    @NotNull(message = "Fields cannot be null. Provide at least an empty list if there are no fields.")
    private List<FieldDTO> fields = new ArrayList<>();

    @NotNull(message = "Submit method cannot be null.")
    @Size(min = 1, max = 10, message = "Submit method must be between 1 and 10 characters.")
    private String submitMethod;

    @NotNull(message = "Submit URL cannot be null.")
    @Size(min = 1, max = 200, message = "Submit URL must be between 1 and 200 characters.")
    private String submitUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        if (fields == null) {
            this.fields = new ArrayList<>();
        } else {
            this.fields = fields;
        }
    }

    public String getSubmitMethod() {
        return submitMethod;
    }

    public void setSubmitMethod(String submitMethod) {
        this.submitMethod = submitMethod;
    }

    public String getSubmitUrl() {
        return submitUrl;
    }

    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl;
    }
}
