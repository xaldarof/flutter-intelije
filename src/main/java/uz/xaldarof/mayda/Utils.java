package uz.xaldarof.mayda;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    static void saveValue(String key, String value) {
        PropertiesComponent.getInstance().setValue(key, value);
    }

    static void saveList(String key, ArrayList<String> value) {
        PropertiesComponent.getInstance().setList(key, value);
    }

    static @Nullable List<String> getList(String key) {
        return PropertiesComponent.getInstance().getList(key);
    }

    static @NotNull String listToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    static String getValue(String key) {
        return PropertiesComponent.getInstance().getValue(key);
    }
}
