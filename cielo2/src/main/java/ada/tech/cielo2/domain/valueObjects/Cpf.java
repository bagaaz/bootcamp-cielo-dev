package ada.tech.cielo2.domain.valueObjects;

import ada.tech.cielo2.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public class Cpf {
    private final String value;

    public Cpf(String value) {
        if (!isValid(value)) {
            throw new BadRequestException("Invalid CPF");
        }

        this.value = value;
    }

    private boolean isValid(String value) {
        if (value.length() != 11) {
            return false;
        }

        for (int i = 0; i <= 9; i++) {
            String sequence = String.valueOf(i).repeat(9);
            if (value.contains(sequence)) {
                return false;
            }
        }

        int sum = 0;
        int remainder;

        for (int i = 1; i <= 9; i++) {
            sum += Integer.parseInt(value.substring(i - 1, i)) * (11 - i);
        }

        remainder = (sum * 10) % 11;

        if (remainder == 10 || remainder == 11) {
            remainder = 0;
        }

        if (remainder != Integer.parseInt(value.substring(9, 10))) {
            return false;
        }

        sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += Integer.parseInt(value.substring(i - 1, i)) * (12 - i);
        }

        remainder = (sum * 10) % 11;

        if (remainder == 10 || remainder == 11) {
            remainder = 0;
        }

        if (remainder != Integer.parseInt(value.substring(10, 11))) {
            return false;
        }

        return true;
    }
}
