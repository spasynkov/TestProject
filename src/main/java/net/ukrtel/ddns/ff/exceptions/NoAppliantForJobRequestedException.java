package net.ukrtel.ddns.ff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No appliant found")
public class NoAppliantForJobRequestedException extends RuntimeException{

    public NoAppliantForJobRequestedException(String message) {
        super(message);
    }
}
