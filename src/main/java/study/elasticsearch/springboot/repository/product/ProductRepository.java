package study.elasticsearch.springboot.repository.product;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import study.elasticsearch.springboot.repository.user.UserEntity;

public interface ProductRepository extends ElasticsearchRepository<ProductEntity, Long> {
}
