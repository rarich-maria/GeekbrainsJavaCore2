
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientHandler {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (.+) (.+)$");
    private final Thread handleThread;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final ChatServer server;
    private final String username;
    private final Socket socket;

    public ClientHandler(String username, Socket socket, ChatServer server) throws IOException {
        this.username = username;
        this.socket = socket;
        this.server = server;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", username, msg);
                        Matcher matcher = MESSAGE_PATTERN.matcher(msg);
                        if (matcher.matches()) {

                            String [] arrMsg = msg.split("\\s", 3);
                            String forUsername = arrMsg[1];
                            String msgForUsername = arrMsg[2];
                           // String forUsername = matcher.group(1);
                            //String msgForUsername = matcher.group(2);
                            server.sendPrivateMessage(username, forUsername, msgForUsername);
                        }else if (!msg.isEmpty()) {
                            server.sendOpenMessage(username, msg);
                        }

                        // TODO реализовать прием сообщений от клиента и пересылку адресату через сервер
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("Client %s disconnected%n", username);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        handleThread.start();
    }

    public DataOutputStream getOut() {
        return out;
    }
}
