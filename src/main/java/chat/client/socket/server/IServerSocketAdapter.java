package chat.client.socket.server;

import chat.client.socket.server.exception.SocketDisconnectException;
import chat.client.socket.server.listener.IListener;
import chat.client.socket.server.event.IServerEvent;

public interface IServerSocketAdapter {
    void connect();
    void disconnect() throws SocketDisconnectException;
    void emit(IServerEvent event);
    void addEventListener(IListener listener);
}
