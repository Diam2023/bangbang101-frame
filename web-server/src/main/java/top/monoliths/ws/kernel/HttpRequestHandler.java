package top.monoliths.ws.kernel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static final String root = "web";

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    @SuppressWarnings("all")
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req)
            throws FileNotFoundException, Exception {
        // 100 Continue
        // if (is100ContinueExpected(req)) {
        // ctx.write(new DefaultFullHttpResponse(
        // HttpVersion.HTTP_1_1,
        // HttpResponseStatus.CONTINUE));
        // }
        // 获取请求的uri
        String uri = URLDecoder.decode(req.uri());
        Map<String, String> resMap = new HashMap<>();
        resMap.put("method", req.method().name());
        resMap.put("uri", uri);

        StringBuffer msg = new StringBuffer();
        String head = "text/html; charset=UTF-8";
        String line;
        BufferedReader bufferedReader;
        ByteBuf body;
        BufferedInputStream bf;
        if (uri.equals("/")) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(root + "/index.html")));
            head = "text/html; charset=UTF-8";
            while ((line = bufferedReader.readLine()) != null) {
                msg.append(line + "\n");
            }
            line = null;
            bufferedReader.close();
            body = Unpooled.copiedBuffer(msg.toString(), CharsetUtil.UTF_8);
        } else {
            switch (uri.substring(uri.lastIndexOf("."))) {
                case ".css":
                    head = "text/css; charset=UTF-8";
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(root + uri)));
                    while ((line = bufferedReader.readLine()) != null) {
                        msg.append(line + "\n");
                    }
                    System.out.println(uri);
                    line = null;
                    bufferedReader.close();
                    body = Unpooled.copiedBuffer(msg.toString(), CharsetUtil.UTF_8);
                    break;
                case ".jpg":
                    head = "image/jpeg";
                    bf = new BufferedInputStream(new FileInputStream(root + uri));
                    body = Unpooled.copiedBuffer(bf.readAllBytes());
                    bf.close();
                    break;
                case ".js":
                    head = "application/javascript; charset=UTF-8";
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(root + uri)));
                    while ((line = bufferedReader.readLine()) != null) {
                        msg.append(line + "\n");
                    }
                    System.out.println(uri);
                    line = null;
                    bufferedReader.close();
                    body = Unpooled.copiedBuffer(msg.toString(), CharsetUtil.UTF_8);
                    break;
                case ".png":
                    head = "image/png";
                    bf = new BufferedInputStream(new FileInputStream(root + uri));
                    body = Unpooled.copiedBuffer(bf.readAllBytes());
                    bf.close();
                    break;
                case ".json":
                    head = "application/json; charset=UTF-8";
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(root + uri)));
                    while ((line = bufferedReader.readLine()) != null) {
                        msg.append(line + "\n");
                    }
                    System.out.println(uri);
                    line = null;
                    bufferedReader.close();
                    body = Unpooled.copiedBuffer(msg.toString(), CharsetUtil.UTF_8);
                default:
                    body = Unpooled.copiedBuffer(msg.toString(), CharsetUtil.UTF_8);
                    break;
            }
        }

        // 创建http响应
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, body);
        // 设置头信息
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, head);
        // response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;
        // charset=UTF-8");
        // 将html write到客户端
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
