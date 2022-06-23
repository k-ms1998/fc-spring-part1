package app.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        
        //DB 접속 정보
        builder.username("msk");
        builder.password("pass");
        builder.url("jdbc:h2:mem:test");
        builder.driverClassName("org.h2.Driver");
        // 해당 정보들을 application.properties를 통해 전달해주는 것이 추천됨
        
        return builder.build();
    }

}
