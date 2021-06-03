package top.monoliths.ws.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import top.monoliths.ws.kernel.ConfigData;

public class HttpServerInitializer extends ChannelInitializer<Channel>{

    private ConfigData configData;

    public void setConfigData(ConfigData configData) {
        this.configData = configData;
    }

    public ConfigData getConfigData() {
        return configData;
    
    }
    
    public HttpServerInitializer(ConfigData configData) {
        setConfigData(configData);
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("cwodec", new HttpServerCodec());// http encode
        pipeline.addLast("aggregator",new HttpObjectAggregator(512*1024)); // http 消息聚合器512*1024为接收的最大contentlength
        pipeline.addLast("compressor", new HttpContentCompressor()); // compressor
        pipeline.addLast(new HttpRequestHandler(getConfigData()));// 请求处理器

    }
}
