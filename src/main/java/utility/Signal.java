package utility;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Signal<T> {
    private final ArrayList<Connection<T>> connections = new ArrayList<>();

    public Connection<T> connect(Consumer<T> listener) {
       return connect(listener, Connection.FLAG.CONNECT);
    }

    public Connection<T> connect(Consumer<T> listener, Connection.FLAG flag) {
        Connection<T> c = new Connection<>(listener, flag);
        connections.add(c);
        return c;
    }

    public void disconnect(Consumer<T> listener) {
        connections.removeIf(c -> c.method.equals(listener));
    }

     public void disconnect(Connection<T> connection) {
        connections.remove(connection);
    }

    public void emit(T payload) {
        for (Connection<T> c : new ArrayList<>(connections)) {
            if (c.flag == Connection.FLAG.CONNECT_ONE_SHOT) {
                if (!connections.remove(c)) continue;
            }
            c.method.accept(payload);
        }
    }
}

class Connection<T> {
    public enum FLAG {
        CONNECT_ONE_SHOT,
        CONNECT
    }

    final Consumer<T> method;
    final FLAG flag;

    Connection(Consumer<T> method, FLAG flag) {
        this.method = method;
        this.flag = flag;
    }
}
