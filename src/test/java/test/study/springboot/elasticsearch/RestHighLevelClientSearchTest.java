package test.study.springboot.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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
public class RestHighLevelClientSearchTest {

    private String index = "user";

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void searchDoc_test() throws Exception {
        //
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name", "wzhj");
        //TermQueryBuilder termQuery = QueryBuilders.termQuery("province", "福建");
        //
        // RangeQueryBuilder timeFilter = QueryBuilders.rangeQuery("log_time").gt(12345).lt(343750);
        //
        QueryBuilder totalFilter = QueryBuilders.boolQuery()
                .filter(matchQuery);
//                .filter(timeFilter)
//                .mustNot(termQuery);


        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(totalFilter).from(from).size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        SearchRequest request = new SearchRequest(index);
        request.source(sourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        Arrays.stream(hits.getHits()).forEach(e -> {
            log.info("{}", e.getSourceAsString());
        });
    }
}
