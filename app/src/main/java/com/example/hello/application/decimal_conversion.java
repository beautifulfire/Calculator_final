package com.example.hello.application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

/**
 * Created by 龙阳 on 2017/9/10.
 */

public class decimal_conversion extends AppCompatActivity {
    private Button bt40;
    private Button bt41;
    private Button bt42;
    private Button bt43;
    private Button bt44;
    private Button bt45;
    private Button bt46;
    private Button bt47;
    private Button bt48;
    private Button bt49;
    private Button bt50;
    private Button bt51;
    private Button bt52;
    private Button bt53;
    private Button bt54;
    private Button bt55;
    private Button bt56;
    private Button bt57;
    private Button bt58;
    private Button bt59;
    private Button bt60;
    private Button bt61;
    private Button bt62;
    private Button bt63;

    private int BIN = 0;  //标记是否进行二进制换算
    private int OCT = 0;  //标记是否进行八进制运算
    private int DEC = 0;  //标记是否进行十进制运算
    private int HEX = 0;  //标记是否进行十六进制运算

    private String number2 = "";  //记录二进制文本框里的数
    private String number8 = "";  //记录八进制文本框里的数
    private String number10 = ""; //记录十进制文本框里的数
    private String number16 = ""; //记录十六进制文本框里的数

    private int lastequal = 0; //标记上次是否点击了等号按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decimal_conversion);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);

