package com.sd.marcketplace.view.channel;

import java.util.Scanner;

import org.jgroups.JChannel;
import org.jgroups.Message;

import com.sd.marcketplace.view.receiver.ViewReceiver;

public class Chat {
    JChannel channel;
    String user_name=System.getProperty("user.name", "n/a");

    public void start() throws Exception {
        channel=new JChannel();
        channel.setReceiver(new ViewReceiver());
        channel.connect("ChatGroup");
           eventLoop();
        channel.close();
    }

    private void eventLoop() {
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
               }
            }
            catch(Exception e) {
            	//DO SOMETHING
            }
        }
        teclado.close();
    }

}
