package validate.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by lesline on 15/10/23.
 */
public class Test {

    public static void main(String[] args) {


        Order order = new Order();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Order>> violations = validator.validate(order);

        for (ConstraintViolation<Order> violation : violations) {
            System.out.println(violation.getPropertyPath().toString());
            System.out.println(violation.getMessage());
        }
    }
}
