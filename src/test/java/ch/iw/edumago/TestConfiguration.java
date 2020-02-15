package ch.iw.edumago;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;


@TestPropertySource("application.yml")
@ComponentScan("ch.iw.edumago")
public class TestConfiguration {


}


