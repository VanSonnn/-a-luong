package Đl;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Clock initialClock = new Clock(0); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
