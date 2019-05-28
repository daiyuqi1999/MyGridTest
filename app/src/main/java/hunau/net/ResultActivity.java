package hunau.net;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import hunau.net.DBAdapter;
import hunau.net.Student;

import org.w3c.dom.Text;

public class ResultActivity extends Activity {
    private DBAdapter dbAdepter ;
    private TextView labelView;
    private String name,pwd;
    private TextView displayView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        displayView = findViewById(R.id.display);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pwd = intent.getStringExtra("pwd");

        labelView = findViewById(R.id.label);
        dbAdepter = new DBAdapter(this);
        dbAdepter.open();
        add();
        selet();
    }

    public void add(){
        Student student = new Student();
        student.setName(name);
        student.setPwd(pwd);
        student.setSexy("boy");
        student.setIsused("true");
        long colunm = dbAdepter.insert(student);
        if (colunm == -1 ){
            labelView.setText("添加过程错误！");
        } else {
            labelView.setText("成功添加数据，ID："+String.valueOf(colunm));

        }
    }
    public  void selet(){
        Student[] students = dbAdepter.queryAllData();
        if (students == null){
            labelView.setText("数据库中没有数据");
            return;
        }
        labelView.setText("数据库：");
        String msg = "";
        for (int i = 0 ; i<students.length; i++){
            msg += students[i].toString()+"\n";
        }
        displayView.setText(msg);
    }

    @Override
    protected void onDestroy() {
        dbAdepter.close();
        super.onDestroy();
    }
}
