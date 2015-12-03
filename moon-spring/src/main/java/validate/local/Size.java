package validate.local;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Size {
    int min() default 0;
    int max() default 999999999;
}
