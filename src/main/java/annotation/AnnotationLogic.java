package annotation;

import main.EmployeesProcessor;

import java.lang.reflect.Method;

public class AnnotationLogic {
    public void annotationProcessing(){
        Class<EmployeesProcessor> obj = EmployeesProcessor.class;

        if (obj.isAnnotationPresent(TypeAnnotation.class)){
            TypeAnnotation typeAnnotation = obj.getAnnotation(TypeAnnotation.class);
            System.out.printf("%nCreatedBy: %s", typeAnnotation.createdBy());
            System.out.printf("%nLastModified: %s%n", typeAnnotation.lastModified());
        }

        for (Method method : obj.getDeclaredMethods()){
            if (method.isAnnotationPresent(MethodAnnotation.class)){
                MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
                System.out.printf("%n%s%n%n", methodAnnotation.taskName());

            

            }
        }
    }
}
