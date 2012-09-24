package my.mdec.ttt1;

import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTTTExercise1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttt_exercise1);
        
        Button buttonOK = (Button)findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(buttonOKListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ttt_exercise1, menu);
        return true;
    }
    
    private OnClickListener buttonOKListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		EditText inputAnswer = (EditText)findViewById(R.id.answerBox1);
    		
    		//Hex to Ascii
    		String TTT = "545454";
	    	StringBuilder output1 = new StringBuilder();
	    	for (int i =0; i < TTT.length(); i+=2){
	    		String str = TTT.substring(i, i+2);
	    		output1.append((char)Integer.parseInt(str,16));
	    	}
	    	//Log.i("Output1", output1.toString());
	    	
	    	//Dec to Ascii
	    	byte[] iscool = {32, 105, 115, 32, 99, 111, 111, 108, 33};
	    	StringBuilder output3 = new StringBuilder(iscool.length);
	    	for (int j=0; j < iscool.length; j++){
	    		output3.append((char)iscool[j]);
	    	}
	    	//Log.i("Output3", output3.toString());
	    	
	    	//Simple getting value from calendar
	    	Calendar calendar = Calendar.getInstance();
	    	int thisyear = calendar.get(Calendar.YEAR);
	    	String output2 = Integer.toString(thisyear);
	    	//Log.i("Output2", output2);
	    	
	    	String givenAnswer = output1.toString().concat(output2).concat(output3.toString());
	    	//Log.i("Practise 1", exactAnswer);
	    	
    		//success
    		if(givenAnswer.equals(inputAnswer.getText().toString())){
    			Toast.makeText(getBaseContext(), 
        				"Well done! Good job!",
        				Toast.LENGTH_LONG).show();	
    			Log.i("Given Text Success", inputAnswer.getText().toString());
    			
    		}
    		else{ //fail
    			Toast.makeText(getBaseContext(), 
    					"Try again..",
        				Toast.LENGTH_LONG).show();
    			Log.i("Given Text Fail", inputAnswer.getText().toString());
    			
    		}
    	}
    };

}
