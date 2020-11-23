package study.elasticsearch.springboot.dao.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(indexName = "item_index", type = "item"/*, shards = 1, replicas = 0*/)
public class UserEntity {
    @Id
    private Long id;

    @Field(type = FieldType.Text/*, analyzer = "ik_max_word"*/)
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private String brand; //
}
