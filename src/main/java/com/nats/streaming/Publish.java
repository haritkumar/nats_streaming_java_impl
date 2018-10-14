package com.nats.streaming;

import org.apache.commons.lang3.RandomStringUtils;

import io.nats.streaming.StreamingConnection;
import io.nats.streaming.StreamingConnectionFactory;

public class Publish {

	public static void main(String[] args) {
		try {
			// Create a connection factory
			StreamingConnectionFactory cf = new StreamingConnectionFactory("test-cluster", "client_id");

			// A StreamingConnection is a logical connection to the NATS streaming
			// server.  This API creates an underlying core NATS connection for
			// convenience and simplicity.  In most cases one would create a secure
			// core NATS connection and pass it in via
			// StreamingConnectionFactory.setNatsConnection(Connection nc)
			StreamingConnection sc = cf.createConnection();

			// This simple synchronous publish API blocks until an acknowledgement
			// is returned from the server.  If no exception is thrown, the message
			// has been stored in NATS streaming.
			//Channel foo
			String rand = RandomStringUtils.random(20, false, true);
			sc.publish("foo", ("START_"+rand).getBytes());
			for(int i = 0;i< 20; i++) {
				Thread.sleep(1000);
				System.out.println("Publishing "+(i+" Hello World_"+rand));
				sc.publish("foo", (i+" Hello World_"+rand).getBytes());
			}
			sc.publish("foo", ("END_"+rand).getBytes());
			// Close the logical connection to NATS streaming
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
