package test.study.springboot.elasticsearch.high_level_client;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.elasticsearch.springboot.support.SpringBootCfg;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootCfg.class})
public class RegexpQueryTest {

    private String index = "user";

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void term_test() throws Exception {
        //
        RegexpQueryBuilder query = QueryBuilders.regexpQuery("", "");
        //
        SearchSourceBuilder source = new SearchSourceBuilder();
        source.query(query);

        SearchRequest request = new SearchRequest(index);
        request.source(source);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        Arrays.stream(hits.getHits()).forEach(e -> {
            log.info(">>>>>> {}", e.getSourceAsString());
        });
    }

    @Test
    public void terms_test() throws Exception {
        //
        TermsQueryBuilder termsQuery = QueryBuilders.termsQuery("name", "wzj", "zero");
        //
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(termsQuery);

        SearchRequest request = new SearchRequest(index);
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        Arrays.stream(hits.getHits()).forEach(e -> {
            log.info(">>>>>> {}", e.getSourceAsString());
        });
    }
}
