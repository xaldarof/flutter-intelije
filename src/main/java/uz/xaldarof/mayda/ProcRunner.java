package uz.xaldarof.mayda;

import com.intellij.openapi.ui.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcRunner {
    static void run(String command) {
        String os = System.getProperty("os.name").toLowerCase();

        ProcessBuilder processBuilder;

        // Adjust command based on the OS
        if (os.contains("win")) {
            processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        } else {
            processBuilder = new ProcessBuilder("bash", "-c", command);
        }

        try {
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
//                Messages.showInfoMessage("Command executed successfully:\n" + output, "Success");
            } else {
//                Messages.showErrorDialog("Command execution failed with exit code " + exitCode, "Error");
            }

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace(); // Capture detailed error
            Messages.showErrorDialog("An error occurred: " + ex.getMessage(), "Error");
        }
    }
}
