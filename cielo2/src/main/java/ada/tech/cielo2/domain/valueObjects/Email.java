package ada.tech.cielo2.domain.valueObjects;

import ada.tech.cielo2.exceptions.BadRequestException;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Email {
    private final String value;

    public Email(String value) {
        String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new BadRequestException("Invalid email");
        }
        this.value = value;
    }
}
