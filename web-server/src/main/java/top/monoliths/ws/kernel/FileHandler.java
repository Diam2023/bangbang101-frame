package top.monoliths.ws.kernel;

public class FileHandler {
    private static String webRoot;

    public static void setWebRoot(String path) {
        webRoot = path;
    }

    public static String getWebRoot() {
        return webRoot;
    }

    public FileHandler(String configPath) {
        setWebRoot(configPath);
    }
}