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
    private Long pbId;

    @Field(type = FieldType.Text)
    private String pbName;
}
