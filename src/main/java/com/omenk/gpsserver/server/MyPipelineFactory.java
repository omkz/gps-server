/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenk.gpsserver.server;

import com.omenk.gpsserver.decoder.MVT600Decoder;
import com.omenk.gpsserver.decoder.VT310Decoder;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.util.CharsetUtil;

/**
 *
 * @author omenkzz
 */
public class MyPipelineFactory implements ChannelPipelineFactory {

    private static final ChannelHandler VT310Decoder = new VT310Decoder();
    private static final ChannelHandler HANDLER = new DiscardServerHandler();
    private static final ChannelHandler STR_ENCODER = new StringEncoder();
    private static final ChannelHandler STR_DECODER = new StringDecoder();

    @Override
    public ChannelPipeline getPipeline() throws Exception {

        // create default pipeline from static method
        ChannelPipeline pipeline = Channels.pipeline();
        // Decoders
       
        pipeline.addLast("frameDecoder", new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()));
        pipeline.addLast("stringDecoder", STR_DECODER);
        pipeline.addLast("stringEncoder", STR_ENCODER);
        pipeline.addLast("vt300decoder", VT310Decoder);
        pipeline.addLast("handler", HANDLER);
        
       


        return pipeline;
    }
}
