package top.monoliths.ws;

import top.monoliths.ws.kernel.HttpServer;

/**
 * start server
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(80);
        server.start();
    }
}
