package com.pabloalan.task_manager_api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class ApiError {
    private Instant timestamp = Instant.now();
    private int status;
    private String error;
    private String message;
    private String path;
    private List<FieldError> fieldErrors;

    public static class FieldError {
        public String field;
        public String message;

        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
