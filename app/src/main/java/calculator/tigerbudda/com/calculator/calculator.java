package calculator.tigerbudda.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class calculator extends Activity {

    TextView disp;
    EditText firstNumber;
    EditText secondNumber;
    String finalAnswer;
    int operatorId;
    double numberOne;
    double numberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Load first number into numberOne

        //Display First number
        firstNumber=(EditText)findViewById(R.id.numberOne);
        firstNumber.setText(new Double(numberOne).toString());

        //Load second number into numberTwo

        //Display Second number
        secondNumber=(EditText)findViewById(R.id.numberTwo);
        secondNumber.setText(new Double(numberTwo).toString());
        int i = 0;


        //Calculation method: Operation

        finalAnswer = Double.toString(operation(numberOne, numberTwo));



        //Display Answer
        disp=(TextView)findViewById(R.id.answerView);
        disp.setText(new Double(finalAnswer).toString());






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public double operation( double numberOne, double numberTwo){

        double result = 0;

        switch(operatorId){
            case 1:
                result = numberOne + numberTwo;
                break;
            case 2:
                result = Math.abs(numberOne - numberTwo);
                break;
            case 3:
                result = numberOne * numberTwo;
                break;
            case 4:
                //TODO operation for numberTwo = 0
                result = numberOne * numberTwo;
                break;
        }


        return result;

    }

}
