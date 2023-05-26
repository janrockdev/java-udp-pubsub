# UDP Broadcaster/Receiver in Java

```shell
//compile
mvn clean package

//run receivers
java -jar receiver/target/receiver-1.0-SNAPSHOT.jar 8888
java -jar receiver/target/receiver-1.0-SNAPSHOT.jar 8889
java -jar receiver/target/receiver-1.0-SNAPSHOT.jar 8890

//run broadcaster
java -jar broadcaster/target/broadcaster-1.0-SNAPSHOT.jar

//receiver output
Received message: Hello, receivers!
```
