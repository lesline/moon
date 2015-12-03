package validate.validator3.customertag;

import org.hibernate.validator.internal.engine.groups.Group;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        if (object == null)
            return true;

        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = object.equals(object.toUpperCase());
        } else {
            isValid = object.equals(object.toLowerCase());
        }

        if (!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("{com.mycompany.constraints.CheckCase.message}").addConstraintViolation();
        }
        return isValid;
    }

    public boolean isValid(Group group, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if (!isValid) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{my.custom.template}")
                    .addNode("myProperty").addConstraintViolation();
        }
        return isValid;
    }
}