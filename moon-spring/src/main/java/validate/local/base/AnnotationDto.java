package validate.local.base;





import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDto {
    //中文名
	String name();
	String type() default "string";
	//字段位置
	int index();
	//字段长度
	String length();
}
