package top.monoliths.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.monoliths.ws.server.HttpServer;

/**
 * start server
 *
 */
public class App {
    
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(80);
        log.info("server start");
        server.start();
    }
}
