package com.example.hello.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by 龙阳 on 2017/9/20.
 */

public class unit_conversion extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private Button bt70;
    private Button bt71;
    private Button bt72;
    private Button bt73;
    private Button bt74;
    private Button bt75;
    private Button bt76;
    private Button bt77;
    private Button bt78;
    private Button bt79;
    private Button bt80;
    private Button bt81;
    private Button bt82;
    private Button bt83;
    private Button bt90;
    private Button bt91;
    private Button bt92;
    private Button bt93;
    private Button bt94;

    private int cm = 0;   //标记厘米按钮是否被选中
    private int dm = 0;   //标记分米按钮是否被选中
    private int m = 0;   //标记米按钮是否被选中
    private int km = 0;   //标记千米按钮是否被选中

    private double numcm = 0; //记录厘米文本框的数字
    private double numdm = 0; //记录分米文本框的数字
    private double numm = 0;  //记录米文本框的数字
    private double numkm = 0; //记录千米文本框的数字

    private String numcms = "";   //用于记录cm文本框的信息
    private String numdms = "";   //用于记录dm文本框的信息
    private String numms = "";    //用于记录m文本框的信息
    private String numkms = "";   //用于记录km文本框的信息

    private int dp2 = 0;   //判断当前数字是否输入了小数点
    private double dps2 = 1;  //小数点后几位

    private int lastequal3 = 0;   //标记上次是否点击了等号按钮

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_conversion);

        final EditText editText7 = (EditText) findViewById(R.id.editText7);
        final EditText editText8 = (EditText) findViewById(R.id.editText8);
        final EditText editText9 = (EditText) findViewById(R.id.editText9);
        final EditText editText10 = (EditText) findViewById(R.id.editText10);

        // 响应按钮7事件
        bt70 = (Button) findViewById(R.id.button70);
        bt70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 7;
                        editText7.setText(editText7.getText().toString() + "7");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 7 / dps2;
                        editText7.setText(editText7.getText().toString() + "7");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 7;
                        editText8.setText(editText8.getText().toString() + "7");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 7 / dps2;
                        editText8.setText(editText8.getText().toString() + "7");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 7;
                        editText9.setText(editText9.getText().toString() + "7");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 7 / dps2;
                        editText9.setText(editText9.getText().toString() + "7");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 7;
                        editText10.setText(editText10.getText().toString() + "7");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 7 / dps2;
                        editText10.setText(editText10.getText().toString() + "7");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮8事件
        bt71 = (Button) findViewById(R.id.button71);
        bt71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 8;
                        editText7.setText(editText7.getText().toString() + "8");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 8 / dps2;
                        editText7.setText(editText7.getText().toString() + "8");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 8;
                        editText8.setText(editText8.getText().toString() + "8");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 8 / dps2;
                        editText8.setText(editText8.getText().toString() + "8");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 8;
                        editText9.setText(editText9.getText().toString() + "8");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 8 / dps2;
                        editText9.setText(editText9.getText().toString() + "8");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 8;
                        editText10.setText(editText10.getText().toString() + "8");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 8 / dps2;
                        editText10.setText(editText10.getText().toString() + "8");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮9事件
        bt72 = (Button) findViewById(R.id.button72);
        bt72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 9;
                        editText7.setText(editText7.getText().toString() + "9");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 9 / dps2;
                        editText7.setText(editText7.getText().toString() + "9");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 9;
                        editText8.setText(editText8.getText().toString() + "9");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 9 / dps2;
                        editText8.setText(editText8.getText().toString() + "9");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 9;
                        editText9.setText(editText9.getText().toString() + "9");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 9 / dps2;
                        editText9.setText(editText9.getText().toString() + "9");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 9;
                        editText10.setText(editText10.getText().toString() + "9");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 9 / dps2;
                        editText10.setText(editText10.getText().toString() + "9");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮4事件
        bt73 = (Button) findViewById(R.id.button73);
        bt73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 4;
                        editText7.setText(editText7.getText().toString() + "4");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 4 / dps2;
                        editText7.setText(editText7.getText().toString() + "4");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 4;
                        editText8.setText(editText8.getText().toString() + "4");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 4 / dps2;
                        editText8.setText(editText8.getText().toString() + "4");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 4;
                        editText9.setText(editText9.getText().toString() + "4");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 4 / dps2;
                        editText9.setText(editText9.getText().toString() + "4");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 4;
                        editText10.setText(editText10.getText().toString() + "4");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 4 / dps2;
                        editText10.setText(editText10.getText().toString() + "4");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮5事件
        bt74 = (Button) findViewById(R.id.button74);
        bt74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 5;
                        editText7.setText(editText7.getText().toString() + "5");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 5 / dps2;
                        editText7.setText(editText7.getText().toString() + "5");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 5;
                        editText8.setText(editText8.getText().toString() + "5");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 5 / dps2;
                        editText8.setText(editText8.getText().toString() + "5");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 5;
                        editText9.setText(editText9.getText().toString() + "5");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 5 / dps2;
                        editText9.setText(editText9.getText().toString() + "5");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 5;
                        editText10.setText(editText10.getText().toString() + "5");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 5 / dps2;
                        editText10.setText(editText10.getText().toString() + "5");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮6事件
        bt75 = (Button) findViewById(R.id.button75);
        bt75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 6;
                        editText7.setText(editText7.getText().toString() + "6");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 6 / dps2;
                        editText7.setText(editText7.getText().toString() + "6");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 6;
                        editText8.setText(editText8.getText().toString() + "6");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 6 / dps2;
                        editText8.setText(editText8.getText().toString() + "6");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 6;
                        editText9.setText(editText9.getText().toString() + "6");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 6 / dps2;
                        editText9.setText(editText9.getText().toString() + "6");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 6;
                        editText10.setText(editText10.getText().toString() + "6");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 6 / dps2;
                        editText10.setText(editText10.getText().toString() + "6");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮1事件
        bt76 = (Button) findViewById(R.id.button76);
        bt76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 1;
                        editText7.setText(editText7.getText().toString() + "1");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 1 / dps2;
                        editText7.setText(editText7.getText().toString() + "1");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 1;
                        editText8.setText(editText8.getText().toString() + "1");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 1 / dps2;
                        editText8.setText(editText8.getText().toString() + "1");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 1;
                        editText9.setText(editText9.getText().toString() + "1");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 1 / dps2;
                        editText9.setText(editText9.getText().toString() + "1");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 1;
                        editText10.setText(editText10.getText().toString() + "1");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 1 / dps2;
                        editText10.setText(editText10.getText().toString() + "1");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮2事件
        bt77 = (Button) findViewById(R.id.button77);
        bt77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 2;
                        editText7.setText(editText7.getText().toString() + "2");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 2 / dps2;
                        editText7.setText(editText7.getText().toString() + "2");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 2;
                        editText8.setText(editText8.getText().toString() + "2");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 2 / dps2;
                        editText8.setText(editText8.getText().toString() + "2");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 2;
                        editText9.setText(editText9.getText().toString() + "2");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 2 / dps2;
                        editText9.setText(editText9.getText().toString() + "2");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 2;
                        editText10.setText(editText10.getText().toString() + "2");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 2 / dps2;
                        editText10.setText(editText10.getText().toString() + "2");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮3事件
        bt78 = (Button) findViewById(R.id.button78);
        bt78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 3;
                        editText7.setText(editText7.getText().toString() + "3");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 3 / dps2;
                        editText7.setText(editText7.getText().toString() + "3");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 3;
                        editText8.setText(editText8.getText().toString() + "3");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 3 / dps2;
                        editText8.setText(editText8.getText().toString() + "3");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 3;
                        editText9.setText(editText9.getText().toString() + "3");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 3 / dps2;
                        editText9.setText(editText9.getText().toString() + "3");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 3;
                        editText10.setText(editText10.getText().toString() + "3");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 3 / dps2;
                        editText10.setText(editText10.getText().toString() + "3");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮0事件
        bt79 = (Button) findViewById(R.id.button79);
        bt79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cm == 1) {
                    if (dp2 == 0) {
                        numcm = numcm * 10 + 0;
                        editText7.setText(editText7.getText().toString() + "0");
                    } else {
                        dps2 = dps2 * 10;
                        numcm = numcm + 0 / dps2;
                        editText7.setText(editText7.getText().toString() + "0");
                    }
                } else if (dm == 1) {
                    if (dp2 == 0) {
                        numdm = numdm * 10 + 0;
                        editText8.setText(editText8.getText().toString() + "0");
                    } else {
                        dps2 = dps2 * 10;
                        numdm = numdm + 0 / dps2;
                        editText8.setText(editText8.getText().toString() + "0");
                    }
                } else if (m == 1) {
                    if (dp2 == 0) {
                        numm = numm * 10 + 0;
                        editText9.setText(editText9.getText().toString() + "0");
                    } else {
                        dps2 = dps2 * 10;
                        numm = numm + 0 / dps2;
                        editText9.setText(editText9.getText().toString() + "0");
                    }
                } else if (km == 1) {
                    if (dp2 == 0) {
                        numkm = numkm * 10 + 0;
                        editText10.setText(editText10.getText().toString() + "0");
                    } else {
                        dps2 = dps2 * 10;
                        numkm = numkm + 0 / dps2;
                        editText10.setText(editText10.getText().toString() + "0");
                    }
                }
                lastequal3 = 0;
            }
        });

        // 响应按钮.事件
        bt80 = (Button) findViewById(R.id.button80);
        bt80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dp2 == 1) {
                    editText7.setText(editText7.getText().toString());
                    editText8.setText(editText8.getText().toString());
                    editText9.setText(editText9.getText().toString());
                    editText10.setText(editText10.getText().toString());
                } else {
                    if (cm == 1) {
                        editText7.setText(editText7.getText().toString() + ".");
                    } else if (dm == 1) {
                        editText8.setText(editText8.getText().toString() + ".");
                    } else if (m == 1) {
                        editText9.setText(editText9.getText().toString() + ".");
                    } else if (km == 1) {
                        editText10.setText(editText10.getText().toString() + ".");
                    }
                }
                dp2 = 1;
            }
        });

        // 响应按钮CE事件
        bt81 = (Button) findViewById(R.id.button81);
        bt81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm = 0;
                dm = 0;
                m = 0;
                km = 0;
                numcm = 0;
                numdm = 0;
                numm = 0;
                numkm = 0;
                dp2 = 0;
                dps2 = 0;
                editText7.setText("");
                editText8.setText("");
                editText9.setText("");
                editText10.setText("");
            }
        });

        // 响应按钮←事件
        bt82 = (Button) findViewById(R.id.button82);
        bt82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastequal3 = 0;
                if (cm == 1) {
                    numcms = editText7.getText().toString();
                    if (numcms.equals("")) {
                        editText7.setText(editText7.getText().toString());
                    } else {
                        numcms = numcms.substring(0, numcms.length() - 1);
                        editText7.setText(numcms);
                        if (numcms.length() == 0) {
                            numcm = 0;
                        } else {
                            numcm = Double.valueOf(numcms.toString());
                        }
                    }
                } else if (dm == 1) {
                    numdms = editText8.getText().toString();
                    if (numdms.equals("")) {
                        editText8.setText(editText8.getText().toString());
                    } else {
                        numdms = numdms.substring(0, numdms.length() - 1);
                        editText8.setText(numdms);
                        if (numdms.length() == 0) {
                            numdm = 0;
                        } else {
                            numdm = Double.valueOf(numdms.toString());
                        }
                    }
                } else if (m == 1) {
                    numms = editText9.getText().toString();
                    if (numms.equals("")) {
                        editText9.setText(editText9.getText().toString());
                    } else {
                        numms = numms.substring(0, numms.length() - 1);
                        editText9.setText(numms);
                        if (numms.length() == 0) {
                            numm = 0;
                        } else {
                            numm = Double.valueOf(numms.toString());
                        }
                    }
                } else if (km == 1) {
                    numkms = editText9.getText().toString();
                    if (numkms.equals("")) {
                        editText9.setText(editText9.getText().toString());
                    } else {
                        numkms = numkms.substring(0, numkms.length() - 1);
                        editText9.setText(numkms);
                        if (numkms.length() == 0) {
                            numkm = 0;
                        } else {
                            numkm = Double.valueOf(numkms.toString());
                        }
                    }
                }
            }
        });

        // 响应按钮=事件
        bt83 = (Button) findViewById(R.id.button83);
        bt83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastequal3 == 1) {
                    editText7.setText(editText7.getText().toString());
                    editText8.setText(editText8.getText().toString());
                    editText9.setText(editText9.getText().toString());
                    editText10.setText(editText10.getText().toString());
                } else {
                    if (cm == 1) {
                        numdm = numcm / 10;
                        numm = numdm / 10;
                        numkm = numm / 1000;

                        /*editText7.setText("" + numcm);
                        editText8.setText("" + numdm);
                        editText9.setText("" + numm);
                        editText10.setText("" + numkm);*/

                        int a = (int) numcm;
                        int s = (int) numdm;
                        int d = (int) numm;
                        int f = (int) numkm;

                        float z = (float) numcm;
                        float x = (float) numdm;
                        float c = (float) numm;
                        float b = (float) numkm;

                        if (numkm - f == 0) {
                            editText7.setText("" + a);
                            editText8.setText("" + s);
                            editText9.setText("" + d);
                            editText10.setText("" + f);
                        } else {
                            editText7.setText("" + z);
                            editText8.setText("" + x);
                            editText9.setText("" + c);
                            editText10.setText("" + b);
                        }
                    } else if (dm == 1) {
                        numcm = numdm * 10;
                        numm = numdm / 10;
                        numkm = numm / 1000;

                        int a = (int) numcm;
                        int s = (int) numdm;
                        int d = (int) numm;
                        int f = (int) numkm;

                        float z = (float) numcm;
                        float x = (float) numdm;
                        float c = (float) numm;
                        float b = (float) numkm;

                        if (numcm - a == 0) {
                            editText7.setText("" + a);
                        } else {
                            editText7.setText("" + z);
                        }
                        if (numdm - s == 0) {
                            editText8.setText("" + s);
                        } else {
                            editText8.setText("" + x);
                        }
                        if (numm - d == 0) {
                            editText9.setText("" + d);
                        } else {
                            editText9.setText("" + c);
                        }
                        if (numkm - f == 0) {
                            editText10.setText("" + f);
                        } else {
                            editText10.setText("" + b);
                        }

                    } else if (m == 1) {
                        numdm = numm * 10;
                        numcm = numdm * 10;
                        numkm = numm / 100;

                        int a = (int) numcm;
                        int s = (int) numdm;
                        int d = (int) numm;
                        int f = (int) numkm;

                        float z = (float) numcm;
                        float x = (float) numdm;
                        float c = (float) numm;
                        float b = (float) numkm;

                        if (numcm - a == 0) {
                            editText7.setText("" + a);
                        } else {
                            editText7.setText("" + z);
                        }
                        if (numdm - s == 0) {
                            editText8.setText("" + s);
                        } else {
                            editText8.setText("" + x);
                        }
                        if (numm - d == 0) {
                            editText9.setText("" + d);
                        } else {
                            editText9.setText("" + c);
                        }
                        if (numkm - f == 0) {
                            editText10.setText("" + f);
                        } else {
                            editText10.setText("" + b);
                        }
                    } else if (km == 1) {
                        numm = numkm * 1000;
                        numdm = numm * 10;
                        numcm = numdm * 10;

                        int a = (int) numcm;
                        int s = (int) numdm;
                        int d = (int) numm;
                        int f = (int) numkm;

                        float z = (float) numcm;
                        float x = (float) numdm;
                        float c = (float) numm;
                        float b = (float) numkm;

                        if (numcm - a == 0) {
                            editText7.setText("" + a);
                        } else {
                            editText7.setText("" + z);
                        }
                        if (numdm - s == 0) {
                            editText8.setText("" + s);
                        } else {
                            editText8.setText("" + x);
                        }
                        if (numm - d == 0) {
                            editText9.setText("" + d);
                        } else {
                            editText9.setText("" + c);
                        }
                        if (numkm - f == 0) {
                            editText10.setText("" + f);
                        } else {
                            editText10.setText("" + b);
                        }
                    }
                }
                lastequal3 = 1;
            }
        });

        // 响应按钮cm事件
        bt91 = (Button) findViewById(R.id.button91);
        bt91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm = 1;
                dm = 0;
                m = 0;
                km = 0;
            }
        });

        // 响应按钮dm事件
        bt92 = (Button) findViewById(R.id.button92);
        bt92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm = 0;
                dm = 1;
                m = 0;
                km = 0;
            }
        });

        // 响应按钮m事件
        bt93 = (Button) findViewById(R.id.button93);
        bt93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm = 0;
                dm = 0;
                m = 1;
                km = 0;
            }
        });

        // 响应按钮km事件
        bt94 = (Button) findViewById(R.id.button94);
        bt94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm = 0;
                dm = 0;
                m = 0;
                km = 1;
            }
        });

        // 响应按钮菜单栏事件
        bt90 = (Button) findViewById(R.id.button90);
        bt90.setOnClickListener(this);
    }

    public void onClick(View v) {
        //创建弹出式菜单对象（最低版本11）
        PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
        //获取菜单填充器
        MenuInflater inflater = popup.getMenuInflater();
        //填充菜单
        inflater.inflate(R.menu.menu_unit, popup.getMenu());
        //绑定菜单项的点击事件
        popup.setOnMenuItemClickListener(this);
        //显示(这一行代码不要忘记了)
        popup.show();

    }

    //弹出式菜单的单击事件处理
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.decimal_conversion:
                //onclick1();
                break;
            case R.id.unit_conversion:
                //onclick2();
                break;
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
        return false;
    }
}
