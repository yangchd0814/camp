package com.yangchd.week03.homework01;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpHandler extends ChannelInboundHandlerAdapter {

    public static CloseableHttpClient client = HttpClients.createDefault();
    public static String host = "http://localhost:8801/";
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
            HttpGet httpGet = new HttpGet(host);
            CloseableHttpResponse response = null;
            FullHttpResponse fullResponse = null;
            try {
                response = client.execute(httpGet);
                byte[] body = EntityUtils.toByteArray(response.getEntity());
                fullResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(body));
                fullResponse.headers().set("Content-Type", "application/json");
                fullResponse.headers().setInt("Content-Length", fullResponse.content().readableBytes());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fullHttpRequest != null) {
                    if (!HttpUtil.isKeepAlive(fullHttpRequest)) {
                        ctx.write(fullResponse).addListener(ChannelFutureListener.CLOSE);
                    } else {
                        //response.addHeader("Connection", "Keep-Alive");
                        ctx.write(fullResponse);
                    }
                }
                ctx.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
