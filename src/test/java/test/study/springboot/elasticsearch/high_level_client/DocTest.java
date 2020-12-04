package test.study.springboot.elasticsearch.high_level_client;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.rest.RestStatus;
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
public class DocTest {

    private String index = "user";

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void insertDoc_test() throws Exception {
        String id = "3";
        //
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        Map<String, Object> data = Maps.newHashMap();
        data.put("name", "wzhj");
        data.put("age", 210);
        request.source(data);
        //
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        RestStatus status = response.status();
        log.info("{}", status);
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
        data.put("age", 36);
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
}
