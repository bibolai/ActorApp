package com.bibo.akkaApp;

import akka.actor.UntypedActor;

public class Consumer extends UntypedActor {
 
    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg instanceof Integer) {
            System.out.println("<---- Consumer is receiving " + msg);
        }
    }
}