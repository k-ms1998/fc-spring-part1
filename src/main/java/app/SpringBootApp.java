package app;

import app.properties.MyProperties;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableCaching
public class SpringBootApp {

    private final MyProperties myProperties;
    private final StudentService studentService;
    private final String userId;
    private final String password;

    public SpringBootApp(MyProperties myProperties, StudentService studentService,
                         @Value("${userId}")String userId,
                         @Value("${password}") String password) {
        this.myProperties = myProperties;
        this.studentService = studentService;
        this.userId = userId;
        this.password = password;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApp.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("myProperties.getHeight() = " + myProperties.getHeight());

        /**
         * Spring Cache Practice
         * 스프링에서 캐시는 모든 빈이 등록 & 로딩이 된 이후에 적용 됨
         * But, @PostConstruct는 클래스들의 의존성 주입이 된 이후에 실행 -> 의존성 주입이 모두 끝나도 모든 빈의 등록 & 로딩이 끝난 시점이 아닐수도 있음
         * => 그러므로, @EventListener(ApplicationReadyEvent.class) 로 실행 -> 모든 빈의 등록 & 로딩이 끝나서 어플리케이션을 실행할 상태가 됐을때를 확인(ApplicationReadyEvent) 후 실행
         *
         */
        studentService.printStudent("jack");
        studentService.printStudent("jack");
        studentService.printStudent("jack");
        /**
         * w/o Caching:
         * [repository] Bottleneck
         * student = jack:20
         * [repository] Bottleneck
         * student = jack:20
         * [repository] Bottleneck
         * student = jack:20
         *
         * w/ Caching:
         * [repository] Bottleneck
         * student = jack:20
         * student = jack:20
         * student = jack:20
         */

        studentService.printStudent("fred");
        studentService.printStudent("fred");

        studentService.printStudent("andreas");
        studentService.printStudent("andreas");

        System.out.println("============================");
        /**
         * Vault에서 secret/fast-campus-spring-part2 에 저장되어 있는 userId랑 password 값 출력 -> Vault에 저장된 값이 application.properties 에 저장된 값들을 덮어 씀
         */
        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
    }
}
