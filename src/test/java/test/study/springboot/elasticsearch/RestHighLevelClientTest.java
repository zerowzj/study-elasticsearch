package test.study.springboot.elasticsearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    public void test() {
        RestClient lowLevelClient = highLevelClient.getLowLevelClient();
        IndexRequest request = new IndexRequest("spring-data")
                .source(singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(IMMEDIATE);
        IndexResponse response = highLevelClient.index(request);
    }
}
