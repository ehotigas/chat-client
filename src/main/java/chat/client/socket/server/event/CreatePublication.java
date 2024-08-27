package chat.client.socket.server.event;

public class CreatePublication implements IServerEvent {
    private String eventName = "novaPublicacao";

    @Override
    public Object getArgs() {
        return null;
    }

    @Override
    public String getEventName() {
        return eventName;
    }
    
}
