package annotation;

import main.EmployeesProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class EmployeeProcessorAnnotationLogic {
    public void annotationProcessing(){
        Class<EmployeesProcessor> obj = EmployeesProcessor.class;

        if (obj.isAnnotationPresent(EmployeeProcessorTypeAnnotation.class)){
            Annotation annotation = obj.getAnnotation(EmployeeProcessorTypeAnnotation.class);
            EmployeeProcessorTypeAnnotation employeeProcessorTypeAnnotation = (EmployeeProcessorTypeAnnotation) annotation;
            System.out.printf("%nCreatedBy: %s", employeeProcessorTypeAnnotation.createdBy());
            System.out.printf("%nLastModified: %s%n", employeeProcessorTypeAnnotation.lastModified());
        }

        for (Method method : obj.getDeclaredMethods()){
            if (method.isAnnotationPresent(EmployeeProcessorMethodAnnotation.class)){
                Annotation annotation = method.getAnnotation(EmployeeProcessorMethodAnnotation.class);
                EmployeeProcessorMethodAnnotation employeeProcessorMethodAnnotation = (EmployeeProcessorMethodAnnotation) annotation;
                System.out.printf("%n%s%n%n", employeeProcessorMethodAnnotation.taskName());

            }
        }
    }
}
