package cn.nice2cu.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 配置类
 * @author sqzhao
 * @date 2021年05月15日 11:27
 */
@Configuration
@MapperScan("cn.nice2cu.admin.mapper")
public class MybatisConfig {

}
