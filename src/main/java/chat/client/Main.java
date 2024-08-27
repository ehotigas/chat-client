package chat.client;

import chat.client.socket.server.exception.SocketDisconnectException;
import chat.client.socket.server.listener.impl.MessageEventListener;
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
        
        adapter.addEventListener(new MessageEventListener(
            (String message, String clientId) -> { System.out.println(message); }
        ));

        while (true) {
            String message = scanner.nextLine();
            if (message.equals("exit")) break;
            adapter.emit(new SendMessageEvent(name + ": " + message));
        }
        
        try {
            Thread.sleep(2000);
            adapter.disconnect();
        } catch (InterruptedException | SocketDisconnectException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
