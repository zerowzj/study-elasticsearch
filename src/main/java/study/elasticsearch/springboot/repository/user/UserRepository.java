package study.elasticsearch.springboot.repository.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEntity, Long> {
}
