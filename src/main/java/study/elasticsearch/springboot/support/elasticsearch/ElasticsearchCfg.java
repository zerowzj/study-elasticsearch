package study.elasticsearch.springboot.support.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import study.elasticsearch.springboot.client.EsClient;

@Slf4j
@Configuration
//
@EnableElasticsearchRepositories(basePackages = "study.elasticsearch.springboot.repository")
public class ElasticsearchCfg {

    @Bean
    public EsClient esClient(RestHighLevelClient client) {
        return new EsClient(client);
    }
}
