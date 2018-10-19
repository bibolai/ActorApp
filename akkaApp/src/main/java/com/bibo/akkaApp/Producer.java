package com.bibo.akkaApp;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = ActorSystem.create("my-event-topic");
        ActorRef consumer = system.actorOf(Props.create(Consumer.class));
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("----> Producer is sending a number " +  i);
            consumer.tell(i, ActorRef.noSender());
            TimeUnit.SECONDS.sleep(1);
        }
        
        system.shutdown();
        System.out.println("=====> Done with sending numbers 1 to 10");
        
    }
}
