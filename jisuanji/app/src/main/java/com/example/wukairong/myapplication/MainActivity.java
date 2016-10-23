package com.example.wukairong.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_point;//点
    Button button_and;//加
    Button button_minu;//减
    Button button_mult;//乘
    Button button_divi;//除
    Button button_equl;//等于
    Button button_del;//删除
    Button button_clea;//清空
    TextView et_input;//输入
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0=(Button)findViewById(R.id.button_0);
        button_1=(Button)findViewById(R.id.button_1);
        button_2=(Button)findViewById(R.id.button_2);
        button_3=(Button)findViewById(R.id.button_3);
        button_4=(Button)findViewById(R.id.button_4);
        button_5=(Button)findViewById(R.id.button_5);
        button_6=(Button)findViewById(R.id.button_6);
        button_7=(Button)findViewById(R.id.button_7);
        button_8=(Button)findViewById(R.id.button_8);
        button_9=(Button)findViewById(R.id.button_9);
        button_point=(Button)findViewById(R.id.button_point);
        button_and=(Button)findViewById(R.id.button_and);
        button_minu=(Button)findViewById(R.id.button_minu);
        button_mult=(Button)findViewById(R.id.button_mult);
        button_divi=(Button)findViewById(R.id.button_divi);
        button_del=(Button)findViewById(R.id.button_del);
        button_equl=(Button)findViewById(R.id.button_equl);
        button_clea=(Button)findViewById(R.id.button_clea);
        et_input=(TextView)findViewById(R.id.et_input);


        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_and.setOnClickListener(this);
        button_mult.setOnClickListener(this);
        button_minu.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_divi.setOnClickListener(this);
        button_clea.setOnClickListener(this);
        button_equl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String st = et_input.getText().toString();
        switch (v.getId()){
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.button_point:
                et_input.setText(st + ((Button) v).getText());
                break;
            case R.id.button_and:
            case R.id.button_minu:
            case R.id.button_mult:
            case R.id.button_divi:
                et_input.setText(st + " " + ((Button) v).getText() + " ");
                break;
            case R.id.button_del:
                if (st != null && !st.equals(" ")) {
                    et_input.setText(st.substring(0, st.length() - 1));
                }
                break;
            case R.id.button_clea:
                et_input.setText(" ");
                break;
            case R.id.button_equl:
                result();
                break;
        }

    }
    public void result(){
        String exp=et_input.getText().toString();
         if (exp==null||exp.equals(" ")){
            return;
        }else if (!exp.contains(" ")){
            return;
        }else if (exp.contains("..")||exp.contains(" +  + ")||exp.contains(" -  - ")||exp.contains(" ×  × ")||exp.contains(" ÷  ÷ ")){
            et_input.setText("错误");
         }
            double r = 0;
            String s1 = exp.substring(0, exp.indexOf(" "));
            String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
            String s2 = exp.substring(exp.indexOf(" ") + 3);
            double f1 = Double.parseDouble(s1);
            double f2 = Double.parseDouble(s2);
             if (op.equals("+")) {
                r = f1 + f2;
            } else if (op.equals("-")) {
                r = f1 - f2;
            } else if (op.equals("×")) {
                r = f1 * f2;
            } else if (op.equals("÷")) {
                if (f2 == 0) {
                    r = 0;
                } else {
                    r = f1 / f2;
                }
                if (!s1.equals(".") && !s2.equals(".")&&!op.equals("÷")) {
                    int t = (int) r;
                    et_input.setText(t + " ");
                } else {
                    et_input.setText(r + " ");
                }
            } else if (!s1.equals(" ") && s2.equals(" ")) {
                et_input.setText(exp);
            } else if (s1.equals(" ") && !s2.equals(" ")) {
                if (op.equals("+")) {
                    r = 0+f2;
                } else if (op.equals("-")) {
                    r = 0-f2;
                } else if (op.equals("×")) {
                    r = 0;
                } else if (op.equals("÷")) {
                    r = 0;
                }
                if (!s2.equals(".")) {
                    int t = (int) r;
                    et_input.setText(t + " ");
                } else {
                    et_input.setText(r + " ");
                }
            }else {
                et_input.setText(" ");
            }
                exp = Double.toString(r);
                et_input.setText(exp);
        }
}


