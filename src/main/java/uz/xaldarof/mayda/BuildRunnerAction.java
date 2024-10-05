package uz.xaldarof.mayda;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.execution.util.ExecUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class BuildRunnerAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final boolean hasStoresValues = Utils.getList(Keys.commands) != null;
        if (!hasStoresValues) {
            Utils.showWarning("Commands list is empty, please add minimum 1 command.", "Error");
            return;
        }
        ArrayList<String> commands = new ArrayList<>(Objects.requireNonNull(Utils.getList(Keys.commands)));
        commands.forEach(ProcRunner::run);
    }
}