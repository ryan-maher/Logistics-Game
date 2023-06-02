import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class loginWindow extends JFrame {
    Color colorBlue = new Color(140, 190, 220);
    Color colorOrange = new Color(226, 184, 0);
    DefaultListModel<String> userList = new DefaultListModel<>();
    JList<String> list;
    BufferedReader reader;
    userDataSaver dataSaver;
    Font font;
    Font subfont;
    Border border;
    String user;
    String filePath;
    String iconPath;
    osChecker OScheck;

    loginWindow() throws IOException {

        OScheck = new osChecker();

        if(OScheck.whichOS() == 1){
            filePath = "./users/userList.txt";
            iconPath = "./truckEmojiSmall.png";
        } else {
            filePath = "src/users/userList.txt";
            iconPath = "src/truckEmojiSmall.png";
        }

        list = new JList<>(userList);
        reader = new BufferedReader(new FileReader(filePath));
        dataSaver = new userDataSaver();
        font = new Font("Gill Sans MT", Font.BOLD, 25);
        subfont = new Font("Gill Sans MT", Font.BOLD, 20);
        border = BorderFactory.createLineBorder(colorOrange, 3, true);

        ImageIcon image = new ImageIcon(iconPath);
        setIconImage(image.getImage());
        setBackground(colorBlue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setTitle("Logistics Game Login");
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setVisible(true);

        // Gets users from userList file and adds them to JList list
        while((user = reader.readLine()) != null) {
            userList.addElement(user);
        }

        JLabel welcomeText = new JLabel();
        welcomeText.setText("Welcome! Log in or Register:");
        welcomeText.setFont(font);
        welcomeText.setForeground(colorOrange);
        welcomeText.setBounds(60, 20, 400, 40);
        add(welcomeText);

        JLabel whosPlaying = new JLabel();
        whosPlaying.setText("Who's playing?");
        whosPlaying.setFont(font);
        whosPlaying.setForeground(colorOrange);
        whosPlaying.setBounds(150, 100, 200, 40);
        add(whosPlaying);

        list.setBounds(160, 150, 150, 100);
        add(list);

        JButton play = new JButton();
        play.setText("Go");
        play.setBorder(border);
        play.setBounds(200, 280, 80, 30);
        play.setBorderPainted(true);
        play.setBackground(new Color(205, 205, 205));
        add(play);

        JLabel newUser = new JLabel();
        newUser.setText("New user? Enter your name:");
        newUser.setFont(subfont);
        newUser.setForeground(colorOrange);
        newUser.setBounds(110, 320, 300, 40);
        add(newUser);

        JPanel registration = new JPanel();
        registration.setBounds(120, 350, 250, 100);
        registration.setLayout(null);
        registration.setBackground(Color.gray);
        add(registration);

        JTextField userText = new JTextField();
        userText.setVisible(true);
        registration.add(userText);
        userText.setBounds(15, 15, 110, 20);

        JButton registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setBackground(new Color(205, 205, 205));
        registerButton.setVisible(true);
        registerButton.setBorder(border);
        registration.add(registerButton);
        registerButton.setBounds(140, 15, 80, 20);

        registerButton.addActionListener((e) -> {
            // Remove leading and trailing spaces of user input username
            String name = userText.getText().trim();

            if (!Objects.equals(name, "")) {
                dataSaver.createUser(name);
                userList.addElement(name);
            }

        });

        play.addActionListener((e) -> {
            String username = list.getSelectedValue();
            if (!list.isSelectionEmpty()) {

                // Load user data, start game, close login window
                dataSaver.loadData(username);
                gameWindow window = new gameWindow();
                dispose();

                window.addWindowListener(new WindowListener() {
                    public void windowOpened(WindowEvent e) {
                    }

                    public void windowClosing(WindowEvent e) {
                        // Save user data when game is closed
                        dataSaver.saveData(username);

                    }

                    public void windowClosed(WindowEvent e) {
                    }

                    public void windowIconified(WindowEvent e) {
                    }

                    public void windowDeiconified(WindowEvent e) {
                    }

                    public void windowActivated(WindowEvent e) {
                    }

                    public void windowDeactivated(WindowEvent e) {
                    }
                });
            }

        });
    }
}