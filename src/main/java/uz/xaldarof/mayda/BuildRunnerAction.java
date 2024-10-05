package uz.xaldarof.mayda;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BuildRunnerAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final boolean isFlutterAvailable = Utils.isFlutterInstalled();
        if (!isFlutterAvailable) {
            Utils.showWarning("Flutter not found", "Error");
            return;
        }
        Project project = e.getProject();
        assert project != null;
        String projectDir = project.getBasePath();
        ArrayList<String> cmds = new ArrayList<>();
        cmds.add("flutter pub get && flutter pub run build_runner build --delete-conflicting-outputs");
        GeneralCommandLine generalCommandLine = new GeneralCommandLine(cmds);
        generalCommandLine.setCharset(StandardCharsets.UTF_8);
        generalCommandLine.setWorkDirectory(projectDir); // Set the working directory

        ProcessHandler processHandler = null;
        try {
            processHandler = new OSProcessHandler(generalCommandLine);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        processHandler.startNotify();
    }
}