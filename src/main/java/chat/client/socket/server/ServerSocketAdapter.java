package chat.client.socket.server;

import chat.client.socket.server.exception.SocketDisconnectException;
import chat.client.socket.server.listener.IListener;
import chat.client.socket.server.event.IServerEvent;
import java.net.URISyntaxException;
import io.socket.emitter.Emitter;
import io.socket.client.Socket;
import io.socket.client.IO;


public class ServerSocketAdapter implements IServerSocketAdapter {
    private String url = "http://localhost:3333";
    private Socket socket;
    private boolean isConnected = false;
    private String name;

    public ServerSocketAdapter(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        try {
            socket = IO.socket(url);
            socket.connect();
            isConnected = true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void disconnect() throws SocketDisconnectException {
        if (!isConnected) {
            throw new SocketDisconnectException("Nenhuma conexão encontrada");
        }
        socket.disconnect();
        socket.close();
        isConnected = false;
    }

    @Override
    public void emit(IServerEvent event) {
        System.out.println(event.getEventName() + " " + (String) event.getArgs());
        socket.emit(event.getEventName(), event.getArgs());
    }

    @Override
    public void addEventListener(IListener listener) {
        socket.on(listener.getEventName(), new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                listener.callback(args);;
            }
        });
    }

    public String getUrl() {
        return url;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getName() {
        return name;
    }
}
