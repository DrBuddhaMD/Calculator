package calculator.tigerbudda.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class calculator extends Activity {

    TextView d;
    EditText firstNumber;
    EditText secondNumber;
    String finalAnswer;
    Button b;
    Spinner s;
    int operatorId = 1;
    double numberOne;
    double numberTwo;
    String[] operators = {"Add(+)", "Subtract(-)", "Multiply(x)", "Divide(/)"};
    String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        d=(TextView)findViewById(R.id.answerView);
        firstNumber=(EditText)findViewById(R.id.numberOne);
        secondNumber=(EditText)findViewById(R.id.numberTwo);
        b=(Button)findViewById(R.id.calculateButton);
        s=(Spinner)findViewById(R.id.operationPicker);

        //Display place holder in the solution area.
        d.setText("SOLUTION");

        //Setup spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(calculator.this, android.R.layout.simple_spinner_item, operators);
        s.setAdapter(adapter);

        //Load first number into numberOne, operation to operatorId, second number into numberTwo

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Load numberOne
                numberOne = Double.parseDouble(firstNumber.getText().toString());

                //Load operator
                operatorId = s.getSelectedItemPosition();

                //Load numberTwo
                numberTwo = Double.parseDouble(secondNumber.getText().toString());

                //Calculation method: Operation
                finalAnswer = Double.toString(operation(numberOne, numberTwo, operatorId));


                //Display Answer
                d.setText(finalAnswer);

            }
        });



    }


    public double operation( double numberOne, double numberTwo, int operatorId){

        double result = 0;

        switch(operatorId){
            case 0:
                result = numberOne + numberTwo;
                break;
            case 1:
                result = Math.abs(numberOne - numberTwo);
                break;
            case 2:
                result = numberOne * numberTwo;
                break;
            case 3:
                //TODO operation for numberTwo = 0
                if(numberTwo == 0){
                    error = "Cannot Divide by 0";
                    break;
                }
                result = numberOne / numberTwo;
                break;
        }


        return result;

    }

}
