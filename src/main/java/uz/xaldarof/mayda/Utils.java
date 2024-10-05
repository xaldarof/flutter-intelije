package uz.xaldarof.mayda;

import com.intellij.openapi.ui.Messages;

public class Utils {
    private Utils() {

    }

    static boolean isFlutterInstalled() {
        String flutterHome = System.getenv("FLUTTER_HOME");
        return flutterHome != null;
    }

    static void showWarning(String message, String title) {
        Messages.showWarningDialog(message, title);
    }
}
