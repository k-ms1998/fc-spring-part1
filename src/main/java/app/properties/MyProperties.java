package app.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("my") // application properties 에서 my. prefix 를 가진 값들을 탐색
@Getter
@ConstructorBinding
@RequiredArgsConstructor
public class MyProperties {

    private final Integer height; // my.height 의 값을 가져옴

}
