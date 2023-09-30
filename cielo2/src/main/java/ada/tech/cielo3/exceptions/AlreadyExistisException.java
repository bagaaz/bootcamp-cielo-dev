package ada.tech.cielo3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistisException extends RuntimeException {
    public AlreadyExistisException(String message) {super(message + " already exists");}
}
