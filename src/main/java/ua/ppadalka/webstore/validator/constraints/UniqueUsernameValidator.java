package ua.ppadalka.webstore.validator.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

   public void initialize(UniqueUsername constraint) {}

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}
