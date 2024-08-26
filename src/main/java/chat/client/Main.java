package chat.client;

import chat.client.socket.server.exception.SocketDisconnectException;
import chat.client.socket.server.event.SendMessageEvent;
import chat.client.socket.server.ServerSocketAdapter;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o seu nome: ");
        String name = scanner.nextLine();

        ServerSocketAdapter adapter = new ServerSocketAdapter(name);
        adapter.connect();
        System.out.println("Olá " + name);
        adapter.emit(new SendMessageEvent("Olá"));
        
        try {
            adapter.disconnect();
        } catch (SocketDisconnectException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
