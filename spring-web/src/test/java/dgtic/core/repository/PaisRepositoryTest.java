package dgtic.core.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Sql("/data.sql")
class PaisRepositoryTest {

    @Autowired
    PaisRepository paisRepository;
    @Test
    void obtenerPaisesConIdDTO() {
        paisRepository.obtenerPaisesDTO().forEach(System.out::println);
    }
}