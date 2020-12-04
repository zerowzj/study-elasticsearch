package test.study.springboot.elasticsearch;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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

import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootCfg.class})
public class RestHighLevelClientTest {

    private String index = "abc";

    @Autowired
    private RestHighLevelClient client;

    //（★）索引
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

    //（★）文档
    @Test
    public void insertDoc_test() throws Exception {
        String id = "2";
        //
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        Map<String, Object> data = Maps.newHashMap();
        data.put("name", "wagnzhj");
        data.put("age", "123");
        request.source(data);
        //
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        log.info("{}", response.getSeqNo());
    }

    @Test
    public void getDoc_test() throws Exception {
        String id = "1";
        GetRequest getRequest = new GetRequest(index, id);
        //
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        log.info("{}", sourceAsString);
    }

    @Test
    public void updateDoc_test() throws Exception {
        String id = "1";
        //
        UpdateRequest request = new UpdateRequest(index, id);
        Map<String, Object> data = Maps.newHashMap();
        data.put("name", "wangzhj");
        data.put("age", "36");
        data.put("sex", "男");
        request.doc(data);
        //
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        log.info("{}", response.status());
    }

    @Test
    public void deleteDoc_test() throws Exception {
        String id = "";
        DeleteRequest request = new DeleteRequest(index, id);
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        log.info("{}", response.status());
    }

    @Test
    public void searchDoc_test() throws Exception {
        String id = "";
        SearchRequest request = new SearchRequest(index, id);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        log.info("{}", response.status());
    }
}
