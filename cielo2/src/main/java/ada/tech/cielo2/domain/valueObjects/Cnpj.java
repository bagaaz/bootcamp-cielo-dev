package ada.tech.cielo2.domain.valueObjects;

import ada.tech.cielo2.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public class Cnpj {
    private final String value;

    public Cnpj(String value) {
        if (!isValid(value)) {
            throw new BadRequestException("Invalid CNPJ");
        }
        this.value = value;
    }

    private boolean isValid(String value) {
        if (value.length() != 14) {
            return false;
        }

        String numbers = value.substring(0, 12);
        String digits = value.substring(12);

        int sum = 0;
        int pos = 5;

        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(numbers.charAt(i)) * pos;
            pos = pos == 2 ? 9 : pos - 1;
        }

        int result = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        if (result != Character.getNumericValue(digits.charAt(0))) {
            return false;
        }

        numbers += result;
        sum = 0;
        pos = 6;

        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(numbers.charAt(i)) * pos;
            pos = pos == 2 ? 9 : pos - 1;
        }

        result = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        if (result != Character.getNumericValue(digits.charAt(1))) {
            return false;
        }

        return true;
    }

}
