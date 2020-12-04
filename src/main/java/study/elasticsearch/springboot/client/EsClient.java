package study.elasticsearch.springboot.client;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
import org.elasticsearch.rest.RestStatus;

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
            response.isAcknowledged();
            response.isShardsAcknowledged();
        } catch (Exception ex) {
            throw new RuntimeException("create index error!", ex);
        }
    }

    //删除索引
    public void deleteIndex(String index, RequestOptions options) {
        try {
            DeleteIndexRequest request = new DeleteIndexRequest(index);
            AcknowledgedResponse response = client.indices()
                    .delete(request, options);
            response.isAcknowledged();
        } catch (Exception ex) {
            throw new RuntimeException("create index error!", ex);
        }
    }

    /**
     * （★）文档
     */
    //插入文档
    public void insertDoc(String index, RequestOptions options) {
        try {
            IndexRequest request = new IndexRequest(index);
            IndexResponse response = client.index(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("insert doc error!", ex);
        }
    }

    //删除文档
    public void deleteDoc(String index, String id, RequestOptions options) {
        try {
            DeleteRequest request = new DeleteRequest(index, id);
            DeleteResponse response = client.delete(request, options);
            RestStatus status = response.status();
        } catch (Exception ex) {
            throw new RuntimeException("delete doc error!", ex);
        }
    }

    //更新文档
    public void updateDoc(String index, String id, RequestOptions options) {
        try {
            UpdateRequest request = new UpdateRequest(index, id);
            UpdateResponse response = client.update(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("update doc error!", ex);
        }
    }

    //删除文档
    public void searchDoc(String index, String id, RequestOptions options) {
        try {
            SearchRequest request = new SearchRequest();
            SearchResponse response = client.search(request, options);
        } catch (Exception ex) {
            throw new RuntimeException("search doc error!", ex);
        }
    }
}
