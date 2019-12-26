package rs.ac.bg.fon.cinema.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "rs.ac.bg.fon.cinema.mapper" })
public class BaseConfig {

}
