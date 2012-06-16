/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenk.gpsserver.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 *
 * @author omenkzz
 */
public class DiscardServer extends ServerBootstrap{

    public static void main(String[] args) throws Exception {
        ChannelFactory factory = new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool());

        ServerBootstrap bootstrap = new ServerBootstrap(factory);
        
//        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
//
//            public ChannelPipeline getPipeline() {
//                return Channels.pipeline(new DiscardServerHandler());
//
//            }
//        });
        bootstrap.setPipelineFactory(new MyPipelineFactory());
        bootstrap.bind(new InetSocketAddress(9999));
        System.out.println("server started . . . . . . .");
    }
}
