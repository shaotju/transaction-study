package canger.study;


import canger.study.config.TestConfig;
import canger.study.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDeclareTransaction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestConfig.class);
        applicationContext.refresh();
        StudentService studentService = applicationContext.getBean(StudentService.class);
        studentService.updateStudent(1,"James",30);
        applicationContext.close();
    }
}
