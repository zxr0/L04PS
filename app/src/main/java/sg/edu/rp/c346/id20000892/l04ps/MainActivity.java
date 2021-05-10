package sg.edu.rp.c346.id20000892.l04ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText group;
    TimePicker timePicker;
    DatePicker datePicker;
    CheckBox smoke;
    Button confirm;
    Button reset;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        number = findViewById(R.id.phone);
        group = findViewById(R.id.group);
        timePicker = findViewById(R.id.timePicker);
        datePicker = findViewById(R.id.datePicker);
        smoke = findViewById(R.id.smoke);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);

        timePicker.setCurrentHour(19);
        timePicker.setCurrentMinute(30);
        datePicker.updateDate(2020,0,1);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                int hour = timePicker.getCurrentHour();
                if (hour > 20 || hour < 7){
                    timePicker.setCurrentHour(20);
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr = name.getText().toString();
                String numerstr = number.getText().toString();
                String groupstr = group.getText().toString();

                if (!namestr.isEmpty() && !numerstr.isEmpty() && !groupstr.isEmpty()) {
                    if (smoke.isChecked()) {
                    Toast.makeText(MainActivity.this, "Name: " + name.getText() + '\n'
                                    + "Phone number: " + number.getText() + '\n'
                                    + "Group number:" + group.getText() + '\n'
                                    + "Date: " + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear() + '\n'
                                    + "Time: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute() + '\n'
                                    + "Smoking Area"
                            , Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Name: " + name.getText() + '\n'
                                    + "Phone number: " + number.getText() + '\n'
                                    + "Group number:" + group.getText() + '\n'
                                    + "Date: " + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear() + '\n'
                                    + "Time: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute() + '\n'
                                    + "Non Smoking Area"
                            , Toast.LENGTH_SHORT).show();
                }

                } else {
                    Toast.makeText(MainActivity.this, "Fields are blank!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                group.setText("");
                smoke.setChecked(false);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);
                datePicker.updateDate(2020,0,1);
            }
        });

    }
}