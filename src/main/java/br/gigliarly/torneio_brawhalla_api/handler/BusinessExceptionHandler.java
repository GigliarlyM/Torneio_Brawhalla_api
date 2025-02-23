package br.gigliarly.torneio_brawhalla_api.handler;

import br.gigliarly.torneio_brawhalla_api.controller.dto.ErrorDto;
import br.gigliarly.torneio_brawhalla_api.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ErrorDto handler(BusinessException ex) {
        return new ErrorDto(
                ex.getMessage()
        );
    }
}
