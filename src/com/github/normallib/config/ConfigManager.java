package com.github.normallib.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ConfigManager {

        private final JavaPlugin plugin;
        private File configFile;
        private FileConfiguration config;
        public ConfigManager(JavaPlugin plugin, String fileName) {
            this.plugin = plugin;
            configFile = new File(plugin.getDataFolder(), fileName);
            if (!configFile.exists()) {
                plugin.saveResource(fileName, false);
            }
            config = YamlConfiguration.loadConfiguration(configFile);
        }
        public void saveConfig() {
            try {
                config.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void reloadConfig() {
            config = YamlConfiguration.loadConfiguration(configFile);
        }
        public void set(String path, Object value) {
            config.set(path, value);
        }
        public Object get(String path) {
            return config.get(path);
        }
        public String getString(String path) {
            return config.getString(path);
        }
        public int getInt(String path) {
            return config.getInt(path);
        }
        public double getDouble(String path) {
            return config.getDouble(path);
        }
        public boolean getBoolean(String path) {
            return config.getBoolean(path);
        }
        public List<String> getStringList(String path) {
            return config.getStringList(path);
        }
        public Set<String> getKeys(boolean deep) {
            return config.getKeys(deep);
        }
        public void addDefault(String path, Object value) {
            config.addDefault(path, value);
        }
        public void setDefaults(FileConfiguration defaults) {
            config.setDefaults(defaults);
        }
        public void removeKey(String path) {
            config.set(path, null);
        }
        public void saveDefaultConfig() {
            if (!configFile.exists()) {
                plugin.saveResource(configFile.getName(), false);
            }
        }

        public static File generate(String path, String fileName, String suffix) throws IOException {
        String fullFileName = fileName + "." + suffix;
        File file = new File(path + File.separator + fullFileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }
}
