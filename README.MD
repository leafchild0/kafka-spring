**Intro**

This is a small project to test Kafka and event-sourcing. Contains 3 modules: publisher and 2 subscribers.
First subscriber will save messages in DB (H2 embedded), second one to display them in Web. All web modules are built 
using Vaadin 10. For the purpose of demo, there is only one topic and group id, so whoever first from subscribers will 
connect, it will take the message.
All the apps are using Spring boot and embedded Tomcat.

**How to run**

Everything can be run from your favorite IDE or using console. For console way - just build everything using gradle 
and run a docker compose container.
You will need a kafka + zookeeper running. For an easy use, it's added in a docker-compose(kafka-zookeeper.yml). 
So, just run that configuration.

Then first run Publisher app (spring-kafka, PublisherApplication.java).

After that run any of subscribers or both (subscriber-db module, SubscriberDbApplication or subscriber-web module, 
SubscriberWebApplication). 
That's should be enough to have it up and running.

**How to test** 

**Publisher** app will be running on localhost:8080 and will have a simple form with message body and button to send.
**DB subscriber** will be running on port 8082. Since there is no UI, H2 console can be used to check new data in DB.
 Use
 /h2_console path with in memory db - messagedb and login sa without a password.
 **Web subscriber** will be running on 8081 port and simply display messages as labels using Vaadin, nothing fancy but 
 should be enough to understand the concept.  
 
 **Limitations**
 
 Current implementation will work with only one subscriber. I did it on purpose. Should not be hard to change that.
