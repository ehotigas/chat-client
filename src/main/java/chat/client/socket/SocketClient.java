package chat.client.socket;

import chat.client.socket.server.IServerSocketAdapter;

public class SocketClient {
    private String name;
    private IServerSocketAdapter socketAdapter;

    public SocketClient(
        String name,
        IServerSocketAdapter socketAdapter
    ) {
        this.name = name;
        this.socketAdapter = socketAdapter;
    }

    public String getName() {
        return name;
    }

    public IServerSocketAdapter getSocketAdapter() {
        return socketAdapter;
    }
}
