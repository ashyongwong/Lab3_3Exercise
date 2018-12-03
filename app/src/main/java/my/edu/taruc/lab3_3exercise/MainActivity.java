package my.edu.taruc.lab3_3exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                         R.array.age_group,
                        android.R.layout.simple_spinner_item
                );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "position=" +position,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        float premium = 0;
        int ageGroup;
        int smoker = 0;
        ageGroup = spinnerAge.getSelectedItemPosition();
        if(ageGroup == 0){
            premium = 50;
        }if(ageGroup == 1){
            premium = 55;
        }if(ageGroup == 2){
            premium = 60;
        }if(ageGroup == 3){
            premium = 70;
        }if(ageGroup == 4){
            premium = 120;
        }if(ageGroup == 5){
            premium = 160;
        }if(ageGroup == 6){
            premium = 200;
        }if(ageGroup == 7){
            premium = 250;
        }

        int gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            if(ageGroup == 1){
                premium += 55;
            }else if(ageGroup == 2){
                premium += 50;
            }else if(ageGroup == 3){
                premium += 100;
            }else if(ageGroup == 4){
                premium += 100;
            }else if(ageGroup == 5){
                premium += 50;
            }else if(ageGroup == 6){
                premium += 200;
            }else if(ageGroup == 7){
                premium += 250;
            }
        }

        if(checkBoxSmoker.isChecked()){
            if(ageGroup == 1){
                smoker = 0;
            }else if(ageGroup == 2){
                smoker = 0;
            }else if(ageGroup == 3){
                smoker = 100;
            }else if(ageGroup == 4){
                smoker = 150;
            }else if(ageGroup == 5){
                smoker = 150;
            }else if(ageGroup == 6){
                smoker = 250;
            }else if(ageGroup == 7){
                smoker = 250;
            }
        }

        premium += smoker;
        textViewPremium.setText(getString(R.string.premium) + "=" + premium);
    }

    public void reset(View view){
        spinnerAge.setSelection(-1);
        radioButtonMale.setChecked(false);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(getString(R.string.premium));
    }
}
