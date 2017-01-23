package net.ukrtel.ddns.ff.controllers;

import net.ukrtel.ddns.ff.exceptions.NoAppliantForJobRequestedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NoAppliantForJobRequestedException.class)
    public String noAppliantFound() {
        return "error/noAppliant";
    }
}
