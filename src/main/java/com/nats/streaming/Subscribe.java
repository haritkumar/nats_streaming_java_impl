package com.nats.streaming;

import java.util.concurrent.CountDownLatch;

import io.nats.streaming.Message;
import io.nats.streaming.MessageHandler;
import io.nats.streaming.NatsStreaming;
import io.nats.streaming.StreamingConnection;
import io.nats.streaming.Subscription;
import io.nats.streaming.SubscriptionOptions;

public class Subscribe {

	public static void main(String[] args) {
		try {
			StreamingConnection sc = NatsStreaming.connect("test-cluster", "subscriber_id");
			final CountDownLatch doneSignal = new CountDownLatch(1);
			// Simple Async Subscriber that retrieves all available messages.
			Subscription sub = sc.subscribe("foo", new MessageHandler() {
			    public void onMessage(Message m) {
			        System.out.printf("Received a message: %s\n", new String(m.getData()));
			        if(new String(m.getData()).contains("END")) {
			        		doneSignal.countDown();
			        }
			    }
			}, new SubscriptionOptions.Builder().deliverAllAvailable().build());
			doneSignal.await();
			// Unsubscribe to clean up
			sub.unsubscribe();
			// Close the logical connection to NATS streaming
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
