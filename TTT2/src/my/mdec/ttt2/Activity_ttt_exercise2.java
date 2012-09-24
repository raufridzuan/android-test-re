package my.mdec.ttt2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_ttt_exercise2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttt_exercise2);
        
        Button buttonOK = (Button)findViewById(R.id.buttonOK);
        EditText answerBox1 = (EditText)findViewById(R.id.answerBox1);
        
        buttonOK.setOnClickListener(buttonOKListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ttt_exercise2, menu);
        return true;
    }
    private OnClickListener buttonOKListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		EditText text = (EditText)findViewById(R.id.answerBox1);
    		String answer = getResources().getString(R.string.first);
    		
    		
    		//success
    		if(answer.equals(text.getText().toString())){
    			Toast.makeText(getBaseContext(), 
        				getResources().getString(R.string.yay),
        				Toast.LENGTH_LONG).show();	
    			Log.i("Given Text Success", text.getText().toString());
    			
    		}
    		else{
    			Toast.makeText(getBaseContext(), 
    					getResources().getString(R.string.nay),
        				Toast.LENGTH_LONG).show();
    			Log.i("Given Text Fail", text.getText().toString());
    			
    		}
    	}
    };
}
