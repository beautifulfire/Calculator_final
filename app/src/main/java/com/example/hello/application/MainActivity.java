package com.example.hello.application;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener {
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;
    private Button bt13;
    private Button bt14;
    private Button bt15;
    private Button bt16;
    private Button bt17;
    private Button bt18;
    private Button bt19;
    private Button bt20;
    private Button bt21;
    private Button bt22;
    private Button bt23;
    private Button bt24;
    private Button bt25;
    private Button bt26;
    private Button bt27;
    private Button bt28;
    private Button bt29;
    private Button bt30;
    private Button bt31;

    private EditText text;
    private TextView tResult;

    private float[] nNumber= new float[200]; //存储输入的数字
    private int nBrackets = 0;  //括号
    private String[] nSymbol = new String[200]; //存储输入的运算符
    private int nSpSymbol = 0;  //乘号与除号
    private int nN=0;    // 存储的数字的编号
    private int nS=0;   //存储的运算符的编号
    private float number=0;   //存储当前输入的数字
    private int dp=0;   //判断当前数字是否输入了小数点
    private float dps=1;  //小数点后几位
    private float result=0; //存储当前结果
    private int lastSymbol=1;   //显示上一位是否为运算符
    private int lastequal=0;

    private int lastsin1=0; //显示上一位是否为sin
    private int lastsin2=0;  //显示此数中是否包含sin
    private int lastcos1=0; //显示上一位是否为cos
    private int lastcos2=0;  //显示此数中是否包含cos
    private int lasttan1=0; //显示上一位是否为tan
    private int lasttan2=0;  //显示此数中是否包含tan
    private int lastlin1=0; //显示上一位是否为lin
    private int lastlin2=0;  //显示此数中是否包含lin
    private int lastlg1=0; //显示上一位是否为lg
    private int lastlg2=0;   //显示此数中是否包含lg

    //private int numdigit=0; //存储当前输入的数字的位数
    //private int symbol=0;   //显示当前是否输入了运算符
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText3);
        tResult = (TextView) findViewById(R.id.textView);

        bt1 = (Button) findViewById(R.id.button1);
        // 响应按钮C事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                nSpSymbol=0;
                nBrackets=0;
                nN=0;
                nS=0;
                number=0;
                dp=0;
                dps=1;
                lastSymbol=1;
                result=0;
                lastsin1=0;
                lastsin1=0;
                lastcos1=0;
                lastcos2=0;
                lasttan1=0;
                lasttan2=0;
                lastlin1=0;
                lastlin2=0;
                lastlg1=0;
                lastlg2=0;
            }
        });

        bt2 = (Button) findViewById(R.id.button2);
        // 响应按钮←事件
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt3 = (Button) findViewById(R.id.button3);
        // 响应按钮( )事件
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt4 = (Button) findViewById(R.id.button4);
        // 响应按钮%事件
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt5 = (Button) findViewById(R.id.button5);
        // 响应按钮π事件
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt6 = (Button) findViewById(R.id.button6);
        // 响应按钮sin事件
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("sin");
                    lastsin1=1;
                    lastsin2=1;
                    lastequal=0;
                }else{
                    if (lastSymbol == 1){
                        text.setText(text.getText().toString()+"sin");
                        lastsin1=1;
                        lastsin2=1;
                    }
                }
            }
        });

        bt7 = (Button) findViewById(R.id.button7);
        // 响应按钮√X事件
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt8 = (Button) findViewById(R.id.button8);
        // 响应按钮x²事件
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt9 = (Button) findViewById(R.id.button9);
        // 响应按钮x^y事件
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt10 = (Button) findViewById(R.id.button10);
        // 响应按钮/事件
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    nSpSymbol = 1;
                    int b=(int)result;
                    if(result-b==0) {
                        text.setText("" + b + "/");
                    }
                    else{
                        text.setText(""+result+"/");
                    }
                    nNumber[nN]=result;
                    nSymbol[nS]="/";
                    nN++;
                    nS++;
                    lastSymbol=1;
                    lastequal=0;
                }else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        nSpSymbol = 1;
                        if(lastsin2==1){
                            if(lastsin1==0){
                                double c = (double) number;
                                c = Math.sin(c);
                                float d= (float) c;
                                nNumber[nN] = d;
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                                lastsin2=0;
                            }
                            else{
                                text.setText(text.getText().toString());
                            }
                        }
                        else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "/";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "/");
                        }
                    }
                }
                lastsin1=0;
                lastsin2=0;
            }
        });

        bt11 = (Button) findViewById(R.id.button11);
        // 响应按钮cos事件
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt12 = (Button) findViewById(R.id.button12);
        // 响应按钮7事件
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("7");
                    number=7;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 7;
                        text.setText(text.getText().toString() + "7");
                    } else {
                        dps = dps * 10;
                        number = number + 7 / dps;
                        text.setText(text.getText().toString() + "7");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt13 = (Button) findViewById(R.id.button13);
        // 响应按钮8事件
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("8");
                    number=8;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 8;
                        text.setText(text.getText().toString() + "8");
                    } else {
                        dps = dps * 10;
                        number = number + 8 / dps;
                        text.setText(text.getText().toString() + "8");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt14 = (Button) findViewById(R.id.button14);
        // 响应按钮9事件
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("9");
                    number=9;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 9;
                        text.setText(text.getText().toString() + "9");
                    } else {
                        dps = dps * 10;
                        number = number + 9 / dps;
                        text.setText(text.getText().toString() + "9");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt15 = (Button) findViewById(R.id.button15);
        // 响应按钮*事件
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    nSpSymbol = 1;
                    int b=(int)result;
                    if(result-b==0) {
                        text.setText("" + b + "*");
                    }
                    else{
                        text.setText(""+result+"*");
                    }
                    nNumber[nN]=result;
                    nSymbol[nS]="*";
                    nN++;
                    nS++;
                    lastSymbol=1;
                    lastequal=0;
                }else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        nSpSymbol = 1;
                        if(lastsin2==1){
                            if(lastsin1==0) {
                                double c = (double) number;
                                c = Math.sin(c);
                                float d = (float) c;
                                nNumber[nN] = d;
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            }else {
                                text.setText(text.getText().toString());
                            }
                        }
                        else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "*";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "*");
                        }
                    }
                }
                lastsin1=0;
                lastsin2=0;
            }
        });

        bt16 = (Button) findViewById(R.id.button16);
        // 响应按钮tan事件
        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt17 = (Button) findViewById(R.id.button17);
        // 响应按钮4事件
        bt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("4");
                    number=4;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 4;
                        text.setText(text.getText().toString() + "4");
                    } else {
                        dps = dps * 10;
                        number = number + 4 / dps;
                        text.setText(text.getText().toString() + "4");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt18 = (Button) findViewById(R.id.button18);
        // 响应按钮5事件
        bt18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("5");
                    number=5;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 5;
                        text.setText(text.getText().toString() + "5");
                    } else {
                        dps = dps * 10;
                        number = number + 5 / dps;
                        text.setText(text.getText().toString() + "5");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt19 = (Button) findViewById(R.id.button19);
        // 响应按钮6事件
        bt19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("6");
                    number=6;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 6;
                        text.setText(text.getText().toString() + "6");
                    } else {
                        dps = dps * 10;
                        number = number + 6 / dps;
                        text.setText(text.getText().toString() + "6");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt20 = (Button) findViewById(R.id.button20);
        // 响应按钮-事件
        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    int b=(int)result;
                    if(result-b==0) {
                        text.setText("" + b + "-");
                    }
                    else{
                        text.setText(""+result+"-");
                    }
                    nNumber[nN]=result;
                    nSymbol[nS]="-";
                    nN++;
                    nS++;
                    lastSymbol=1;
                    lastequal=0;
                }else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        if(lastsin2==1){
                            if(lastsin1==0) {
                                double c = (double) number;
                                c = Math.sin(c);
                                float d = (float) c;
                                nNumber[nN] = d;
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            }else {
                                text.setText(text.getText().toString());
                            }
                        }
                        else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "-";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "-");
                        }
                    }
                }
                lastsin1=0;
                lastsin2=0;
            }
        });

        bt21 = (Button) findViewById(R.id.button21);
        // 响应按钮ln事件
        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt22 = (Button) findViewById(R.id.button22);
        // 响应按钮1事件
        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("1");
                    number=1;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 1;
                        text.setText(text.getText().toString() + "1");
                    } else {
                        dps = dps * 10;
                        number = number + 1 / dps;
                        text.setText(text.getText().toString() + "1");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt23 = (Button) findViewById(R.id.button23);
        // 响应按钮2事件
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("2");
                    number=2;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 2;
                        text.setText(text.getText().toString() + "2");
                    } else {
                        dps = dps * 10;
                        number = number + 2 / dps;
                        text.setText(text.getText().toString() + "2");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt24 = (Button) findViewById(R.id.button24);
        // 响应按钮3事件
        bt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    text.setText("3");
                    number=3;
                    lastequal=0;
                }
                else {
                    if (dp == 0) {
                        number = number * 10 + 3;
                        text.setText(text.getText().toString() + "3");
                    } else {
                        dps = dps * 10;
                        number = number + 3 / dps;
                        text.setText(text.getText().toString() + "3");
                    }
                    lastSymbol = 0;
                }
                lastsin1=0;
            }
        });

        bt25 = (Button) findViewById(R.id.button25);
        // 响应按钮+事件
        bt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastequal==1){
                    int b=(int)result;
                    if(result-b==0) {
                        text.setText("" + b + "+");
                    }
                    else{
                        text.setText(""+result+"+");
                    }
                    nNumber[nN]=result;
                    nSymbol[nS]="+";
                    nN++;
                    nS++;
                    lastSymbol=1;
                    lastequal=0;
                }else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        if(lastsin2==1){
                            if(lastsin1==0) {
                                double c = (double) number;
                                c = Math.sin(c);
                                float d = (float) c;
                                nNumber[nN] = d;
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            }else {
                                text.setText(text.getText().toString());
                            }
                        }
                        else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "+";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "+");
                        }
                    }
                }
                lastsin1=0;
                lastsin2=0;
            }
        });

        bt26 = (Button) findViewById(R.id.button26);
        // 响应按钮lg事件
        bt26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt27 = (Button) findViewById(R.id.button27);
        // 响应按钮e事件
        bt27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt28 = (Button) findViewById(R.id.button28);
        // 响应按钮0事件
        bt28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dp==0) {
                    number = number * 10 + 0;
                    text.setText(text.getText().toString()+"0");
                }
                else{
                    for(int j=1;j<=dp;j++){
                        dps=dps*10;
                    }
                    number = number + 0/dps;
                    dp++;
                }
                lastsin1=0;
            }
        });

        bt29 = (Button) findViewById(R.id.button29);
        // 响应按钮.事件
        bt29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp=1;
                if(lastequal==1){
                    text.setText("");
                }else {
                    if(lastSymbol==1){
                        text.setText(text.getText().toString());
                    }else {
                        if (lastsin1 == 1) {
                            text.setText(text.getText().toString());
                        } else {
                            text.setText(text.getText().toString() + ".");
                        }
                    }
                }
            }
        });

        bt30 = (Button) findViewById(R.id.button30);
        // 响应按钮=事件
        bt30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastsin1==1){
                    text.setText(text.getText().toString());
                }else if(lastequal==1){
                    tResult.setText(""+result);
                }
                else {
                    lastequal=1;
                        if (nS == 0) {
                            if(lastsin2==1){
                                double c = (double) number;
                                c = Math.sin(c);
                                float d = (float) c;
                                result = d;
                            }else {
                                result = number;
                            }
                        } else {
                            result = nNumber[0];
                        }
                    nNumber[nN]=number;
                    if (nSpSymbol == 0) {
                        for (int i = 0; i < nN; i++) {
                            if (nSymbol[i] == "+") {
                                result = result + nNumber[i + 1];
                            } else if (nSymbol[i] == "-") {
                                result = result - nNumber[i + 1];
                            }
                        }
                    } else {
                        for (int i = 0; i < nN; i++) {
                            if (nSymbol[i] == "+") {
                                if (nSymbol[i + 1] == "*") {
                                    result = result + nNumber[i + 1] * nNumber[i + 2];
                                    i++;
                                } else if (nSymbol[i + 1] == "/") {
                                    result = result + nNumber[i + 1] / nNumber[i + 2];
                                    i++;
                                } else {
                                    result = result + nNumber[i + 1];
                                }
                            } else if (nSymbol[i] == "-") {
                                if (nSymbol[i + 1] == "*") {
                                    result = result - nNumber[i + 1] * nNumber[i + 2];
                                    i++;
                                } else if (nSymbol[i + 1] == "/") {
                                    result = result - nNumber[i + 1] / nNumber[i + 2];
                                    i++;
                                } else {
                                    result = result - nNumber[i + 1];
                                }
                            } else if (nSymbol[i] == "*") {
                                result = result * nNumber[i + 1];
                            } else if (nSymbol[i] == "/") {
                                result = result / nNumber[i + 1];
                            }
                        }
                    }
                    int a = (int) result;
                    if (result - a == 0) {
                        tResult.setText("" + a);
                    } else {
                        tResult.setText("" + result);
                    }
                    nSpSymbol = 0;
                    nBrackets = 0;
                    nN = 0;
                    nS = 0;
                    number = 0;
                    dp = 0;
                    dps = 1;
                }
            }
        });

        bt31 = (Button)findViewById(R.id.button31);
        bt31.setOnClickListener(this);
    }

    //点击按钮后，加载弹出式菜单
    @Override
    public void onClick(View v) {
        //创建弹出式菜单对象（最低版本11）
        PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
        //获取菜单填充器
        MenuInflater inflater = popup.getMenuInflater();
        //填充菜单
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        //绑定菜单项的点击事件
        popup.setOnMenuItemClickListener(this);
        //显示(这一行代码不要忘记了)
        popup.show();

    }

    //退出提示
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void onclick1(){
        Intent it = new Intent();
        //设置Intent的Action属性
        it.setAction("android.intent.action.DECIMAL");
        // 启动Activity
        startActivity(it);
    }

    //弹出式菜单的单击事件处理
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.decimal_conversion:
                onclick1();
                break;
            case R.id.Unit_conversion:
                setContentView(R.layout.unit_conversion);
                break;
            case R.id.help:
                Toast.makeText(this, "这是帮助", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                dialog();
                break;
            default:
                break;
        }
        return false;
    }
}
