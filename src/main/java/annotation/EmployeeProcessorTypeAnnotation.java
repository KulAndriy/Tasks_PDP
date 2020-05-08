package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EmployeeProcessorTypeAnnotation {

    String createdBy() default "Andriy Kulyk";
    String lastModified() default "5/7/2020";
}
