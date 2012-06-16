/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenk.gpsserver.server;


import com.omenk.gpsserver.dao.PositionDAO;
import com.omenk.gpsserver.model.Position;
import com.omenk.gpsserver.util.SpringUtilities;
import java.io.IOException;
import java.nio.channels.Channel;
import org.jboss.netty.channel.*;

/**
 *
 * @author omenkzz
 */
//@ChannelHandler.Sharable
@ChannelPipelineCoverage("all")
public class DiscardServerHandler extends SimpleChannelHandler {

    PositionDAO positionDAO;


    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
     
        if (e.getMessage() instanceof Position) {
            System.out.println("e adalah instan Position");

            Position position = (Position) e.getMessage();

            if (position == null) {
                System.out.println("null message");
            } else {
                System.out.println(
                        "id: " + position.getId()
                        + ", deviceId: " + position.getDeviceId()
                        + ", valid: " + position.getValid()
                        + ", time: " + position.getTime()
                        + ", latitude: " + position.getLatitude()
                        + ", longitude: " + position.getLongitude()
                        + ", altitude: " + position.getAltitude()
                        + ", speed: " + position.getSpeed()
                        + ", course: " + position.getCourse());
            }

            // Write position to database
            try {
                PositionDAO positionDAO = SpringUtilities.getPositionDAO();
                positionDAO.persist(position);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
            finally{
                System.out.println("pinali");
            }
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws IOException {

        System.out.println("terjadi kesalahan");
        e.getCause().printStackTrace();

        Channel ch = (Channel) e.getChannel();
        ch.close();
    }

    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleDownstream(ctx, e);
    }
    
    

    
}