package az.edu.orient.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAccountNameValidator implements ConstraintValidator<ValidAccountName, String> {
    private boolean required;
    @Override
    public void initialize(ValidAccountName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value.matches("\\d+")) {
            return false;
        }
        if(!value.matches("[a-zA-Z]+")) {
            return false;
        }
        if(value.length()<4 || value.length()>20) {
            return false;
        }
        return true;
    }
}
