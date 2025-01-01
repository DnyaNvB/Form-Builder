package com.example.form_builder.dto;

import com.example.form_builder.model.FieldType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class FieldDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "Field name must be between 1 and 50 characters.")
    private String name;

    @NotNull
    @Size(min = 1, max = 100, message = "Field label must be between 1 and 100 characters.")
    private String label;

    @NotNull(message = "Field type is required.")
    private FieldType type;

    private String defaultValue;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
