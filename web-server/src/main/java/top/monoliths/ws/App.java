package top.monoliths.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.monoliths.ws.kernel.HttpServer;

/**
 * start server
 *
 */
public class App {
    
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws Exception {
        log.info("msg");
        log.error("msgoklmdwa");
        HttpServer server = new HttpServer(80);
        server.start();
    }
}
