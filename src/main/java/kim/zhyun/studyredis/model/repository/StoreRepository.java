package kim.zhyun.studyredis.model.repository;

import kim.zhyun.studyredis.model.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {
}
