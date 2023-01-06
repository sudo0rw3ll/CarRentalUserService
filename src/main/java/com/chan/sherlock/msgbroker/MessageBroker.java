package com.chan.sherlock.msgbroker;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;

public class MessageBroker {

    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:31337");
        broker.start();
    }
}
