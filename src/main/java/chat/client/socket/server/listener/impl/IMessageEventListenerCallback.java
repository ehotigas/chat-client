package chat.client.socket.server.listener.impl;

@FunctionalInterface
public interface IMessageEventListenerCallback {
    void accept(String message, String clientId);
}
