package level2;

import level2.config.AppConfig;
import level2.controller.Controller;

public class Solution {
    public static void main(String[] args) {
        final Controller controller = AppConfig.generateController();
        controller.run();
    }

}