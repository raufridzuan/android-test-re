package com.example.helloworld2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {
	final String TEST_STRING = new String("Hello TTT");
	final String FILE_NAME = "SAMPLEFILE.txt";
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buttonOK = (Button)findViewById(R.id.buttonOK);
        EditText answerBox1 = (EditText)findViewById(R.id.answerBox1);
        
        buttonOK.setOnClickListener(buttonOKListener);
        
        
        /*
        //
        //01 Print out directly "Hello <TEST_STRING>"
        //
        
        TextView tv = new TextView(this);
        fileCreate();
        tv.setText(readFile());
        setContentView(tv);
        */
        
        /*
        //
        //02 Print out 
        //
        TextView tv = new TextView(this);
        storageFileCreate();
        String rf = readStorageFile();
        tv.setText(rf);
        //setContentView(tv);
        */
        
        
        /*
        //03 Playing with IMEI and simserialnumber
        TelephonyManager telephonymanager = (TelephonyManager)getSystemService("phone");
        
        String s = telephonymanager.getDeviceId();
        
        
        TextView textview1 = new TextView(this);
        
        String s1 = (new StringBuilder("HardwareID 01: ")).append(s).toString();
        textview1.setText(s1);
        setContentView(textview1);
        
        String s2 = telephonymanager.getSimSerialNumber();
        TextView textview2 = new TextView(this);
        TextView textview3 = (TextView)findViewById(0x7f050001);
        String s3 = (new StringBuilder("HardwareID 02: ")).append(s2).toString();
        textview3.setText(s3);
        */
        
        
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    //01 
    private void fileCreate(){
    	try{
    		OutputStream os = openFileOutput(FILE_NAME, MODE_WORLD_READABLE);
    		OutputStreamWriter osw = new OutputStreamWriter(os);
    		osw.write(TEST_STRING);
    		osw.close();
    	}
    	catch (Exception e){
    		Log.i("MainActivity, fileCreate()", "Exception e = " + e);
    	}
    	
    }
    
    private String readFile(){
    	try{
    		FileInputStream fin = openFileInput(FILE_NAME);
    		InputStreamReader isReader = new InputStreamReader(fin);
    		char[] buffer = new char[TEST_STRING.length()];
    		isReader.read(buffer);
    		return new String(buffer);
    	}
    	catch (Exception e){
    		Log.i("MainActivity, fileCreate()", "Exception e = " + e);
    		return null;
    	}
    }
    
    
    //02    
    private void storageFileCreate(){
    	File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
    	FileOutputStream fos;
    	byte[] data = new String("R3v3R5|nG i5 FuN").getBytes();
    	try{
    		fos = new FileOutputStream(file);
    		fos.write(data);
    		fos.flush();
    		fos.close();
    	}
    	catch (Exception e){
    		Log.i("MainActivity, storageFileCreate()", "Exception e = " + e);
    	}
    	//SmsManager smsmanager = SmsManager.getDefault();
    	//smsmanager.sendTextMessage("5554", null, "Hello TTT", null, null);
    }
    
    private String readStorageFile(){
    	
    	try{
    		File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
        	FileInputStream fis = new FileInputStream(file);
        	StringBuffer text = new StringBuffer();
        	String line = null;
        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        	while ((line=bufferedReader.readLine())!= null){
        		text.append(line+'\n');
        	}
        	//byte[] data = new String("data to write to file").getBytes();
    		return text.toString();
    	}
    	catch (Exception e){
    		Log.i("MainActivity, readStorageFile()", "Exception e = " + e);
    		return null;
    	}
    }

    
}
