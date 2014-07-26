package calculator.tigerbudda.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class calculator extends Activity {

    //Operation Variables
    double numberOne;
    int operatorId = 1;
    String[] operators = {"Add(+)", "Subtract(-)", "Multiply(x)", "Divide(/)","Exponent(^)", "Square Root(√)"};
    String error = null;
    double numberTwo;
    String finalAnswer;

    //Display objects and Variables
    EditText firstNumber;
    Spinner s;
    EditText secondNumber;
    Button b;
    TextView d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Initialization of components
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

        //Initialzing doubles to ensure no crashes
        numberOne = 0;
        numberTwo = 0;

        /*
         * Load first number into numberOne
         * operation to operatorId
         * second number into numberTwo
         * Perform Operations
         * Assign finalAnswer
         * Display Answer
         */
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Load numberOne
                numberOne = Double.parseDouble(firstNumber.getText().toString());

                //Load operator
                operatorId = s.getSelectedItemPosition();

                //Load numberTwo
                if(operatorId == 5){
                    numberTwo = 0;

                }else{
                    numberTwo = Double.parseDouble(secondNumber.getText().toString());
                }



                //Calculation method: Operation
                finalAnswer = operation(numberOne, numberTwo, operatorId);

                //Display Answer
                d.setText(finalAnswer);

            }
        });



    }


    public String operation( double numberOne, double numberTwo, int operatorId){

        //Variables
        String answer;
        double result = 0;

        //Choosing operation depending on operatorId
        /*  0 --> Addition
         *  1 --> Subtraction
         *  2 --> Division
         *  3 --> Multiplication
         */
        switch(operatorId){
            case 0:
                result = numberOne + numberTwo;
                break;
            case 1:
                result = numberOne - numberTwo;
                break;
            case 2:
                result = numberOne * numberTwo;
                break;
            case 3:
                //Error if number is 0.
                if(numberTwo == 0){
                    error = "Cannot Divide by 0";
                    answer = error;
                    return answer;
                }
                result = numberOne / numberTwo;
                break;
            case 4:
                result = Math.pow(numberOne, numberTwo);
                break;
            case 5:
                if( numberOne/Math.abs(numberOne) == -1 ) {

                    result = Math.sqrt(Math.abs(numberOne));
                    answer = result + "i";
                    return answer;

                }
                else{
                    result = Math.sqrt(numberOne);
                }

                break;


        }


        //Round the decimals
        result = (double)Math.round(result * 1000)/1000;

        //Convert answer into String
        answer = Double.toString(result);

        return answer;

    }

}
