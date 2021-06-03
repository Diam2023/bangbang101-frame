package top.monoliths.ws.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import top.monoliths.ws.kernel.ConfigData;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty server 2018/11/1.
 */
public class HttpServer {
    private static final Logger LOG = LoggerFactory.getLogger(HttpServer.class);

    private ConfigData configData;

    public void setConfigData(ConfigData configData) {
        this.configData = configData;
    }

    public ConfigData getConfigData() {
        return configData;
    }

    public HttpServer(ConfigData configData) {
        setConfigData(configData);
    }

    public void start() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boss, work).handler(new LoggingHandler(LogLevel.DEBUG)).channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer(getConfigData()));
        ChannelFuture f = bootstrap.bind(new InetSocketAddress(configData.getLocal(), configData.getPort())).sync();
        LOG.info ("server start up on port : " + configData.getPort()); 
        f.channel().closeFuture().sync();

    }

}