package test.study.springboot.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.elasticsearch.springboot.repository.user.UserEntity;
import study.elasticsearch.springboot.repository.user.UserRepository;
import study.elasticsearch.springboot.support.SpringBootCfg;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootCfg.class})
public class ElasticsearchRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUbId(10001L);
        userRepository.save(userEntity);
    }
}
