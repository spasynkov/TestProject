package net.ukrtel.ddns.ff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such job found")
public class JobsIdOutOfBoundsException extends IndexOutOfBoundsException {

    public JobsIdOutOfBoundsException(String s) {
        super(s);
    }
}
