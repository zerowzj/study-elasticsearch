package test.study.springboot.elasticsearch.high_level_client;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.elasticsearch.springboot.support.SpringBootCfg;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootCfg.class})
public class IndexTest {

    private String index = "user";

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void createIndex_test() throws Exception {
        CreateIndexRequest request = new CreateIndexRequest(index);
        CreateIndexResponse response = client.indices()
                .create(request, RequestOptions.DEFAULT);
        log.info("{}", response.isAcknowledged());
    }

    @Test
    public void existsIndex_test() throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        boolean response = client.indices()
                .exists(request, RequestOptions.DEFAULT);
        log.info("{}", response);
    }

    @Test
    public void deleteIndex_test() throws Exception {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse response = client.indices()
                .delete(request, RequestOptions.DEFAULT);
        log.info("{}", response.isAcknowledged());
    }
}
