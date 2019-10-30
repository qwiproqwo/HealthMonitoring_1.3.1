package app.my.healthmonitoring_131;

import java.time.LocalDateTime;
import java.util.Date;

public class Pressure {
    int highPresser;
    int lowPressure;
    int pulse;
    String tachycardia;
    String date;

    Pressure(int highPresser,
             int lowPressure,
             int pulse,
             String tachycardia,
             String date) {
        this.highPresser = highPresser;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }
}
