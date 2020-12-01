package com.syf.leetcode.io.nio;

import com.sun.deploy.net.MessageHeader;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.Base64.Decoder;

import static org.yaml.snakeyaml.util.UriEncoder.decode;

/**
 * @auth syf
 * @date 2020/10/18 22:20
 */
public class SelectorAndChannel {
    public static void main(String[] args) {
        try {
            // 1.创建服务端通道severSocketChannel,用于监听客户端的连接
            ServerSocketChannel acceptor = ServerSocketChannel.open();
            // 2.绑定监听端口，设置连接为非阻塞模式
            int port = 8080;
            acceptor.bind(new InetSocketAddress(InetAddress.getByName("IP"),port));
            acceptor.configureBlocking(false);
            // 3.创建Reactor线程，创建多路复用器并启动线程
            Selector selector = Selector.open();
            new Thread(new ReactorTask()).start();
            // 4.将ServerSocketChannel注册到Reactor线程多路复用器中Selector上，监听accept事件
            Object ioHandler = null;
            acceptor.register(selector, SelectionKey.OP_ACCEPT,ioHandler);
            // 5.多路复用器在线程run方法无限循环体内轮询准备就绪的key
            int num = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 处理io事件
                /**
                 * TODO
                 */
            }
            // 6.多路复用监听到用新的客户端接入时，会处理新的接入的请求，完成TCP三次握手，建立物理链路
            SocketChannel channel = acceptor.accept();
            // 7.设置客户端链路为非阻塞状态
            channel.configureBlocking(false);
            channel.socket().setReuseAddress(true);
            // 8.将接入的新客户端注册到Reactor线程的多路复用器selector上，监听读操作，读取客户端发送的网络消息
            SelectionKey key = channel.register(selector, SelectionKey.OP_READ, ioHandler);
            // 9.异步读取客户端请求消息到缓冲区
            ByteBuffer receicedBuffer = null;
            int readNum = channel.read(receicedBuffer);
            // 10.对BytyBUffer进行编解码
            Object message = null ;
            List messageList = new ArrayList();
            while (receicedBuffer.hasRemaining()){
                receicedBuffer.mark();
                message = decode(receicedBuffer);
                if(message != null){
                    receicedBuffer.reset();
                    break;
                }

                messageList.add(message);
            }
            if(!receicedBuffer.hasRemaining()){
                receicedBuffer.clear();
            }else {
                receicedBuffer.compact();
                if(messageList != null && !messageList.isEmpty()){
                    for(Object messageE : messageList){
                        handlerTask(messageE);
                    }
                }
            }
            // 11.将POJO对象encode成BytyBuffer,调用socketChannel的异步write接口，将消息异步发送给客户端
            channel.write(receicedBuffer);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void handlerTask(Object messageE) {
    }
}
