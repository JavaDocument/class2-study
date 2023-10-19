package level1;

import level1.config.AppConfigFactory;
import level1.controller.Controller;

public class Solution {
    public static void main(String[] args) {
        final Controller controller = AppConfigFactory.generateController();
        controller.run();
    }
}