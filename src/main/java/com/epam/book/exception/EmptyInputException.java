package com.epam.book.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmptyInputException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
}
