package dgtic.core.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CiudadRepositoryTest {

    @Autowired
    CiudadRepository ciudadRepository;
    @Test
    void obtenerCiudadesPorPais() {
        ciudadRepository.obtenerCiudadesPorPais(1L).forEach(System.out::println);
    }
}