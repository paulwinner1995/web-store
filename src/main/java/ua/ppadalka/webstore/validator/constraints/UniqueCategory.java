package ua.ppadalka.webstore.validator.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueCategoryValidator.class)
public @interface UniqueCategory {

    String message() default "{ua.ppadalka.webstore.validator.constraints.UniqueValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
