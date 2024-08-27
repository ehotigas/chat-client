package chat.client.socket.server.listener.impl;

import chat.client.socket.server.listener.IListener;

public class MessageEventListener implements IListener {
    private final String eventName = "msgToClient";
    private IMessageEventListenerCallback callback;

    public MessageEventListener(IMessageEventListenerCallback callback) {
        this.callback = callback;
    }

    @Override
    public void callback(Object... args) {
        String message = (String) args[0];
        String clientId = (String) args[1];
        this.callback.accept(message, clientId);
    }

    @Override
    public String getEventName() {
        return eventName;
    }
}
