package pathners.pathner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pathners.pathner.decorator.Frances_2;
import pathners.pathner.decorator.Pao_1;
import pathners.pathner.decorator.Salame_4;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class PaoTest {



    private Pao_1 pao;

    @BeforeEach
    public void setup(){
        pao = new Frances_2();
    }

    @Test
    @DisplayName("test total valor lanche salame")
    public void criandoNovoLancheFrances(){

      Salame_4 actual = new Salame_4(new Frances_2());
      Assertions.assertEquals(4.5, actual.getValor());

    }
}
