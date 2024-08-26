package chat.client.socket.server.event;

public class SendMessageEvent implements IServerEvent {
    private String eventName = "msgToServer";
    private String message;

    public SendMessageEvent(String message) {
        this.message = message;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public Object getArgs() {
        return message;
    }
}
