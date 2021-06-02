package top.monoliths.ws.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty server 2018/11/1.
 */
public class HttpServer {
    private static final Logger log = LoggerFactory.getLogger(HttpServer.class);

    private int port;

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public HttpServer(int port) {
        setPort(port);
    }

    public void start() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boss, work).handler(new LoggingHandler(LogLevel.DEBUG)).channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer());
        ChannelFuture f = bootstrap.bind(new InetSocketAddress(port)).sync();
        log.info ("server start up on port : " + port); 
        f.channel().closeFuture().sync();

    }

}