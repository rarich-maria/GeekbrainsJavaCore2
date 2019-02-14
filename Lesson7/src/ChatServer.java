
import auth.AuthService;
import auth.AuthServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatServer {

    private static final Pattern AUTH_PATTERN = Pattern.compile("^/auth (.+) (.+)$");

    private AuthService authService = new AuthServiceImpl();

    private Map<String, ClientHandler> clientHandlerMap = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(7777);
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream inp = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("New client connected!");

                try {
                    String authMessage = inp.readUTF();
                    Matcher matcher = AUTH_PATTERN.matcher(authMessage);
                    if (matcher.matches()) {
                        String username = matcher.group(1);
                        String password = matcher.group(2);
                        if (authService.authUser(username, password)) {
                            clientHandlerMap.put(username, new ClientHandler(username, socket, this));
                            out.writeUTF("/auth successful");
                            out.flush();
                            System.out.printf("Authorization for user %s successful%n", username);
                        } else {
                            System.out.printf("Authorization for user %s failed%n", username);
                            out.writeUTF("/auth fails");
                            out.flush();
                            socket.close();
                        }
                    } else {
                        System.out.printf("Incorrect authorization message %s%n", authMessage);
                        out.writeUTF("/auth fails");
                        out.flush();
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO реализовать отправку сообщения пользователю с именем username

    public void sendPrivateMessage(String fromUsername, String forUsername, String msg) throws IOException {

        if (clientHandlerMap.keySet().contains(forUsername)) {
            //clientHandlerMap.get(forUsername).getOut().writeUTF("/str" + " " + fromUsername + " " + msg);
            clientHandlerMap.get(forUsername).getOut().writeUTF(fromUsername + " " + msg);
            clientHandlerMap.get(forUsername).getOut().flush();
            System.out.println(fromUsername + " " + msg);
        }else {
            clientHandlerMap.get(fromUsername).getOut().writeUTF("Server Пользовать с таким именем не подключен или не существует" );
            clientHandlerMap.get(fromUsername).getOut().flush();
            System.out.println("Пользователя с таким именем не существует");
        }
    }

    public void sendOpenMessage (String fromUsername, String msg) throws IOException {
        for (String o : clientHandlerMap.keySet()) {
            if (o!=fromUsername) {
                //clientHandlerMap.get(o).getOut().writeUTF("/str" + " " + fromUsername + " " + msg);
                clientHandlerMap.get(o).getOut().writeUTF( fromUsername + " " + msg);
                clientHandlerMap.get(o).getOut().flush();
                System.out.println(fromUsername + " " + msg);
            }
            
        }
        
    }
}
