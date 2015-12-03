package validate.local;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotEmpty {
    String name();
    int length() default 22;
}
