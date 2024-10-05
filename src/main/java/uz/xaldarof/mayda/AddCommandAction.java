package uz.xaldarof.mayda;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.openhtmltopdf.extend.SVGDrawer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AddCommandAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String initialValue = "";
        final List<String> stored = Utils.getList(Keys.commands);
        if (stored != null) initialValue = Utils.listToString(stored);
        String input = Messages.showInputDialog("Enter command value:", "Input Command", Messages.getQuestionIcon(), initialValue, null);
        if (input != null && !input.trim().isEmpty()) {
            final ArrayList<String> list = new ArrayList<>(Arrays.stream(input.split(",")).toList());
            Utils.saveList(Keys.commands, list);
        }

    }
}
