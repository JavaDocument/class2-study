package level1.config;

import level1.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppConfigFactoryTest {

    @Test
    @DisplayName("컨트롤러 인스턴스 생성에 성공할 것이다.")
    void AppConfigFactoryTest1() {
        // given
        // when
        Controller controller = AppConfigFactory.generateController();

        // then
        assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("생선된 인스턴스는 같은 인스턴스일 것이다.")
    void AppConfigFactoryTest2() {
        // given
        // when
        Controller controller1 = AppConfigFactory.generateController();
        Controller controller2 = AppConfigFactory.generateController();
        Controller controller3 = AppConfigFactory.generateController();
        Controller controller4 = AppConfigFactory.generateController();
        Controller controller5 = AppConfigFactory.generateController();

        // then
        assertThat(controller1).isEqualTo(controller2)
                .isEqualTo(controller3)
                .isEqualTo(controller4)
                .isEqualTo(controller5);
    }

}