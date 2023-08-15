package kim.zhyun.studyredis.service;

import kim.zhyun.studyredis.model.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoreService {
    private StoreRepository repository;
}
