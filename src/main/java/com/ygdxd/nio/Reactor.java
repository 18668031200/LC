package com.ygdxd.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author Created by ygdxd_admin at 2018-07-12 下午11:01
 */
public class Reactor implements Runnable {

    public final Selector selector;

    public final ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        // 创建选择器
        selector = Selector.open();
        // 打开监听信道
        serverSocketChannel = ServerSocketChannel.open();
        // 与本地端口绑定
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
        System.out.println(InetAddress.getLocalHost());
        serverSocketChannel.socket().bind(inetSocketAddress);
        // 设置为非阻塞模式,只有非阻塞信道才可以注册选择器,否则异步IO就无法工作
        serverSocketChannel.configureBlocking(false);
        // 向selector注册该channel
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 利用selectionKey的attache功能绑定Acceptor
        selectionKey.attach(new Acceptor(this));
    }

    @Override
    public void run() {

    }
}
