package app.my.healthmonitoring_131;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    List<Patient> patients = new ArrayList<>();
    String name;
    int age;
    private static final String TAG = "HEALTHAPP_MAIN";
    boolean isexception = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonPressure = findViewById(R.id.buttonPressure);
        Button buttonHealth = findViewById(R.id.buttonHealth);

        final TextView editName = findViewById(R.id.editName);
        final TextView editAge = findViewById(R.id.editAge);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editName.getText().toString();
                try {
                    age = Integer.valueOf(editAge.getText().toString());
                } catch (Exception exception) {
                    isexception = true;
                    if (BuildConfig.DEBUG) {
                        Log.i(TAG, String.format("Ошибка: %s. Возраст должен составлять целое число. Введите еще раз.", exception));
                    }
                }
                if (!isexception) {
                    patients.add(new Patient(name, age));
                    if (BuildConfig.DEBUG) {
                        Patient p = patients.get(patients.size() - 1);
                        Log.i(TAG, String.format("Сохранен пациент ФИО: %s, возраст: %s.", p.name, p.age));
                    }
                }
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        PressureActivity.class); //создание Intent
                startActivity(intent);
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "Нажата кнопка перехода на страницу ДАВЛЕНИЕ");
                }
            }
        });

        buttonHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        HealthActivity.class); //создание Intent
                startActivity(intent);
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "Нажата кнопка перехода на страницу ЗДОРОВЬЕ");
                }
            }
        });
    }
}