        //左上按钮←事件
        bt40 = (Button) findViewById(R.id.button40);
        bt40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //按钮7事件
        bt41 = (Button) findViewById(R.id.button41);
        bt41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "7";
                    editText2.setText(editText2.getText().toString() + "7");
                } else if (DEC == 1) {
                    number10 = number10 + "7";
                    editText3.setText(editText3.getText().toString() + "7");
                } else if (HEX == 1) {
                    number16 = number16 + "7";
                    editText4.setText(editText4.getText().toString() + "7");
                }
            }
        });

        //按钮8事件
        bt42 = (Button) findViewById(R.id.button42);
        bt42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    number10 = number10 + "8";
                    editText3.setText(editText3.getText().toString() + "8");
                } else if (HEX == 1) {
                    number16 = number16 + "8";
                    editText4.setText(editText4.getText().toString() + "8");
                }
            }
        });

        //按钮9事件
        bt43 = (Button) findViewById(R.id.button43);
        bt43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    number10 = number10 + "9";
                    editText3.setText(editText3.getText().toString() + "9");
                } else if (HEX == 1) {
                    number16 = number16 + "7";
                    editText4.setText(editText4.getText().toString() + "9");
                }
            }
        });

        //按钮F事件
        bt44 = (Button) findViewById(R.id.button44);
        bt44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "F";
                    editText4.setText(editText4.getText().toString() + "F");
                }
            }
        });

        //按钮4事件
        bt45 = (Button) findViewById(R.id.button45);
        bt45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "4";
                    editText2.setText(editText2.getText().toString() + "4");
                } else if (DEC == 1) {
                    number10 = number10 + "4";
                    editText3.setText(editText3.getText().toString() + "4");
                } else if (HEX == 1) {
                    number16 = number16 + "4";
                    editText4.setText(editText4.getText().toString() + "4");
                }
            }
        });

        //按钮5事件
        bt46 = (Button) findViewById(R.id.button46);
        bt46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "5";
                    editText2.setText(editText2.getText().toString() + "5");
                } else if (DEC == 1) {
                    number10 = number10 + "5";
                    editText3.setText(editText3.getText().toString() + "5");
                } else if (HEX == 1) {
                    number16 = number16 + "5";
                    editText4.setText(editText4.getText().toString() + "5");
                }
            }
        });

        //按钮6事件
        bt47 = (Button) findViewById(R.id.button47);
        bt47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "6";
                    editText2.setText(editText2.getText().toString() + "6");
                } else if (DEC == 1) {
                    number10 = number10 + "6";
                    editText3.setText(editText3.getText().toString() + "6");
                } else if (HEX == 1) {
                    number16 = number16 + "6";
                    editText4.setText(editText4.getText().toString() + "6");
                }
            }
        });

        //按钮E事件
        bt48 = (Button) findViewById(R.id.button48);
        bt48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "E";
                    editText4.setText(editText4.getText().toString() + "E");
                }
            }
        });

        //按钮1事件
        bt49 = (Button) findViewById(R.id.button49);
        bt49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    number2 = number2 + "1";
                    editText.setText(editText.getText().toString() + "1");
                } else if (OCT == 1) {
                    number8 = number8 + "1";
                    editText2.setText(editText2.getText().toString() + "1");
                } else if (DEC == 1) {
                    number10 = number10 + "1";
                    editText3.setText(editText3.getText().toString() + "1");
                } else if (HEX == 1) {
                    number16 = number16 + "1";
                    editText4.setText(editText4.getText().toString() + "1");
                }
            }
        });

        //按钮2事件
        bt50 = (Button) findViewById(R.id.button50);
        bt50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "2";
                    editText2.setText(editText2.getText().toString() + "2");
                } else if (DEC == 1) {
                    number10 = number10 + "2";
                    editText3.setText(editText3.getText().toString() + "2");
                } else if (HEX == 1) {
                    number16 = number16 + "2";
                    editText4.setText(editText4.getText().toString() + "2");
                }
            }
        });

        //按钮3事件
        bt51 = (Button) findViewById(R.id.button51);
        bt51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    number8 = number8 + "3";
                    editText2.setText(editText2.getText().toString() + "3");
                } else if (DEC == 1) {
                    number10 = number10 + "3";
                    editText3.setText(editText3.getText().toString() + "3");
                } else if (HEX == 1) {
                    number16 = number16 + "3";
                    editText4.setText(editText4.getText().toString() + "3");
                }
            }
        });

        //按钮D事件
        bt52 = (Button) findViewById(R.id.button52);
        bt52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "D";
                    editText4.setText(editText4.getText().toString() + "D");
                }
            }
        });

        //按钮0事件
        bt53 = (Button) findViewById(R.id.button53);
        bt53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    number2 = number2 + "0";
                    editText.setText(editText.getText().toString() + "0");
                } else if (OCT == 1) {
                    number8 = number8 + "0";
                    editText2.setText(editText2.getText().toString() + "0");
                } else if (DEC == 1) {
                    number10 = number10 + "0";
                    editText3.setText(editText3.getText().toString() + "0");
                } else if (HEX == 1) {
                    number16 = number16 + "7";
                    editText4.setText(editText4.getText().toString() + "0");
                }
            }
        });

        //按钮A事件
        bt54 = (Button) findViewById(R.id.button54);
        bt54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "A";
                    editText4.setText(editText4.getText().toString() + "A");
                }
            }
        });

        //按钮B事件
        bt55 = (Button) findViewById(R.id.button55);
        bt55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "B";
                    editText4.setText(editText4.getText().toString() + "B");
                }
            }
        });

        //按钮C事件
        bt56 = (Button) findViewById(R.id.button56);
        bt56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    editText.setText(editText.getText().toString());
                } else if (OCT == 1) {
                    editText2.setText(editText2.getText().toString());
                } else if (DEC == 1) {
                    editText3.setText(editText3.getText().toString());
                } else if (HEX == 1) {
                    number16 = number16 + "C";
                    editText4.setText(editText4.getText().toString() + "C");
                }
            }
        });

        //按钮CE事件
        bt57 = (Button) findViewById(R.id.button57);
        bt57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BIN = 0;
                OCT = 0;
                DEC = 0;
                HEX = 0;
                number2 = "";
                number8 = "";
                number10 = "";
                number16 = "";
                lastequal = 0;
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
            }
        });

        //右下按钮←事件
        bt58 = (Button) findViewById(R.id.button58);
        bt58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal = 0;
                if (BIN == 1) {
                    if (number2.equals("")) {
                        editText.setText(editText.getText().toString());
                    } else {
                        number2 = number2.substring(0, number2.length() - 1);
                        editText.setText(number2);
                    }
                } else if (OCT == 1) {
                    if (number8.equals("")) {
                        editText2.setText(editText2.getText().toString());
                    } else {
                        number8 = number8.substring(0, number8.length() - 1);
                        editText2.setText(number8);
                    }
                } else if (DEC == 1) {
                    if (number10.equals("")) {
                        editText3.setText(editText3.getText().toString());
                    } else {
                        number10 = number10.substring(0, number10.length() - 1);
                        editText3.setText(number10);
                    }
                } else if (HEX == 1) {
                    if (number16.equals("")) {
                        editText4.setText(editText4.getText().toString());
                    } else {
                        number16 = number16.substring(0, number16.length() - 1);
                        editText4.setText(number16);
                    }
                }
            }
        });

        //按钮=事件
        bt59 = (Button) findViewById(R.id.button59);
        bt59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal == 1) {
                    editText.setText(editText.getText().toString());
                    editText2.setText(editText2.getText().toString());
                    editText3.setText(editText3.getText().toString());
                    editText4.setText(editText4.getText().toString());
                } else {
                    lastequal = 1;
                    if (BIN == 1) {
                        number8 = BIoOC(number2);
                        number10 = BIoDE(number2);
                        number16 = BIoHE(number2);

                        editText.setText(number2);
                        editText2.setText(number8);
                        editText3.setText(number10);
                        editText4.setText(number16);
                    } else if (OCT == 1) {
                        number2 = OCoBI(number8);
                        number10 = OCoDE(number8);
                        number16 = OCoHE(number8);

                        editText.setText(number2);
                        editText2.setText(number8);
                        editText3.setText(number10);
                        editText4.setText(number16);
                    } else if (DEC == 1) {
                        number2 = DEoBI(number10);
                        number8 = DEoOC(number10);
                        number16 = DEoHE(number10);

                        editText.setText(number2);
                        editText2.setText(number8);
                        editText3.setText(number10);
                        editText4.setText(number16);
                    } else if (HEX == 1) {
                        number2 = HEoBI(number16);
                        number8 = HEoOC(number16);
                        number10 = HEoDE(number16);

                        editText.setText(number2);
                        editText2.setText(number8);
                        editText3.setText(number10);
                        editText4.setText(number16);
                    }
                }
            }
        });

        //按钮二进制事件
        bt60 = (Button) findViewById(R.id.button60);
        bt60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BIN = 1;
                OCT = 0;
                DEC = 0;
                HEX = 0;
                bt41.setEnabled(false);
                bt42.setEnabled(false);
                bt43.setEnabled(false);
                bt44.setEnabled(false);
                bt45.setEnabled(false);
                bt46.setEnabled(false);
                bt47.setEnabled(false);
                bt48.setEnabled(false);
                bt49.setEnabled(true);
                bt50.setEnabled(false);
                bt51.setEnabled(false);
                bt52.setEnabled(false);
                bt53.setEnabled(true);
                bt54.setEnabled(false);
                bt55.setEnabled(false);
                bt56.setEnabled(false);
            }
        });

        //按钮八进制事件
        bt61 = (Button) findViewById(R.id.button61);
        bt61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BIN = 0;
                OCT = 1;
                DEC = 0;
                HEX = 0;
                bt41.setEnabled(true);
                bt42.setEnabled(false);
                bt43.setEnabled(false);
                bt44.setEnabled(false);
                bt45.setEnabled(true);
                bt46.setEnabled(true);
                bt47.setEnabled(true);
                bt48.setEnabled(false);
                bt49.setEnabled(true);
                bt50.setEnabled(true);
                bt51.setEnabled(true);
                bt52.setEnabled(false);
                bt53.setEnabled(true);
                bt54.setEnabled(false);
                bt55.setEnabled(false);
                bt56.setEnabled(false);
            }
        });

        //按钮十进制事件
        bt62 = (Button) findViewById(R.id.button62);
        bt62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BIN = 0;
                OCT = 0;
                DEC = 1;
                HEX = 0;
                bt41.setEnabled(true);
                bt42.setEnabled(true);
                bt43.setEnabled(true);
                bt44.setEnabled(false);
                bt45.setEnabled(true);
                bt46.setEnabled(true);
                bt47.setEnabled(true);
                bt48.setEnabled(false);
                bt49.setEnabled(true);
                bt50.setEnabled(true);
                bt51.setEnabled(true);
                bt52.setEnabled(false);
                bt53.setEnabled(true);
                bt54.setEnabled(false);
                bt55.setEnabled(false);
                bt56.setEnabled(false);
            }
        });

        //按钮十六进制事件
        bt63 = (Button) findViewById(R.id.button63);
        bt63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BIN = 0;
                OCT = 0;
                DEC = 0;
                HEX = 1;
                bt41.setEnabled(true);
                bt42.setEnabled(true);
                bt43.setEnabled(true);
                bt44.setEnabled(true);
                bt45.setEnabled(true);
                bt46.setEnabled(true);
                bt47.setEnabled(true);
                bt48.setEnabled(true);
                bt49.setEnabled(true);
                bt50.setEnabled(true);
                bt51.setEnabled(true);
                bt52.setEnabled(true);
                bt53.setEnabled(true);
                bt54.setEnabled(true);
                bt55.setEnabled(true);
                bt56.setEnabled(true);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 二进制转八进制
    public String BIoOC(String a) {// 将二进制转为十进制再从十进制转为八进制
        String b = Integer.toOctalString(Integer.valueOf(a, 2));
        return b;
    }

    // 二进制转十进制
    public String BIoDE(String a) { //将二进制转为十进制
        String b = Integer.valueOf(a, 2).toString();
        return b;
    }

    // 二进制转十六进制
    public String BIoHE(String a) {// 将二进制转为十进制再从十进制转为十六进制
        String b = Integer.toHexString(Integer.valueOf(a, 2));
        return b;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 八进制转二进制
    public String OCoBI(String a) {// 将八进制转为十进制再从十进制转为二进制
        String b = Integer.toBinaryString(Integer.valueOf(a, 8));
        return b;
    }

    // 八进制转十进制
    public String OCoDE(String a) { //将八进制转为十进制
        String b = Integer.valueOf(a, 8).toString();
        return b;
    }

    // 八进制转十六进制
    public String OCoHE(String a) {// 将八进制转为十进制再从十进制转为十六进制
        String b = Integer.toHexString(Integer.valueOf(a, 8));
        return b;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //十进制转二进制
    public String DEoBI(String a) {
        String b = Integer.toBinaryString(Integer.valueOf(a));
        return b;
    }

    //十进制转八进制
    public String DEoOC(String a) {
        String b = Integer.toOctalString(Integer.valueOf(a));
        return b;
    }

    //十进制转十六进制
    public String DEoHE(String a) {
        String b = Integer.toHexString(Integer.valueOf(a));
        return b;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 十六进制转二进制
    public String HEoBI(String a) {// 将十六进制转为十进制再从十进制转为二进制
        String b = Integer.toBinaryString(Integer.valueOf(a, 16));
        return b;
    }

    // 十六进制转八进制
    public String HEoOC(String a) {// 将十六进制转为十进制再从十进制转为八进制
        String b = Integer.toOctalString(Integer.valueOf(a, 16));
        return b;
    }

    //十六进制转十进制
    public String HEoDE(String a) { //将十六进制转为十进制
        String b = Integer.valueOf(a, 16).toString();
        return b;
    }
}
