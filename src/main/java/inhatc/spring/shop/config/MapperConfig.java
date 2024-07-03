package inhatc.spring.shop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    // 빈으로 등록되면 new modelMapper이 올라옴
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
