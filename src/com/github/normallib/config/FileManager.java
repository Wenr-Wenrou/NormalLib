package com.github.normallib.config;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class FileManager {
    private final JavaPlugin plugin;
    public FileManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public File getConfigFile(String fileName) {
        File configFile = new File(plugin.getDataFolder(), fileName);
        if (!configFile.exists()) {
            return null;
        }
        return configFile;
    }
    public File findFile(String fileName, File folder) {
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                File result = findFile(fileName, file);
                if (result != null) {
                    return result;
                }
            } else if (file.getName().equalsIgnoreCase(fileName)) {
                return file;
            }
        }
        return null;
    }
}
