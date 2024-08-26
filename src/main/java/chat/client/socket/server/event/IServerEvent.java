package chat.client.socket.server.event;

public interface IServerEvent {
    String getEventName();
    Object getArgs();
}
