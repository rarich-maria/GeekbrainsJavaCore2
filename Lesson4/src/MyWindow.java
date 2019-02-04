import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("My messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 500);
        setLayout(new BorderLayout());

        JPanel jp = new JPanel (new BorderLayout());

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jta.setBackground(new Color(238, 246, 255));
        //DefaultListModel<String> listModel = new DefaultListModel<>();
        //JList <String> list = new JList <>(listModel);

        //jta.setFont(new Font("Serif", Font.BOLD, 16)); //изменение стилей шрифта
        //jta.setWrapStyleWord(true);


        add(jsp, BorderLayout.CENTER);
        JTextField jtf = new JTextField();
        jp.add(jtf, BorderLayout.CENTER);
        JButton jbt = new JButton("Send");
        jbt.setBackground(new Color(169, 209, 233));
        jp.add(jbt, BorderLayout.EAST);
        add(jp, BorderLayout.SOUTH);
        jta.setLineWrap(true); //перевод строки
        jta.setEditable (false);// запрет ввода в тестовое поле

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!(jtf.getText().isEmpty())){
                jta.append(jtf.getText()+"\n\n");
                //listModel.add(listModel.size(), jtf.getText());
                //System.out.println("Your message: " + jtf.getText());
                jtf.setText("");
                }
            }
        });

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jtf.getText().isEmpty())){
                    jta.append(jtf.getText()+"\n\n");
                    //listModel.add(listModel.size(), jtf.getText());
                    //System.out.println("Your message: " + jtf.getText());
                    jtf.setText("");
                }
            }
        });



        setVisible(true);
    }
}


