package baykov.com;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class ClockFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    JLabel dateLabel;
    JLabel dayLabel;
    String time;
    String date;
    String day;

    public ClockFrame() throws HeadlessException {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // exit on close
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        // center alignment, 5 unit H and V gap
        this.setSize(400, 200);
        this.getContentPane().setBackground(Color.BLACK);
        // sets the background color to black
        this.setResizable(false);
        // can't resize the frame

        timeFormat = new SimpleDateFormat("K:mm:ss a z");
        // format 0:00:00 am zone
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        // 01 01 1996
        dayFormat = new SimpleDateFormat("EEEE");
        // Tuesday;Tue

        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColor = new Color(r, g, b);
        // sets red, green and blue color to random

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("MonoSpaced", Font.PLAIN, 40));
        timeLabel.setForeground(randomColor);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Dialog", Font.ITALIC,40));
        dateLabel.setForeground(randomColor);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Dialog", Font.ITALIC,40));
        dayLabel.setForeground(randomColor);

        this.add(timeLabel);
        this.add(dateLabel);
        this.add(dayLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            // while loop to update the time, date and day
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            try {
                Thread.sleep(1000);
                // time updates every 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
