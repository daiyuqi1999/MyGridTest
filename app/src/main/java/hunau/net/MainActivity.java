package hunau.net;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private EditText pwd,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        InitEvent();
    }

    public void InitView(){
        pwd = findViewById(R.id.pwd);
        name  = findViewById(R.id.name);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }

    public  void InitEvent(){
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    pwd.setText("");
                    name.setText("");
                    break;
                case R.id.btn2:
                    Intent i = new Intent(MainActivity.this,ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", String.valueOf(name.getText()));
                    bundle.putString("pwd",String.valueOf(pwd.getText()));
                    i.putExtras(bundle);
                    startActivity(i);
                    break;

                default:
                    break;
            }
        }
    };
}
