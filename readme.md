## NATS streaming Java implementation
Import below dependancy 
https://github.com/nats-io/java-nats-streaming

```xml
<dependency>
    <groupId>io.nats</groupId>
    <artifactId>java-nats-streaming</artifactId>
    <version>2.1.0</version>
</dependency>
```

#### http://localhost:8222/connz

```json
{
	cid: 11,
	ip: "172.17.0.1",
	port: 48586,
	start: "2018-10-14T10:02:41.9973658Z",
	last_activity: "2018-10-14T10:04:15.3242216Z",
	rtt: "1ms",
	uptime: "1m34s",
	idle: "1s",
	pending_bytes: 0,
	in_msgs: 36,
	out_msgs: 36,
	in_bytes: 1768,
	out_bytes: 925,
	subscriptions: 3,
	name: "client_id",
	lang: "java",
	version: "2.1.1"
}
```

### Run publisher & subscriber
Subscriber logs

```sh
Received a message: START_55922946412433078789
Received a message: 0 Hello World_55922946412433078789
Received a message: 1 Hello World_55922946412433078789
Received a message: 2 Hello World_55922946412433078789
Received a message: 3 Hello World_55922946412433078789
Received a message: 4 Hello World_55922946412433078789
Received a message: 5 Hello World_55922946412433078789
Received a message: 6 Hello World_55922946412433078789
Received a message: 7 Hello World_55922946412433078789
Received a message: 8 Hello World_55922946412433078789
Received a message: 9 Hello World_55922946412433078789
Received a message: 10 Hello World_55922946412433078789
Received a message: 11 Hello World_55922946412433078789
Received a message: 12 Hello World_55922946412433078789
Received a message: 13 Hello World_55922946412433078789
Received a message: 14 Hello World_55922946412433078789
Received a message: 15 Hello World_55922946412433078789
Received a message: 16 Hello World_55922946412433078789
Received a message: 17 Hello World_55922946412433078789
Received a message: 18 Hello World_55922946412433078789
Received a message: 19 Hello World_55922946412433078789
Received a message: END_55922946412433078789

```