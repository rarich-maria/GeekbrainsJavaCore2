import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEho1 {

    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket sock = null;
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {

                                Scanner serverMsg = new Scanner(System.in);
                                System.out.println("Введите сообщение:");
                                String strServer = serverMsg.nextLine();
                                pw.println("Сервер:" + strServer);
                                pw.flush();

                        }
                    } catch (Exception e) {
                    }
                }
            }).start();

            while (true) {
                String str = sc.nextLine();
                if (!str.equals("end")){
                    pw.println("Пользователь: " + str);
                    pw.flush();}
                else {break;}

            }





        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
