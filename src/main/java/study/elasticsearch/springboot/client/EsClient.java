package study.elasticsearch.springboot.client;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

public class EsClient {

    private RestHighLevelClient client;

    public EsClient(RestHighLevelClient client) {
        this.client = client;
    }

    /**
     * （★）索引
     */
    //创建索引
    public void createIndex(String index, RequestOptions options) {
        try {
            CreateIndexRequest request = new CreateIndexRequest(index);
            CreateIndexResponse response = client.indices()
                    .create(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }

    /**
     * （★）文档
     */
    //插入文档
    public void insertDoc(String index, RequestOptions options) {
        try {
            IndexRequest request = new IndexRequest(index);
            client.index(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }

    //更新文档
    public void updateDoc(String index, RequestOptions options) {
        try {
//            UpdateRequest request = new UpdateRequest(index);
//            client.update(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }

    //删除文档
    public void deleteDoc(String index, RequestOptions options) {
        try {
            DeleteRequest request = new DeleteRequest(index);
            client.delete(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        }
    }
}
