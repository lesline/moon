package validate.local.base;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Df02FileDto {

    @AnnotationDto(name = "记录序号", index = 0, length = "6")
    public String serNo;

    @AnnotationDto(name = "银联网络用户编号", index = 1, length = "20")
    public String userCode;

    public static void main(String[] args) {
        Df02FileDto df02FileDto = new Df02FileDto();

        Field[] fields = df02FileDto.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println("----------------" + field.getName());
            Annotation[] annotations = field.getDeclaredAnnotations();

            boolean flag = field.isAnnotationPresent(AnnotationDto.class);

            if (flag) {
                AnnotationDto annotationDto = field.getAnnotation(AnnotationDto.class);
                System.out.println(annotationDto.index());
                System.out.println(annotationDto.toString());
            }
        }

    }


}
