package com.hackathon.kubernetescostservice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CloudName {
    AWS("aws"),
    AZURE("azure"),
    GCP("gcp"),
    NX("nutanix");

    private String value;

    CloudName(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}