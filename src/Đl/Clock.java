package Đl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {
    private int timezoneOffset;

    public Clock(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        start();
    }

    private void start() {
        JFrame frame = new ClockFrame(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(() -> {
            while (true) {
                updateTime(frame);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private synchronized void updateTime(JFrame frame) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, timezoneOffset); // Thêm múi giờ

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = calendar.getTime();

        SwingUtilities.invokeLater(() -> ((ClockFrame) frame).updateTime(dateFormat.format(currentTime)));
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }
}
