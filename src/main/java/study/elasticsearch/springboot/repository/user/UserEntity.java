package study.elasticsearch.springboot.repository.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "user", shards = 5, replicas = 1)
public class UserEntity {

    @Id
    private Long ubId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String ubLoginName;
    @Field(type = FieldType.Text)
    private String ubLoginPwd;
}
