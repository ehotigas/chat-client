package chat.client.socket.server.listener;

public interface IListener {
    String getEventName();
    void callback(Object... args);
}
