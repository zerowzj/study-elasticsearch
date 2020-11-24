package test.study.springboot.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.elasticsearch.springboot.support.SpringBootCfg;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootCfg.class})
public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void test() throws Exception {
        CreateIndexResponse  response = client.indices()
                .create(new CreateIndexRequest("abc"), RequestOptions.DEFAULT);
    }
}
