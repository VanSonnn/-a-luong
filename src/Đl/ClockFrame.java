package Đl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockFrame extends JFrame {
    private JLabel timeLabel;
    private JTextField timezoneField;
    private JButton createClockButton;
    private Clock clock;

    public ClockFrame(Clock clock) {
        this.clock = clock;
        setSize(300, 200);
        setTitle("Clock");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        timeLabel = new JLabel();
        panel.add(timeLabel);

        timezoneField = new JTextField(5);
        panel.add(timezoneField);

        createClockButton = new JButton("Create Clock");
        createClockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewClock();
            }
        });
        panel.add(createClockButton);

        setContentPane(panel);
    }

    public void updateTime(String time) {
        timeLabel.setText(time);
    }

    private void createNewClock() {
        String input = timezoneField.getText();
        try {
            int timezone = Integer.parseInt(input);
            Clock newClock = new Clock(timezone);
            newClock.setTimezoneOffset(-timezone); // Chuyển về dạng âm
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number.");
        }
    }
}
