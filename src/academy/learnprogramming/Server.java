package academy.learnprogramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {
    public void run() throws IOException {
        System.out.println("Server running...");
        ServerSocket server = new ServerSocket(8081);
        Map<String,String> listPouzivatelov = new HashMap();
        Map<String,Socket> listpomocny= new HashMap<>();
        while(true) {
            Socket soc = server.accept();
            System.out.println("Connection with client completed");

            String adresa = soc.getInetAddress().getHostAddress();
            if(!(listPouzivatelov.containsKey(adresa))){
                int velkost = listPouzivatelov.size()+1;
                String nazov = "Client" + velkost;
                System.out.println(nazov);
                listPouzivatelov.put(adresa,nazov);
                listpomocny.put(nazov,soc);
            }


            Scanner komOdKlienta = new Scanner(soc.getInputStream());
            String nClient = komOdKlienta.nextLine();
            //listPouzivatelov.add
            String textKomunikacie = komOdKlienta.nextLine();

            sendTextClient(soc,"Spojenie prebehlo uspesne");

            if(listPouzivatelov.containsValue(nClient)){

            }

            System.out.println(nClient+""+textKomunikacie);



        }
    }


    public void sendTextClient(Socket soc,String text) throws IOException{
        PrintWriter komsKlientom = new PrintWriter(soc.getOutputStream(), true);
        komsKlientom.println(text);
    }
}
