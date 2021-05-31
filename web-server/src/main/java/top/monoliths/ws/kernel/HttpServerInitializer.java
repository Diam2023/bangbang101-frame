package top.monoliths.ws.kernel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<Channel>{

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("cwodec", new HttpServerCodec());// http encode
        pipeline.addLast("aggregator",new HttpObjectAggregator(512*1024)); // http 消息聚合器512*1024为接收的最大contentlength
        pipeline.addLast("compressor", new HttpContentCompressor()); // compressor
        pipeline.addLast(new HttpRequestHandler());// 请求处理器

    }
}
