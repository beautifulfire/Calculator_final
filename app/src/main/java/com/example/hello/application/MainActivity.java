package com.example.hello.application;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
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

    private double[] nNumber = new double[200]; //存储输入的总数字
    //private double[] nNumbers= new double[100]; //存储括号内输入的数字
    private String[] nSymbol = new String[200]; //存储输入的运算符
    private int nSpSymbol = 0;  //乘号与除号
    private int nN = 0;    // 存储的数字的编号
    private int nS = 0;   //存储的运算符的编号
    private double number = 0;   //存储当前输入的数字
    private int dp = 0;   //判断当前数字是否输入了小数点
    private double dps = 1;  //小数点后几位
    private double result = 0; //存储当前结果
    private int lastSymbol = 1;   //显示上一位是否为运算符
    private int lastequal = 0;    //是否输入了等号

    private int lastlfBracket = 0;    //显示上一位是否为左括号
    private int lastriBracket = 0;    //显示上一位是否为右括号
    private int nBracket = 0;  //输入了几组括号
    private int[] lfbrpl = new int[100];   //输入了多少个左括号
    private int nl = 0;   //储存的左括号的编号
    private int[] ribrpl = new int[100];   //应该输入多少个右括号
    private int nr = 0;   //储存的右括号的编号
    private int norBrackets = 0;  //是否可以输入右括号
    private double result1 = 0;   //用于储存括号内计算结果

    private int lastsin1 = 0; //显示上一位是否为sin
    private int lastsin2 = 0;  //显示此数中是否包含sin
    private int lastcos1 = 0; //显示上一位是否为cos
    private int lastcos2 = 0;  //显示此数中是否包含cos
    private int lasttan1 = 0; //显示上一位是否为tan
    private int lasttan2 = 0;  //显示此数中是否包含tan
    private int lastln1 = 0; //显示上一位是否为lin
    private int lastln2 = 0;  //显示此数中是否包含lin
    private int lastlg1 = 0; //显示上一位是否为lg
    private int lastlg2 = 0;   //显示此数中是否包含lg
    private int lastsqrt1 = 0;    //显示上一位是否为√
    private int lastsqrt2 = 0;    //显示此数中是否包含√
    private int lastsquare1 = 0;  //显示上一位是否为²
    private int lastsquare2 = 0;  //显示此数中是否包含²
    private int lastpower1 = 0;   //显示上位是否为^
    private int lastpower2 = 0;   //显示此数中是否包含^
    private double power1 = 0;    //幂次方的底数
    private double power2 = 0;    //幂次方的指数
    private int lastpi = 0;
    private int laste = 0;
    //private int lastsqrt=0; //显示上一位是否为数字
    //private int nSqrt=0;    //标记此数中有多少个根号

    //private float z,x,m;
    //private int numdigit=0; //存储当前输入的数字的位数
    //private int symbol=0;   //显示当前是否输入了运算符
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText5);
        tResult = (TextView) findViewById(R.id.textView);

        bt1 = (Button) findViewById(R.id.button1);
        // 响应按钮C事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                nSpSymbol = 0;
                nN = 0;
                nS = 0;
                number = 0;
                dp = 0;
                dps = 1;
                result = 0;
                lastSymbol = 1;
                lastequal = 0;

                lastlfBracket = 0;
                lastriBracket = 0;
                nBracket = 0;
                nl = 0;
                nr = 0;
                norBrackets = 0;
                result1 = 0;

                lastsin1 = 0;
                lastsin1 = 0;
                lastcos1 = 0;
                lastcos2 = 0;
                lasttan1 = 0;
                lasttan2 = 0;
                lastln1 = 0;
                lastln2 = 0;
                lastlg1 = 0;
                lastlg2 = 0;
                lastsqrt1 = 0;
                lastsqrt2 = 0;
                lastsquare1 = 0;
                lastsquare2 = 0;
                lastpower1 = 0;
                lastpower2 = 0;
                power1 = 0;
                power2 = 0;
                lastpi = 0;
            }
        });

        bt2 = (Button) findViewById(R.id.button2);
        // 响应按钮←事件
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number != 0) {
                    number = 0;
                    String a = "";
                    for (int i = 0; i < nN; i++) {
                        int c = (int) nNumber[i];
                        float d = (float) nNumber[i];
                        if (nNumber[i] - c == 0) {
                            a = a + c + nSymbol[i];
                        } else {
                            a = a + d + nSymbol[i];
                        }
                    }
                    text.setText(a);
                } else if (number == 0) {
                    String b = "";
                    number = nNumber[nN - 1];
                    nN--;
                    nS--;
                    for (int i = 0; i < nN; i++) {
                        int c = (int) nNumber[i];
                        float d = (float) nNumber[i];
                        if (nNumber[i] - c == 0) {
                            b = b + c + nSymbol[i];
                        } else {
                            b = b + d + nSymbol[i];
                        }
                    }
                    int c = (int) number;
                    float d = (float) number;
                    if (number - c == 0) {
                        b = b + c;
                    } else {
                        b = b + d;
                    }
                    text.setText(b);
                }
            }
        });

        bt3 = (Button) findViewById(R.id.button3);
        // 响应按钮( 事件
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastsin1 == 1 || lastcos1 == 1 || lasttan1 == 1 || lastln1 == 1 || lastlg1 == 1 || lastsqrt1 == 1 || lastsquare1 == 1 || lastpower1 == 1 || lastpi == 1 || number != 0) {
                    text.setText(text.getText().toString());
                } else {
                    text.setText(text.getText().toString() + "(");
                    lastlfBracket = 1;
                    nBracket++;
                    norBrackets++;
                    nSymbol[nS] = "(";
                    lfbrpl[nl] = nS;
                    nl++;
                    nS++;
                    lastequal = 0;
                    lastriBracket = 0;
                }
            }
        });

        bt4 = (Button) findViewById(R.id.button4);
        // 响应按钮)事件
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastsin1 == 1 || lastcos1 == 1 || lasttan1 == 1 || lastln1 == 1 || lastlg1 == 1 || lastsqrt1 == 1 || lastsquare1 == 1 || lastpower1 == 1 || lastpi == 1 || norBrackets == 0) {
                    text.setText(text.getText().toString());
                } else {
                    text.setText(text.getText().toString() + ")");
                    lastriBracket = 1;
                    norBrackets--;
                    nSymbol[nS] = ")";
                    ribrpl[nr] = nS;
                    nr++;
                    nS++;
                }
            }
        });

        bt5 = (Button) findViewById(R.id.button5);
        // 响应按钮π事件
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText(text.getText().toString() + "π");
                    number = Math.PI;
                    lastpi = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "π");
                        number = Math.PI;
                        lastpi = 1;
                        lastSymbol = 0;
                    } else {
                        if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastsin1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastsin1 = 0;
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastcos1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastcos1 = 0;
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lasttan1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lasttan1 = 0;
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastln1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastln1 = 0;
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastlg1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastlg1 = 0;
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastsqrt1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastsqrt1 = 0;
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "*";
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            number = Math.PI;
                            lastpi = 1;
                            text.setText(text.getText().toString() + "*π");
                            nSpSymbol = 1;
                            lastsquare2 = 0;
                            lastsin1 = 0;
                            lastsin2 = 0;
                            lastcos1 = 0;
                            lastcos2 = 0;
                            lasttan1 = 0;
                            lasttan2 = 0;
                            lastln1 = 0;
                            lastln2 = 0;
                            lastlg1 = 0;
                            lastlg2 = 0;
                            lastsqrt1 = 0;
                            lastsqrt2 = 0;
                            lastsquare1 = 0;
                            lastsquare2 = 0;
                            lastpower1 = 0;
                            lastpower2 = 0;
                        } else if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "*π");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastpower1 == 1) {
                                number = Math.PI;
                                lastpi = 1;
                                text.setText(text.getText().toString() + "π");
                                lastpower1 = 0;
                            }
                        } else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "*";
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            number = Math.PI;
                            lastpi = 1;
                            text.setText(text.getText().toString() + "*π");
                            nSpSymbol = 1;
                            lastsin1 = 0;
                            lastsin2 = 0;
                            lastcos1 = 0;
                            lastcos2 = 0;
                            lasttan1 = 0;
                            lasttan2 = 0;
                            lastln1 = 0;
                            lastln2 = 0;
                            lastlg1 = 0;
                            lastlg2 = 0;
                            lastsqrt1 = 0;
                            lastsqrt2 = 0;
                            lastsquare1 = 0;
                            lastsquare2 = 0;
                            lastpower1 = 0;
                            lastpower2 = 0;
                        }
                    }
                }
            }
        });

        bt6 = (Button) findViewById(R.id.button6);
        // 响应按钮sin事件
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("sin");
                    lastsin1 = 1;
                    lastsin2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "sin");
                        lastsin1 = 1;
                        lastsin2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "sin");
                        lastsin1 = 1;
                        lastsin2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt7 = (Button) findViewById(R.id.button7);
        // 响应按钮√X事件
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("√");
                    lastsqrt1 = 1;
                    lastsqrt2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "√");
                        lastsqrt1 = 1;
                        lastsqrt2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "√");
                        lastsqrt1 = 1;
                        lastsqrt2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt8 = (Button) findViewById(R.id.button8);
        // 响应按钮x²事件
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    number = result;
                    text.setText(number + "²");
                    lastsquare1 = 1;
                    lastsquare2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 0 && number != 0 && lastsquare1 == 0) {
                        text.setText(text.getText().toString() + "²");
                        lastsquare1 = 1;
                        lastsquare2 = 1;
                    }
                }
            }
        });

        bt9 = (Button) findViewById(R.id.button9);
        // 响应按钮x^y事件
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    power1 = result;
                    text.setText(number + "^");
                    lastpower1 = 1;
                    lastpower2 = 1;
                    lastequal = 0;
                    lastsin1 = 0;
                    lastsin2 = 0;
                    lastcos1 = 0;
                    lastcos2 = 0;
                    lasttan1 = 0;
                    lasttan2 = 0;
                    lastln1 = 0;
                    lastln2 = 0;
                    lastlg1 = 0;
                    lastlg2 = 0;
                    lastsqrt1 = 0;
                    lastsqrt2 = 0;
                    lastsquare1 = 0;
                    lastsquare2 = 0;
                } else {
                    if (lastSymbol == 0 && number != 0 && lastpower1 == 0 && lastlfBracket == 0 && lastriBracket == 0) {
                        if (lastsin2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.sin(number * number);
                            } else {
                                power1 = Math.sin(number);
                            }
                        } else if (lastcos2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.cos(number * number);
                            } else {
                                power1 = Math.cos(number);
                            }
                        } else if (lasttan2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.tan(number * number);
                            } else {
                                power1 = Math.tan(number);
                            }
                        } else if (lastln2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.log(number * number);
                            } else {
                                power1 = Math.log(number);
                            }
                        } else if (lastlg2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.log10(number * number);
                            } else {
                                power1 = Math.log10(number);
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsquare2 == 1) {
                                power1 = Math.sqrt(number * number);
                            } else {
                                power1 = Math.sqrt(number);
                            }
                        } else if (lastsquare2 == 1) {
                            power1 = number * number;
                        } else {
                            power1 = number;
                        }
                        text.setText(text.getText().toString() + "^");
                        number = 0;
                        lastpower1 = 1;
                        lastpower2 = 1;
                        lastsin1 = 0;
                        lastsin2 = 0;
                        lastcos1 = 0;
                        lastcos2 = 0;
                        lasttan1 = 0;
                        lasttan2 = 0;
                        lastln1 = 0;
                        lastln2 = 0;
                        lastlg1 = 0;
                        lastlg2 = 0;
                        lastsqrt1 = 0;
                        lastsqrt2 = 0;
                        lastsquare1 = 0;
                        lastsquare2 = 0;
                    }
                }
            }
        });

        bt10 = (Button) findViewById(R.id.button10);
        // 响应按钮/事件
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    nSpSymbol = 1;
                    int b = (int) result;
                    if (result - b == 0) {
                        text.setText("" + b + "/");
                    } else {
                        text.setText("" + result + "/");
                    }
                    nNumber[nN] = result;
                    nSymbol[nS] = "/";
                    nN++;
                    nS++;
                    lastSymbol = 1;
                    lastequal = 0;
                } else if (lastpower1 == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        nSpSymbol = 1;
                        if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "/";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "/");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "/";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "/");
                        } else {
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
                        lastsin1 = 0;
                        lastsin2 = 0;
                        lastcos1 = 0;
                        lastcos2 = 0;
                        lasttan1 = 0;
                        lasttan2 = 0;
                        lastln1 = 0;
                        lastln2 = 0;
                        lastlg1 = 0;
                        lastlg2 = 0;
                        lastsqrt1 = 0;
                        lastsqrt2 = 0;
                        lastsquare1 = 0;
                        lastsquare2 = 0;
                        lastpower1 = 0;
                        lastpower2 = 0;
                        lastpi = 0;
                        lastlfBracket = 0;
                        lastriBracket = 0;
                    }
                }
            }
        });

        bt11 = (Button) findViewById(R.id.button11);
        // 响应按钮cos事件
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("cos");
                    lastcos1 = 1;
                    lastcos2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "cos");
                        lastcos1 = 1;
                        lastcos2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "cos");
                        lastcos1 = 1;
                        lastcos2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt12 = (Button) findViewById(R.id.button12);
        // 响应按钮7事件
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("7");
                    number = 7;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 7;
                        text.setText(text.getText().toString() + "7");
                    } else {
                        dps = dps * 10;
                        number = number + 7 / dps;
                        text.setText(text.getText().toString() + "7");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt13 = (Button) findViewById(R.id.button13);
        // 响应按钮8事件
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("8");
                    number = 8;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 8;
                        text.setText(text.getText().toString() + "8");
                    } else {
                        dps = dps * 10;
                        number = number + 8 / dps;
                        text.setText(text.getText().toString() + "8");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt14 = (Button) findViewById(R.id.button14);
        // 响应按钮9事件
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("9");
                    number = 9;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 9;
                        text.setText(text.getText().toString() + "9");
                    } else {
                        dps = dps * 10;
                        number = number + 9 / dps;
                        text.setText(text.getText().toString() + "9");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt15 = (Button) findViewById(R.id.button15);
        // 响应按钮*事件
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    nSpSymbol = 1;
                    int b = (int) result;
                    if (result - b == 0) {
                        text.setText("" + b + "*");
                    } else {
                        text.setText("" + result + "*");
                    }
                    nNumber[nN] = result;
                    nSymbol[nS] = "*";
                    nN++;
                    nS++;
                    lastSymbol = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        nSpSymbol = 1;
                        if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "*";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "*");
                            lastsquare2 = 0;
                        } else if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "*";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "*");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else {
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
                        lastsin1 = 0;
                        lastsin2 = 0;
                        lastcos1 = 0;
                        lastcos2 = 0;
                        lasttan1 = 0;
                        lasttan2 = 0;
                        lastln1 = 0;
                        lastln2 = 0;
                        lastlg1 = 0;
                        lastlg2 = 0;
                        lastsqrt1 = 0;
                        lastsqrt2 = 0;
                        lastsquare1 = 0;
                        lastsquare2 = 0;
                        lastpower1 = 0;
                        lastpower2 = 0;
                        lastpi = 0;
                        lastlfBracket = 0;
                        lastriBracket = 0;
                    }
                }
            }
        });

        bt16 = (Button) findViewById(R.id.button16);
        // 响应按钮tan事件
        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("tan");
                    lasttan1 = 1;
                    lasttan2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "tan");
                        lasttan1 = 1;
                        lasttan2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "tan");
                        lasttan1 = 1;
                        lasttan2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt17 = (Button) findViewById(R.id.button17);
        // 响应按钮4事件
        bt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("4");
                    number = 4;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 4;
                        text.setText(text.getText().toString() + "4");
                    } else {
                        dps = dps * 10;
                        number = number + 4 / dps;
                        text.setText(text.getText().toString() + "4");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt18 = (Button) findViewById(R.id.button18);
        // 响应按钮5事件
        bt18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("5");
                    number = 5;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 5;
                        text.setText(text.getText().toString() + "5");
                    } else {
                        dps = dps * 10;
                        number = number + 5 / dps;
                        text.setText(text.getText().toString() + "5");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt19 = (Button) findViewById(R.id.button19);
        // 响应按钮6事件
        bt19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("6");
                    number = 6;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 6;
                        text.setText(text.getText().toString() + "6");
                    } else {
                        dps = dps * 10;
                        number = number + 6 / dps;
                        text.setText(text.getText().toString() + "6");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt20 = (Button) findViewById(R.id.button20);
        // 响应按钮-事件
        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    int b = (int) result;
                    if (result - b == 0) {
                        text.setText("" + b + "-");
                    } else {
                        text.setText("" + result + "-");
                    }
                    nNumber[nN] = result;
                    nSymbol[nS] = "-";
                    nN++;
                    nS++;
                    lastSymbol = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "-";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "-");
                        } else if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "-";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "-");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else {
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
                        lastsin1 = 0;
                        lastsin2 = 0;
                        lastcos1 = 0;
                        lastcos2 = 0;
                        lasttan1 = 0;
                        lasttan2 = 0;
                        lastln1 = 0;
                        lastln2 = 0;
                        lastlg1 = 0;
                        lastlg2 = 0;
                        lastsqrt1 = 0;
                        lastsqrt2 = 0;
                        lastsquare1 = 0;
                        lastsquare2 = 0;
                        lastpower1 = 0;
                        lastpower2 = 0;
                        lastpi = 0;
                        lastlfBracket = 0;
                        lastriBracket = 0;
                    }
                }
            }
        });

        bt21 = (Button) findViewById(R.id.button21);
        // 响应按钮ln事件
        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("ln");
                    lastln1 = 1;
                    lastln2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "ln");
                        lastln1 = 1;
                        lastln2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "ln");
                        lastln1 = 1;
                        lastln2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt22 = (Button) findViewById(R.id.button22);
        // 响应按钮1事件
        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("1");
                    number = 1;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 1;
                        text.setText(text.getText().toString() + "1");
                    } else {
                        dps = dps * 10;
                        number = number + 1 / dps;
                        text.setText(text.getText().toString() + "1");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;

                }
            }
        });

        bt23 = (Button) findViewById(R.id.button23);
        // 响应按钮2事件
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("2");
                    number = 2;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 2;
                        text.setText(text.getText().toString() + "2");
                    } else {
                        dps = dps * 10;
                        number = number + 2 / dps;
                        text.setText(text.getText().toString() + "2");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt24 = (Button) findViewById(R.id.button24);
        // 响应按钮3事件
        bt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("3");
                    number = 3;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 3;
                        text.setText(text.getText().toString() + "3");
                    } else {
                        dps = dps * 10;
                        number = number + 3 / dps;
                        text.setText(text.getText().toString() + "3");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt25 = (Button) findViewById(R.id.button25);
        // 响应按钮+事件
        bt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    int b = (int) result;
                    if (result - b == 0) {
                        text.setText("" + b + "+");
                    } else {
                        text.setText("" + result + "+");
                    }
                    nNumber[nN] = result;
                    nSymbol[nS] = "+";
                    nN++;
                    nS++;
                    lastSymbol = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "+";
                            number = 0;
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            lastSymbol = 1;
                            text.setText(text.getText().toString() + "+");
                        } else if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "+";
                                number = 0;
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                lastSymbol = 1;
                                text.setText(text.getText().toString() + "+");
                            } else {
                                text.setText(text.getText().toString());
                            }
                        } else {
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
                        lastsin1 = 0;
                        lastsin2 = 0;
                        lastcos1 = 0;
                        lastcos2 = 0;
                        lasttan1 = 0;
                        lasttan2 = 0;
                        lastln1 = 0;
                        lastln2 = 0;
                        lastlg1 = 0;
                        lastlg2 = 0;
                        lastsqrt1 = 0;
                        lastsqrt2 = 0;
                        lastsquare1 = 0;
                        lastsquare2 = 0;
                        lastpower1 = 0;
                        lastpower2 = 0;
                        lastpi = 0;
                        lastlfBracket = 0;
                        lastriBracket = 0;
                    }
                }
            }
        });

        bt26 = (Button) findViewById(R.id.button26);
        // 响应按钮lg事件
        bt26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("lg");
                    lastlg1 = 1;
                    lastlg2 = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "lg");
                        lastlg1 = 1;
                        lastlg2 = 1;
                        lastSymbol = 0;
                    } else if (lastpower1 == 1) {
                        text.setText(text.getText().toString() + "lg");
                        lastlg1 = 1;
                        lastlg2 = 1;
                        lastpower1 = 0;
                    }
                }
            }
        });

        bt27 = (Button) findViewById(R.id.button27);
        // 响应按钮e事件
        bt27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText(text.getText().toString() + "e");
                    number = Math.E;
                    laste = 1;
                    lastequal = 0;
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString() + "e");
                        number = Math.E;
                        laste = 1;
                        lastSymbol = 0;
                    } else {
                        if (lastsin2 == 1) {
                            if (lastsin1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sin(number * number);
                                } else {
                                    nNumber[nN] = Math.sin(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastsin1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastsin1 = 0;
                            }
                        } else if (lastcos2 == 1) {
                            if (lastcos1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.cos(number * number);
                                } else {
                                    nNumber[nN] = Math.cos(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastcos1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastcos1 = 0;
                            }
                        } else if (lasttan2 == 1) {
                            if (lasttan1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.tan(number * number);
                                } else {
                                    nNumber[nN] = Math.tan(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lasttan1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lasttan1 = 0;
                            }
                        } else if (lastln2 == 1) {
                            if (lastln1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log(number * number);
                                } else {
                                    nNumber[nN] = Math.log(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastln1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastln1 = 0;
                            }
                        } else if (lastlg2 == 1) {
                            if (lastlg1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.log10(number * number);
                                } else {
                                    nNumber[nN] = Math.log10(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastlg1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastlg1 = 0;
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsqrt1 == 0) {
                                if (lastsquare2 == 1) {
                                    nNumber[nN] = Math.sqrt(number * number);
                                } else {
                                    nNumber[nN] = Math.sqrt(number);
                                }
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastsqrt1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastsqrt1 = 0;
                            }
                        } else if (lastsquare2 == 1) {
                            nNumber[nN] = number * number;
                            nSymbol[nS] = "*";
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            number = Math.E;
                            laste = 1;
                            text.setText(text.getText().toString() + "*e");
                            nSpSymbol = 1;
                            lastsquare2 = 0;
                            lastsin1 = 0;
                            lastsin2 = 0;
                            lastcos1 = 0;
                            lastcos2 = 0;
                            lasttan1 = 0;
                            lasttan2 = 0;
                            lastln1 = 0;
                            lastln2 = 0;
                            lastlg1 = 0;
                            lastlg2 = 0;
                            lastsqrt1 = 0;
                            lastsqrt2 = 0;
                            lastsquare1 = 0;
                            lastsquare2 = 0;
                            lastpower1 = 0;
                            lastpower2 = 0;
                        } else if (lastpower2 == 1) {
                            if (lastpower1 == 0) {
                                if (lastsin2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sin(number * number);
                                    } else {
                                        power2 = Math.sin(number);
                                    }
                                } else if (lastcos2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.cos(number * number);
                                    } else {
                                        power2 = Math.cos(number);
                                    }
                                } else if (lasttan2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.tan(number * number);
                                    } else {
                                        power2 = Math.tan(number);
                                    }
                                } else if (lastln2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log(number * number);
                                    } else {
                                        power2 = Math.log(number);
                                    }
                                } else if (lastlg2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.log10(number * number);
                                    } else {
                                        power2 = Math.log10(number);
                                    }
                                } else if (lastsqrt2 == 1) {
                                    if (lastsquare2 == 1) {
                                        power2 = Math.sqrt(number * number);
                                    } else {
                                        power2 = Math.sqrt(number);
                                    }
                                } else if (lastsquare2 == 1) {
                                    power2 = number * number;
                                } else {
                                    power2 = number;
                                }
                                nNumber[nN] = Math.pow(power1, power2);
                                nSymbol[nS] = "*";
                                dp = 0;
                                dps = 1;
                                nN++;
                                nS++;
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "*e");
                                nSpSymbol = 1;
                                lastsin1 = 0;
                                lastsin2 = 0;
                                lastcos1 = 0;
                                lastcos2 = 0;
                                lasttan1 = 0;
                                lasttan2 = 0;
                                lastln1 = 0;
                                lastln2 = 0;
                                lastlg1 = 0;
                                lastlg2 = 0;
                                lastsqrt1 = 0;
                                lastsqrt2 = 0;
                                lastsquare1 = 0;
                                lastsquare2 = 0;
                                lastpower1 = 0;
                                lastpower2 = 0;
                            } else if (lastpower1 == 1) {
                                number = Math.E;
                                laste = 1;
                                text.setText(text.getText().toString() + "e");
                                lastpower1 = 0;
                            }
                        } else {
                            nNumber[nN] = number;
                            nSymbol[nS] = "*";
                            dp = 0;
                            dps = 1;
                            nN++;
                            nS++;
                            number = Math.E;
                            laste = 1;
                            text.setText(text.getText().toString() + "*e");
                            nSpSymbol = 1;
                            lastsin1 = 0;
                            lastsin2 = 0;
                            lastcos1 = 0;
                            lastcos2 = 0;
                            lasttan1 = 0;
                            lasttan2 = 0;
                            lastln1 = 0;
                            lastln2 = 0;
                            lastlg1 = 0;
                            lastlg2 = 0;
                            lastsqrt1 = 0;
                            lastsqrt2 = 0;
                            lastsquare1 = 0;
                            lastsquare2 = 0;
                            lastpower1 = 0;
                            lastpower2 = 0;
                        }
                    }
                }
            }
        });

        bt28 = (Button) findViewById(R.id.button28);
        // 响应按钮0事件
        bt28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("0");
                    number = 0;
                    lastequal = 0;
                } else if (lastsquare1 == 1 || lastpi == 1 || lastriBracket == 1) {
                    text.setText(text.getText().toString());
                } else {
                    if (dp == 0) {
                        number = number * 10 + 0;
                        text.setText(text.getText().toString() + "0");
                    } else {
                        dps = dps * 10;
                        number = number + 0 / dps;
                        text.setText(text.getText().toString() + "0");
                    }
                    lastSymbol = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lasttan1 = 0;
                    lastln1 = 0;
                    lastlg1 = 0;
                    lastsqrt1 = 0;
                    lastsquare1 = 0;
                    lastpower1 = 0;
                    lastlfBracket = 0;
                }
            }
        });

        bt29 = (Button) findViewById(R.id.button29);
        // 响应按钮.事件
        bt29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    text.setText("");
                } else {
                    if (lastSymbol == 1) {
                        text.setText(text.getText().toString());
                    } else {
                        if (dp == 1 || lastsin1 == 1 || lastcos1 == 1 || lasttan1 == 1 || lastln1 == 1 || lastlg1 == 1 || lastsqrt1 == 1 || lastsquare1 == 1 || lastpower1 == 1 || lastpi == 1 || lastlfBracket == 1 || lastlfBracket == 1) {
                            text.setText(text.getText().toString());
                        } else {
                            text.setText(text.getText().toString() + ".");
                        }
                    }
                }
                dp = 1;
            }
        });

        bt30 = (Button) findViewById(R.id.button30);
        // 响应按钮=事件
        bt30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastsin1 == 1 || lastcos1 == 1 || lasttan1 == 1 || lastlg1 == 1 || lastln1 == 1 || lastpower1 == 1 || lastlfBracket == 1) {
                    text.setText(text.getText().toString());
                } else if (lastequal == 1) {
                    tResult.setText("" + result);
                } else {
                    lastequal = 1;
                    if (nS == 0) {
                        if (lastpower2 == 1) {
                            if (lastsin2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.sin(number * number);
                                } else {
                                    power2 = Math.sin(number);
                                }
                            } else if (lastcos2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.cos(number * number);
                                } else {
                                    power2 = Math.cos(number);
                                }
                            } else if (lasttan2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.tan(number * number);
                                } else {
                                    power2 = Math.tan(number);
                                }
                            } else if (lastln2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.log(number * number);
                                } else {
                                    power2 = Math.log(number);
                                }
                            } else if (lastlg2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.log10(number * number);
                                } else {
                                    power2 = Math.log10(number);
                                }
                            } else if (lastsqrt2 == 1) {
                                if (lastsquare2 == 1) {
                                    power2 = Math.sqrt(number * number);
                                } else {
                                    power2 = Math.sqrt(number);
                                }
                            } else if (lastsquare2 == 1) {
                                power2 = number * number;
                            } else {
                                power2 = number;
                            }
                            result = Math.pow(power1, power2);
                        } else if (lastsin2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.sin(number * number);
                            } else {
                                result = Math.sin(number);
                            }
                        } else if (lastcos2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.cos(number * number);
                            } else {
                                result = Math.cos(number);
                            }
                        } else if (lasttan2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.tan(number * number);
                            } else {
                                result = Math.tan(number);
                            }
                        } else if (lastln2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.log(number * number);
                            } else {
                                result = Math.log(number);
                            }
                        } else if (lastlg2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.log10(number * number);
                            } else {
                                result = Math.log10(number);
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsquare2 == 1) {
                                result = Math.sqrt(number * number);
                            } else {
                                result = Math.sqrt(number);
                            }
                        } else if (lastsquare2 == 1) {
                            result = number * number;
                        } else {
                            result = number;
                        }
                    } else {
                        result = nNumber[0];
                    }
                    if (lastpower2 == 1) {
                        if (lastsin2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.sin(number * number);
                            } else {
                                power2 = Math.sin(number);
                            }
                        } else if (lastcos2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.cos(number * number);
                            } else {
                                power2 = Math.cos(number);
                            }
                        } else if (lasttan2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.tan(number * number);
                            } else {
                                power2 = Math.tan(number);
                            }
                        } else if (lastln2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.log(number * number);
                            } else {
                                power2 = Math.log(number);
                            }
                        } else if (lastlg2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.log10(number * number);
                            } else {
                                power2 = Math.log10(number);
                            }
                        } else if (lastsqrt2 == 1) {
                            if (lastsquare2 == 1) {
                                power2 = Math.sqrt(number * number);
                            } else {
                                power2 = Math.sqrt(number);
                            }
                        } else if (lastsquare2 == 1) {
                            power2 = number * number;
                        } else {
                            power2 = number;
                        }
                        nNumber[nN] = Math.pow(power1, power2);
                    } else if (lastsin2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.sin(number * number);
                        } else {
                            nNumber[nN] = Math.sin(number);
                        }
                    } else if (lastcos2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.cos(number * number);
                        } else {
                            nNumber[nN] = Math.cos(number);
                        }
                    } else if (lasttan2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.tan(number * number);
                        } else {
                            nNumber[nN] = Math.tan(number);
                        }
                    } else if (lastln2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.log(number * number);
                        } else {
                            nNumber[nN] = Math.log(number);
                        }
                    } else if (lastlg2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.log10(number * number);
                        } else {
                            nNumber[nN] = Math.log10(number);
                        }
                    } else if (lastsqrt2 == 1) {
                        if (lastsquare2 == 1) {
                            nNumber[nN] = Math.sqrt(number * number);
                        } else {
                            nNumber[nN] = Math.sqrt(number);
                        }
                    } else if (lastsquare2 == 1) {
                        nNumber[nN] = number * number;
                    } else {
                        nNumber[nN] = number;
                    }
                    if (nSpSymbol == 0) {
                        if (nBracket != 0) {
                            for (int j = nl - 1; j >= 0; j--) {
                                int x = 0;    //当前左括号前的括号数
                                int a = 0;    //标记括号内第一个数字的位置
                                int y = 0;    //标记当前数字位置
                                int t = 0;    //标记当前左括号的位置
                                for (int m = 0; m < nl - 1; m++) {
                                    if (lfbrpl[j] > ribrpl[m]) {
                                        x++;
                                    }
                                    if (lfbrpl[j] > lfbrpl[m]) {
                                        x++;
                                    }
                                }
                                result1 = nNumber[lfbrpl[j] - x];
                                t = lfbrpl[j];
                                a = lfbrpl[j] - x;
                                y = lfbrpl[j] - x + 1;
                                for (int n = 0; n < 200; n++) {
                                    if (nSymbol[lfbrpl[j] + 1] == "+") {
                                        result1 = result1 + nNumber[y];
                                        y++;
                                        lfbrpl[j]++;
                                    } else if (nSymbol[lfbrpl[j] + 1] == "-") {
                                        result1 = result1 - nNumber[y];
                                        y++;
                                        lfbrpl[j]++;
                                    } else if (nSymbol[lfbrpl[j] + 1] == ")") {
                                        break;
                                    }
                                }
                                nNumber[a] = result1;
                                nN = nN - y + a + 1;
                                nS = nS - y + a - 1;
                                for (int b = a + 1; b <= nN; b++) {
                                    nNumber[b] = nNumber[b + y - a - 1];
                                }
                                for (int c = t; c < nS; c++) {
                                    nSymbol[c] = nSymbol[c + y - a + 1];
                                }
                            }
                        }
                        for (int i = 0; i < nS; i++) {
                            if (nSymbol[i] == "+") {
                                result = result + nNumber[i + 1];
                            } else if (nSymbol[i] == "-") {
                                result = result - nNumber[i + 1];
                            }
                        }
                    } else {
                        if (nBracket != 0) {
                            for (int j = nl - 1; j >= 0; j--) {
                                int x = 0;    //当前左括号前的括号数
                                int a = 0;    //标记括号内第一个数字的位置
                                int y = 0;    //标记当前数字位置
                                int t = 0;    //标记当前左括号的位置
                                for (int m = 0; m < nl - 1; m++) {
                                    if (lfbrpl[j] > ribrpl[m]) {
                                        x++;
                                    }
                                    if (lfbrpl[j] > lfbrpl[m]) {
                                        x++;
                                    }
                                }
                                result1 = nNumber[lfbrpl[j] - x];
                                t = lfbrpl[j];
                                a = lfbrpl[j] - x;
                                y = lfbrpl[j] - x + 1;
                                for (int n = 0; n < 200; n++) {
                                    if (nSymbol[lfbrpl[j] + 1] == "+") {
                                        if (nSymbol[lfbrpl[j] + 2] == "*") {
                                            result1 = result1 + nNumber[y] * nNumber[y + 1];
                                            y = y + 2;
                                            lfbrpl[j] = lfbrpl[j] + 2;
                                        } else if (nSymbol[lfbrpl[j] + 2] == "/") {
                                            result1 = result1 + nNumber[y] / nNumber[y + 1];
                                            y = y + 2;
                                            lfbrpl[j] = lfbrpl[j] + 2;
                                        } else {
                                            result1 = result1 + nNumber[y];
                                            y++;
                                            lfbrpl[j]++;
                                        }
                                    } else if (nSymbol[lfbrpl[j] + 1] == "-") {
                                        if (nSymbol[lfbrpl[j] + 2] == "*") {
                                            result1 = result1 - nNumber[y] * nNumber[y + 1];
                                            y = y + 2;
                                            lfbrpl[j] = lfbrpl[j] + 2;
                                        } else if (nSymbol[lfbrpl[j] + 2] == "/") {
                                            result1 = result1 - nNumber[y] / nNumber[y + 1];
                                            y = y + 2;
                                            lfbrpl[j] = lfbrpl[j] + 2;
                                        } else {
                                            result1 = result1 - nNumber[y];
                                            y++;
                                            lfbrpl[j]++;
                                        }
                                    } else if (nSymbol[lfbrpl[j] + 1] == ")") {
                                        break;
                                    }
                                }
                                nNumber[a] = result1;
                                nN = nN - y + a + 1;
                                nS = nS - y + a - 1;
                                for (int b = a + 1; b <= nN; b++) {
                                    nNumber[b] = nNumber[b + y - a - 1];
                                }
                                for (int c = t; c < nS; c++) {
                                    nSymbol[c] = nSymbol[c + y - a + 1];
                                }
                            }
                        }
                        for (int i = 0; i < nS; i++) {
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
                    float b = (float) result;
                    if (result - a == 0) {
                        tResult.setText("" + a);
                    } else {
                        tResult.setText("" + b);
                    }
                    nSpSymbol = 0;
                    //nBrackets = 0;
                    nN = 0;
                    nS = 0;
                    number = 0;
                    dp = 0;
                    dps = 1;
                    lastsin1 = 0;
                    lastsin1 = 0;
                    lastcos1 = 0;
                    lastcos2 = 0;
                    lasttan1 = 0;
                    lasttan2 = 0;
                    lastln1 = 0;
                    lastln2 = 0;
                    lastlg1 = 0;
                    lastlg2 = 0;
                    lastsqrt1 = 0;
                    lastsqrt2 = 0;
                    lastsquare1 = 0;
                    lastsquare2 = 0;
                    lastpower1 = 0;
                    lastpower2 = 0;
                    power1 = 0;
                    power2 = 0;
                }
            }
        });

        bt31 = (Button) findViewById(R.id.button31);
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

    public void onclick1() {
        Intent it = new Intent();
        //设置Intent的Action属性
        it.setAction("android.intent.action.DECIMAL");
        // 启动Activity
        startActivity(it);
    }

    public void onclick2() {
        Intent it = new Intent();
        //设置Intent的Action属性
        it.setClass(MainActivity.this, unit_conversion.class);
        // 启动Activity
        MainActivity.this.startActivity(it);
    }

    //弹出式菜单的单击事件处理
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.decimal_conversion:
                onclick1();
                break;
            case R.id.unit_conversion:
                onclick2();
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
