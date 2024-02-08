package concerttours.constraints;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NotLoremIpsumValidator implements ConstraintValidator<NotLoremIpsum, String> {

        @Override
        public void initialize(final NotLoremIpsum constraintAnnotation) {
            //empty
        }
        @Override
        public boolean isValid(final String value, final ConstraintValidatorContext context) {
            return value != null && !value.isEmpty() && !value.toLowerCase().startsWith("lorem ipsum");
        }

        // another way of implementing isValid:

/*
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context){
            return !value.matches("(?i).*lorem ipsum.*");
        }
*/

}