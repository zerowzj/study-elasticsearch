package test.study.springboot.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    public void test() {

    }
}
