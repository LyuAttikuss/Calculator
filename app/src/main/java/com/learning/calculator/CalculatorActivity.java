package com.learning.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private Button mOne, mTwo, mThree, mFour, mFive, mSix, mSeven, mEight, mNine, mZero,
            mAdd, mSubtract, mDivide, mMultiple, mDelete, mBack, mPoint, mSign, mPercent, mCalc;

    private TextView mResult;
    private EditText mExpression;

    private double valueOne;
    private double valueTwo;
    private boolean addition, substract, multiplication, division, percents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initNumbers();
        initOperations();
    }

    private void initNumbers() {
        mOne = (Button)findViewById(R.id.n_one);
        mTwo = (Button)findViewById(R.id.n_two);
        mThree = (Button)findViewById(R.id.n_three);
        mFour = (Button)findViewById(R.id.n_four);
        mFive = (Button)findViewById(R.id.n_five);
        mSix = (Button)findViewById(R.id.n_six);
        mSeven = (Button)findViewById(R.id.n_seven);
        mEight = (Button)findViewById(R.id.n_eight);
        mNine = (Button)findViewById(R.id.n_nine);
        mZero = (Button)findViewById(R.id.n_zero);

        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 1);
            }
        });

        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 2);
            }
        });

        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 3);
            }
        });

        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 4);
            }
        });

        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 5);
            }
        });

        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 6);
            }
        });

        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 7);
            }
        });

        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 8);
            }
        });

        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 9);
            }
        });

        mZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + 0);
            }
        });
    }

    private void initOperations() {
        mAdd = (Button)findViewById(R.id.add);
        mSubtract = (Button)findViewById(R.id.substruct);
        mDivide = (Button)findViewById(R.id.divide);
        mMultiple = (Button)findViewById(R.id.multiple);
        mDelete = (Button)findViewById(R.id.delete);
        mBack = (Button)findViewById(R.id.backspace);
        mPoint = (Button)findViewById(R.id.point);
        mSign = (Button)findViewById(R.id.sign);
        mPercent = (Button)findViewById(R.id.percent);
        mCalc = (Button)findViewById(R.id.calc);

        mResult = (TextView)findViewById(R.id.result);
        mExpression = (EditText)findViewById(R.id.expression);

        // TODO: добавить замену операции
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                valueOne = Double.parseDouble(expr);
                setExpression(expr + "+");
                addition = true;
            }
        });

        mSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                valueOne = Double.parseDouble(expr);
                setExpression(expr + "-");
                substract = true;
            }
        });

        mMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                valueOne = Double.parseDouble(expr);
                setExpression(expr + "*");
                multiplication = true;
            }
        });

        mDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                valueOne = Double.parseDouble(expr);
                setExpression(expr + "/");
                division = true;
            }
        });

        mPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                valueOne = Double.parseDouble(expr);
                setExpression(expr + "%");
                percents = true;
            }
        });

        mPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression(mExpression.getText().toString() + ".");
            }
        });

        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();

                if (expr.length() > 0) {
                    String exprPart = expr;

                    while (exprPart.length() > 0 && "+-/*".indexOf(exprPart.charAt(exprPart.length() - 1)) == -1) {
                        exprPart = exprPart.substring(0, exprPart.length() - 1);
                    }

                    if (exprPart.length() > 0 &&
                            (exprPart.charAt(0) == '-' || "+-/*".indexOf(exprPart.charAt(exprPart.length() - 2)) != -1)) {
                        exprPart = exprPart.substring(0, exprPart.length() - 1);
                    }

                    String lastValue = expr.substring(exprPart.length(), expr.length());
                    lastValue = (lastValue.charAt(0) == '-') ? lastValue.substring(1) : ("-" + lastValue);

                    setExpression(exprPart + lastValue);
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                if (expr.length() > 0) {
                    setExpression(expr.substring(0, expr.length() - 1));
                }
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpression("");
                mResult.setText("");
            }
        });

        // TODO: множественные операции
        mCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expr = mExpression.getText().toString();
                String exprPart = expr;

                while (exprPart.length() > 0 && "+-/*%".indexOf(exprPart.charAt(exprPart.length() - 1)) == -1) {
                    exprPart = exprPart.substring(0, exprPart.length() - 1);
                }

                if (exprPart.length() > 0 &&
                        (exprPart.charAt(0) == '-' || "+-/*%".indexOf(exprPart.charAt(exprPart.length() - 2)) != -1)) {
                    exprPart = exprPart.substring(0, exprPart.length() - 1);
                }

                String lastValue = expr.substring(exprPart.length(), expr.length());
                valueTwo = Double.parseDouble(lastValue);

                if (addition) {
                    Double result = valueOne + valueTwo;
                    setExpression(result.toString());
                    addition = false;
                }
                if (substract) {
                    Double result = valueOne - valueTwo;
                    setExpression(result.toString());
                    substract = false;
                }
                if (division) {
                    Double result = valueOne / valueTwo;
                    setExpression(result.toString());
                    division = false;
                }
                if (multiplication) {
                    Double result = valueOne * valueTwo;
                    setExpression(result.toString());
                    multiplication = false;
                }
                if (percents) {
                    Double result = valueOne * valueTwo / 100;
                    setExpression(result.toString());
                    percents = false;
                }
            }
        });
    }

    private void setExpression(String expression) {
        mExpression.setText(expression);
        mExpression.setSelection(mExpression.getText().length());
    }

    private void getLastValue() {

    }
}
