package study.elasticsearch.springboot.repository.product;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "product", shards = 5, replicas = 1)
public class ProductEntity {

    @Id
    private Long ubId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String ubLoginName;
    @Field(type = FieldType.Text)
    private String ubLoginPwd;
}
