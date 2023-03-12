package guess.com.guess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ToggleButton;

public class GuessActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        Button bn1=(Button)findViewById(R.id.b1);
        Button bn2=(Button)findViewById(R.id.b2);
        final ToggleButton t=(ToggleButton)findViewById(R.id.toggleButton1);
        final boolean so=getIntent().getBooleanExtra("So", true);
        t.setChecked(so);
        bn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(getApplicationContext(),GuessplayActivity.class);
				i1.putExtra("s",t.isChecked());
				startActivity(i1);
			}
		});
        bn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2=new Intent(getApplicationContext(),GuesshelpActivity.class);
				startActivity(i2);
			}
		});
    }
}