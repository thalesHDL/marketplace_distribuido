/*
Credits: http://www.jgroups.org/tutorial/index.html

2. Writing a simple application

The goal of this chapter is to write a simple text-based chat application
(HelloworldChat), with the following features:

    All instances of HelloworldChat find each other and form a cluster.

    There is no need to run a central chat server to which instances have to
    connect. Therefore, there is no single point of failure.

    A chat message is sent to all instances of the cluster.

    An instance gets a notification callback when another instance leaves (or
    crashes) and when other instances join.

    (Optional) We maintain a common cluster-wide shared state, e.g. the chat
    history. New instances acquire that history from existing instances.

2.1. JGroups overview:

   JGroups uses a JChannel as the main API to connect to a cluster, send and
   receive messages, and to register listeners that are called when things (such
   as member joins) happen.

   What is sent around are Messages, which contain a byte buffer (the payload),
   plus the sender’s and receiver’s address. Addresses are subclasses of
   org.jgroups.Address, and usually contain an IP address plus a port.

   The list of instances in a cluster is called a View, and every instance
   contains exactly the same View. The list of the addresses of all instances
   can get retrieved by calling View.getMembers().

   Instances can only send or receive messages after they’ve joined a cluster.

   When an instance wants to leave the cluster, methods JChannel.disconnect() or
   JChannel.close() can be called. The latter actually calls disconnect() if the
   channel is still connected before closing the channel.
/**/

import org.jgroups.*;
import org.jgroups.util.*;
import java.io.*;
import java.util.*;

public class HelloworldChat extends ReceiverAdapter {
    JChannel channel;
    String user_name=System.getProperty("user.name", "n/a");
    //String user_name="seu_nickname_aqui";

/*
2.2. Creating a channel and joining a cluster:

   To join a cluster, we’ll use a JChannel. An instance of JChannel is created
   with a configuration (e.g. an XML file) which defines the properties of the
   channel. To actually connect to the cluster, the connect(String clustername)
   method is used. All channel instances which call connect() with the same
   argument will join the same cluster. So, let’s actually create a JChannel and
   connect to a cluster called "ChatGroup".

   First we create a channel using the empty constructor. This configures the
   channel with the default properties. Alternatively, we could pass an XML file
   to configure the channel, e.g. new JChannel("./xml-configs/udp.xml").
   The connect() method joins cluster "ChatGroup". Note that we don’t need to
   explicitly create a cluster beforehand; connect() creates the cluster if it is
   the first instance. All instances which join the same cluster will be in the
   same cluster.
/**/

    private void start() throws Exception {
        channel=new JChannel();		//usa a configuração default

        //Cria o canal de comunicação com configurações alternativas
           //channel=new JChannel("./xml-configs/udp.xml");
           //channel=new JChannel("./xml-configs/encrypt.xml");

        channel.setReceiver(this);	//quem irá lidar com as mensagens recebidas

        channel.connect("ChatGroup");
           eventLoop();
        channel.close();
    }

    public static void main(String[] args) throws Exception {
        new HelloworldChat().start();
    }

/*
2.3. The main event loop and sending chat messages:

   We now run an event loop, which reads input from stdin (a message) and sends
   it to all instances currently in the cluster. When "exit" or "quit" are
   entered, we fall out of the loop and close the channel.

   We added the call to eventLoop() and the closing of the channel to the
   start() method, and we provided an implementation of eventLoop.

   The event loop blocks until a new line is ready (from standard input), then
   sends a message to the cluster. This is done by creating a new Message and
   calling Channel.send() with it as argument.

   The first argument of the Message constructor is the destination address. A
   null destination address sends the message to everyone in the cluster (a
   non-null address of an instance would send the message to only one instance).

   The second argument is our own address. This is null as well, as the stack
   will insert the correct address anyway.

   The third argument is the line that we read from stdin, this uses Java
   serialization to create a byte[] buffer and set the message’s payload. Note
   that we could also serialize the object ourselves (which is actually the
   recommended way !) and use the Message contructor which takes a byte[] buffer
   as third argument.
/**/

    private void eventLoop() {
        // BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        Scanner teclado = new Scanner(System.in);
        String line = "";

        boolean continua = true;
        while( continua ) {

            System.out.print("> "); System.out.flush();
            try {

               line=teclado.nextLine().toLowerCase();

               if(line.startsWith("quit") || line.startsWith("exit")){
                  continua = false;
               }
               else{
   		         line="[" + user_name + "] " + line;
   		         Message msg=new Message(null, null, line);
   		         channel.send(msg);
               }//else
            }
            catch(Exception e) {
            	//DO SOMETHING
            }

        }//while

    }//eventLoop

/*
The application is now fully functional, except that we don’t yet receive
messages or view notifications. This is done in the next section below.

2.4. Receiving messages and view change notifications

Let’s now register as a Receiver to receive message and view changes. To this
end, we could implement org.jgroups.Receiver, however, I chose to extend
ReceiverAdapter which has default implementations, and only override callbacks
(receive() and viewChange()) we’re interested in. We now need to extend
ReceiverAdapter:

public class HelloworldChat extends ReceiverAdapter {
, set the receiver in start()
, and implement receive() and viewAccepted():

/**/

    public void receive(Message msg) {
        System.out.println(msg.getSrc() + ": " + msg.getObject());
    }

    public void viewAccepted(View new_view) {
        System.out.println("\t\t[DEBUG] ** view: " + new_view);
    }

/*
The viewAccepted() callback is called whenever a new instance joins the
cluster, or an existing instance leaves (crashes included). Its toString()
method prints out the view ID (an increasing ID) and a list of the current
instances in the cluster

In receive(), we get a Message as argument. We simply get its buffer as an
object (again using Java serialization) and print it to stdout. We also print
the sender’s address (Message.getSrc()).

Note that we could also get the byte[] buffer (the payload) by calling
Message.getBuffer() and then de-serializing it ourselves, e.g. String line=new
String(msg.getBuffer()).
/**/


}//class
