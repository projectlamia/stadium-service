package com.lamia.stadiumservice.exception;

import com.lamia.stadiumservice.payload.CommonResponse;
import com.lamia.stadiumservice.payload.ErrorMessage;
import com.lamia.stadiumservice.payload.ErrorSchema;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public final ResponseEntity<Object> handleAllExceptions(CommonException ex) {
        CommonResponse exceptionResponse = new CommonResponse();
//        exceptionResponse.setErrorSchema(ex.getErrorSchema());
        exceptionResponse.setOutputSchema(ex.getOutputSchema());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Object> handleDataIntegrity(DataIntegrityViolationException ex) {
        CommonResponse exceptionResponse = new CommonResponse();
//        exceptionResponse.setErrorSchema(ex.getErrorSchema());
        exceptionResponse.setOutputSchema(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public final ResponseEntity invalidDataAccess(InvalidDataAccessApiUsageException ex) {
        CommonResponse exceptionResponse = new CommonResponse();
        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("object references an unsaved transient instance - save the transient instance before flushing");
        errorMessage.setBahasa("object references an unsaved transient instance - save the transient instance before flushing");
        errorSchema.setErrorCode("300001");
        errorSchema.setErrorMessage(errorMessage);
        exceptionResponse.setErrorSchema(errorSchema);
        exceptionResponse.setOutputSchema(Objects.requireNonNull(ex.getCause()));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
