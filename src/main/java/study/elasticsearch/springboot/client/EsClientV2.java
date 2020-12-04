package study.elasticsearch.springboot.client;

import org.elasticsearch.client.RequestOptions;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

public class EsClientV2 {

    private ElasticsearchRestTemplate template;

    public EsClientV2(ElasticsearchRestTemplate template) {
        this.template = template;
    }

    /**
     * （★）索引
     */
    //创建索引
    public void createIndex(String index, RequestOptions options) {
        try {
//            template.c
        } catch (Exception ex) {
            throw new RuntimeException("create index error!", ex);
        }
    }

    //删除索引
    public void deleteIndex(String index, RequestOptions options) {
        try {

        } catch (Exception ex) {
            throw new RuntimeException("create index error!", ex);
        }
    }

    /**
     * （★）文档
     */
    //插入文档
    public <T> void save(String index, T entity) {
        try {
            template.save(entity, IndexCoordinates.of(index));
        } catch (Exception ex) {
            throw new RuntimeException("save doc error!", ex);
        }
    }

    //删除文档
    public void delete(String index, String id) {
        try {
            template.delete(id, IndexCoordinates.of(index));
        } catch (Exception ex) {
            throw new RuntimeException("delete doc error!", ex);
        }
    }

    //更新文档
    public void updateDoc(String index, String id, RequestOptions options) {
        try {
        } catch (Exception ex) {
            throw new RuntimeException("update doc error!", ex);
        }
    }


    //删除文档
    public void searchDoc(String index, String id, RequestOptions options) {
        try {
//            template.search()
        } catch (Exception ex) {
            throw new RuntimeException("search doc error!", ex);
        }
    }
}
