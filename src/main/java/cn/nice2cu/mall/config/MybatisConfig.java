package cn.nice2cu.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 配置类
 * @author sqzhao
 * @date 2021年05月15日 11:27
 */
@Configuration
@MapperScan("cn.nice2cu.mall.mbg.mapper")
public class MybatisConfig {

}
