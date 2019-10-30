package app.my.healthmonitoring_131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HealthActivity extends AppCompatActivity {
    float weigh;
    int steps;
    private static final String TAG = "HEALTHAPP_HEALTH";
    Boolean isexception = false;

    List<Health> healthList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        Button saveButton = findViewById(R.id.buttonSave);
        final TextView editWeigh = findViewById(R.id.editWeigh);
        final TextView editSteps = findViewById(R.id.editSteps);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    weigh = Float.valueOf(editWeigh.getText().toString());
                } catch (Exception exception) {
                    if (BuildConfig.DEBUG) {
                        isexception = true;
                        Log.i(TAG, String.format("Ошибка: %s. Вес должен составлять дробное число. Введите еще раз.", exception));
                    }
                }

                try {
                    steps = Integer.valueOf(editSteps.getText().toString());
                } catch (Exception exception) {
                    if (BuildConfig.DEBUG) {
                        isexception = true;
                        Log.i(TAG, String.format("Ошибка: %s. Шаги должны составлять целое число. Введите еще раз.", exception));
                    }
                }

                if (!isexception) {
                    healthList.add(new Health(weigh, steps));
                    if (BuildConfig.DEBUG) {
                        Health h = healthList.get(healthList.size() - 1);
                        Log.i(TAG, String.format("Сохранены данные здоровья пациента, вес: %s, шаги: %s.", h.weigh, h.steps));
                    }
                }
            }
        });
    }
}
