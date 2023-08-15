package kim.zhyun.studyredis.service;

import kim.zhyun.studyredis.config.RedisConfiguration;
import kim.zhyun.studyredis.model.entity.Store;
import kim.zhyun.studyredis.model.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootTest
@Import(RedisConfiguration.class)
class StoreServiceTest {

    @Autowired
    private StoreRepository repository;

    @Test
    void dummy_store_save_AND_search_AND_delete() {
        // 데이터 저장
        long idx = (long) (Math.random() * 100 + 100);
        repository.saveAll(getList(idx));
        
        // 모든 데이터 출력
        System.out.println("\n📍 모든 데이터 출력");
        Iterable<Store> stores = repository.findAll();
        stores.forEach(store -> System.out.println("🫴 save store : " + store));


        // 검색
        System.out.println("\n📍 검색");
        Store byName = repository.findById(idx).get();
        System.out.printf("store name : %s , id : %d\n", byName.getName(), byName.getId());


        // 테스트 데이터 삭제
        System.out.println("\n📍 삭제");
        repository.deleteAll(stores);
        repository.findAll().forEach(store -> System.out.println("🫴 clean store  : " + store));
    }






    private List<Store> getList(long idx) {
        return List.of(
                  new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
                , new Store((long) idx, "매장 " + idx, "서울시 " + idx + "구", idx + " 길", idx + "층", Double.parseDouble(String.format("127.%06d", Math.round(Math.random() * 10000000))), Double.parseDouble(String.format("37.%06d", Math.round(Math.random() * 10000000))), "description " + idx++, Double.parseDouble(String.format("%1.1f", Math.abs(Math.random() * 10 - 5))))
        );
    }
}
