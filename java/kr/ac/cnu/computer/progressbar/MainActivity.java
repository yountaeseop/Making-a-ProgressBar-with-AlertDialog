package kr.ac.cnu.computer.progressbar;

import android.app.AlertDialog;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<String> numberList = new ArrayList<>();
    ProgressBar progress;
    TextView expressionView;
    TextView inputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.progressBar);
        expressionView = findViewById(R.id.expressionView);
        inputView = findViewById(R.id.inputView);

        Button applyButton = (Button) findViewById(R.id.applyButton);
        Button Initialization_Button = (Button) findViewById(R.id.Initialization_Button);

        applyButton.setOnClickListener(this);
        Initialization_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.applyButton:
                EditText valueEditText = (EditText) findViewById(R.id.inputView);

                try {
                    // 문자열을 숫자로 변환.
                    int value = Integer.parseInt(valueEditText.getText().toString());
                    if (value < 0 || value > 100) {
                        Toast toast = Toast.makeText(MainActivity.this, "0 to 100 can be input.",
                                Toast.LENGTH_SHORT);
                        toast.show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("입력값 오류").setMessage("잘못된 값을 입력하였습니다. 0~100 사이의 값을 입력하십시오.");
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();


                    } else {
                        // 변환된 값을 프로그레스바에 적용.
                        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
                        progress.setProgress(value);
                        expressionView.setText(String.valueOf(value));
                    }
                } catch (Exception e) {
                    // 토스트(Toast) 메시지 표시.
                    Toast toast = Toast.makeText(MainActivity.this, "Invalid number format",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.Initialization_Button:
                expressionView.setText("0");
                progress.setProgress(0);
                break;
            default:
                break;
        }
    }
}









