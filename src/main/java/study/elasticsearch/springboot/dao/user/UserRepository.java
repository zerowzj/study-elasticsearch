package study.elasticsearch.springboot.dao.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEntity, Long> {
}
