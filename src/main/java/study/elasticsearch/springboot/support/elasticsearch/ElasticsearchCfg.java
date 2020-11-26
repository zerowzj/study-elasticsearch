package study.elasticsearch.springboot.support.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Slf4j
@Configuration
//
@EnableElasticsearchRepositories(basePackages = "study.elasticsearch.springboot.repository")
public class ElasticsearchCfg {

}
