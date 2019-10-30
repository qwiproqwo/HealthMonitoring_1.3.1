package app.my.healthmonitoring_131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PressureActivity extends AppCompatActivity {
    int highPressure;
    int lowPressure;
    int pulse;
    String tachycardia;
    String date;
    private static final String TAG = "HEALTHAPP_PRESSURE";
    boolean isexception = false;

    List<Pressure> pressureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        Button buttonSave = findViewById(R.id.buttonSave);
        final TextView editHighPressure = findViewById(R.id.editPressureHigh);
        final TextView editLowPressure = findViewById(R.id.editPressureLow);
        final TextView editPulse = findViewById(R.id.editPulse);
        final TextView editTachycardia = findViewById(R.id.editTachycardia);
        final TextView editDate = findViewById(R.id.editDate);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    highPressure = Integer.valueOf(editHighPressure.getText().toString());
                } catch (Exception exception) {
                    isexception = true;
                    if (BuildConfig.DEBUG) {
                        Log.i(TAG, String.format("Ошибка: %s. Верхнее давление должно составлять целое число. Введите еще раз.", exception));
                    }
                }

                try {
                    lowPressure = Integer.valueOf(editLowPressure.getText().toString());
                } catch (Exception exception) {
                    isexception = true;
                    if (BuildConfig.DEBUG) {
                        Log.i(TAG, String.format("Ошибка: %s. Нижнее давление должно составлять целое число. Введите еще раз.", exception));
                    }
                }

                try {
                    pulse = Integer.valueOf(editPulse.getText().toString());
                } catch (Exception exception) {
                    isexception = true;
                    if (BuildConfig.DEBUG) {
                        Log.i(TAG, String.format("Ошибка: %s. Пульс должен составлять целое число. Введите еще раз.", exception));
                    }
                }

                try {
                    tachycardia = editTachycardia.getText().toString();
                    if (!tachycardia.equals("да") && !tachycardia.equals("нет")) {
                        throw new Exception("Ответ должен быть \"да\" или \"нет\"");
                    }
                } catch (Exception exception) {
                    isexception = true;
                    if (BuildConfig.DEBUG) {
                        Log.i(TAG, String.format("Ошибка: %s.", exception));
                    }
                }

                if (!isexception) {
                    pressureList.add(new Pressure(highPressure, lowPressure, pulse, tachycardia, date));
                    if (BuildConfig.DEBUG) {
                        Pressure p = pressureList.get(pressureList.size() - 1);
                        Log.i(TAG, String.format("Сохранены данные давления пациента, верхнее: %s, нижнее: %s, пульс: %s, тахикардия: %s, дата замера: %s.", p.highPresser, p.lowPressure, p.pulse, p.tachycardia, p.date));
                    }
                }
            }
        });
    }
}
