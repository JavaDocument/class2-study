package level3.domain;

import level3.domain.config.AppConfig;
import level3.domain.controller.Controller;

public class Solution {
    public static void main(String[] args) {
        final Controller controller = AppConfig.generateController();
        controller.run();
    }

}
