package study.elasticsearch.springboot.client;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;

public class EsClient {

    private RestHighLevelClient client;

    public EsClient(RestHighLevelClient client) {
        this.client = client;
    }

    public void createIndex(String index) {
        CreateIndexRequest request = new CreateIndexRequest(index);
        try {
            client.indices().create(request, null);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }

    public void insertDoc(String index) {
        IndexRequest request = new IndexRequest(index);
        try {
            client.index(request, null);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }
}
