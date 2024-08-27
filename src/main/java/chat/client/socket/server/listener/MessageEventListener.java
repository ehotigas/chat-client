package chat.client.socket.server.listener;

import java.util.function.BiConsumer;

public class MessageEventListener implements IListener {
    private final String eventName = "msgToClient";
    private BiConsumer<String, String> callback;

    public MessageEventListener(BiConsumer<String, String> callback) {
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
