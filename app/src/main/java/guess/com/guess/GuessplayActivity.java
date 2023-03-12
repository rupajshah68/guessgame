package guess.com.guess;

import java.util.Random;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog; 
import android.content.DialogInterface; 
import android.content.Intent;
public class GuessplayActivity extends Activity{
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        StartAppSDK.init(this, "209917591", true);
	        StartAppAd.enableAutoInterstitial();
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.main2);
	        final boolean so=getIntent().getExtras().getBoolean("s");
	        final MediaPlayer m=MediaPlayer.create(getApplicationContext(), R.raw.wrong);
	        final MediaPlayer mr=MediaPlayer.create(getApplicationContext(), R.raw.right);
	        Button b1=(Button)findViewById(R.id.button1);
	        Button b2=(Button)findViewById(R.id.button2);
	        Button b3=(Button)findViewById(R.id.button3);
	        Button b4=(Button)findViewById(R.id.button4);
	        Button b5=(Button)findViewById(R.id.button5);
	        Button b6=(Button)findViewById(R.id.button6);
	        Button b7=(Button)findViewById(R.id.button7);
	        Button b8=(Button)findViewById(R.id.button8);
	        Button b9=(Button)findViewById(R.id.button9);
	        Random rand=new Random();
		    int gn=rand.nextInt(9753)+123;
		    int unit=gn%10;
		    gn=gn/10;
		    int tens=gn%10;
		    gn=gn/10;
		    int hun=gn%10;
		    gn=gn/10;
		    int th=gn;
		    while(!(unit!=tens && tens!=hun && hun!=th && th!=unit && unit!=hun && tens!=th))
		    {
		    	gn=rand.nextInt(10000)+100;
			    unit=gn%10;
			    gn=gn/10;
			    tens=gn%10;		
		    }
		    gn=th*1000+100*hun+10*tens+unit;
		    final int num=gn;
		    final int u=unit;
		    final int te=tens;
		    final int h=hun;
		    final int t=th;
		    b1.setOnClickListener(new OnClickListener() {
	        				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		TextView t2=(TextView)findViewById(R.id.textView2);
					EditText e1=(EditText)findViewById(R.id.editText1);
					if(e1.getText().length()==4)
					{
					e1.setEnabled(false);
					int n1=Integer.parseInt(e1.getText().toString());
					int g=n1;
					int unit1=n1%10;
					n1=n1/10;
					int tens1=n1%10;
					n1=n1/10;
					int hun1=n1%10;
					n1/=10;
					int th1=n1;
					if(g!=num)
					{
						if(so==true)
						{
							m.start();
						}
						int a=100,b=100,c=100,d=100;
						int i=0;
						int j=0;
						if(unit1==u)
						{
							i++;
							a=u;
						}
						if(tens1==te)
						{
							i++;
							b=te;
						}
						if(hun1==h)
						{
							i++;
							c=h;
						}
						if(th1==t)
						{
							i++;
							d=t;
						}
						if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
						{
						if(unit1==te || unit1==h || unit1==t)
						{
							j++;
						}
						if(tens1==t || tens1==h || tens1==u)
						{
							j++;
						}
						if(hun1==te || hun1==u || hun1==t)
						{
							j++;
						}
						if(th1==te || th1==h || th1==u)
						{
							j++;
						}
						}
						else
						{
							if(unit1!=tens1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
								{
									j++;
								}
								if(unit1!=hun1 && tens1!=hun1)
								{
									if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
									{
										j++;
									}
								}
								else if(unit1!=th1 && tens1!=th1)
									{
									if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
									{
										j++;
									}
								}
							}
							else if(unit1!=hun1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
								{
									j++;
								}
								if(unit1!=tens1 && tens1!=hun1)
								{
									if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
									{
										j++;
									}
								}
								else if(unit1!=th1 && hun1!=th1)
									{
									if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
									{
										j++;
									}
								}
							}
							else if(unit1!=th1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
								{
									j++;
								}
								if(unit1!=tens1 && tens1!=th1)
								{
									if(tens1==h || tens1==u || tens1==t)
									{
										j++;
									}
								}
								else if(unit1!=hun1 && hun1!=th1)
									{
									if(th1==h || th1==te || th1==u)
									{
										j++;
									}
								}
							}
							else
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
							}
						}
						t2.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
						TextView t3=(TextView)findViewById(R.id.textView3);
						EditText e2=(EditText)findViewById(R.id.editText2);
						Button b2=(Button)findViewById(R.id.button2);
						TextView t4=(TextView)findViewById(R.id.textView4);
						t3.setVisibility(1);
						e2.setVisibility(1);
						b2.setVisibility(1);
						t4.setVisibility(1);
					}
					else
					{
						if(so==true)
						{
							mr.start();
						}
						AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
    					alertDialog.setTitle("Congrats!");
    				    alertDialog.setMessage("You win.");
    				    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    			            public void onClick(DialogInterface dialog,int which) {
    			            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
    			            	i1.putExtra("So",so);
    							startActivity(i1);
    			            }
    			        });
    				    alertDialog.show();
					}		 
			}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
						alertDialog.setTitle("Entered number is invalid!");
					    alertDialog.setMessage("Please enter a four digit number.");
					    alertDialog.setCanceledOnTouchOutside(true);
					    alertDialog.show();
					}
	        				}
	    });
	        b2.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
					TextView t4=(TextView)findViewById(R.id.textView4);
					EditText e2=(EditText)findViewById(R.id.editText2);
					if(e2.getText().length()==4)
					{
					e2.setEnabled(false);
					int n1=Integer.parseInt(e2.getText().toString());
					int g=n1;
					int unit1=n1%10;
					n1=n1/10;
					int tens1=n1%10;
					n1=n1/10;
					int hun1=n1%10;
					n1/=10;
					int th1=n1;
					if(g!=num)
					{
						if(so==true)
						{
							m.start();
						}
						int a=100,b=100,c=100,d=100;
						int i=0;
						int j=0;
						if(unit1==u)
						{
							i++;
							a=u;
						}
						if(tens1==te)
						{
							i++;
							b=te;
						}
						if(hun1==h)
						{
							i++;
							c=h;
						}
						if(th1==t)
						{
							i++;
							d=t;
						}
						if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
						{
						if(unit1==te || unit1==h || unit1==t)
						{
							j++;
						}
						if(tens1==t || tens1==h || tens1==u)
						{
							j++;
						}
						if(hun1==te || hun1==u || hun1==t)
						{
							j++;
						}
						if(th1==te || th1==h || th1==u)
						{
							j++;
						}
						}
						else
						{
							if(unit1!=tens1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
								{
									j++;
								}
								if(unit1!=hun1 && tens1!=hun1)
								{
									if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
									{
										j++;
									}
								}
								else if(unit1!=th1 && tens1!=th1)
									{
									if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
									{
										j++;
									}
								}
							}
							else if(unit1!=hun1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
								{
									j++;
								}
								if(unit1!=tens1 && tens1!=hun1)
								{
									if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
									{
										j++;
									}
								}
								else if(unit1!=th1 && hun1!=th1)
									{
									if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
									{
										j++;
									}
								}
							}
							else if(unit1!=th1)
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
								if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
								{
									j++;
								}
								if(unit1!=tens1 && tens1!=th1)
								{
									if(tens1==h || tens1==u || tens1==t)
									{
										j++;
									}
								}
								else if(unit1!=hun1 && hun1!=th1)
									{
									if(th1==h || th1==te || th1==u)
									{
										j++;
									}
								}
							}
							else
							{
								if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
								{
									j++;
								}
							}
						}
						t4.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
						TextView t5=(TextView)findViewById(R.id.textView5);
						EditText e3=(EditText)findViewById(R.id.editText3);
						Button b3=(Button)findViewById(R.id.button3);
						TextView t6=(TextView)findViewById(R.id.textView6);
						t6.setVisibility(1);
						e3.setVisibility(1);
						b3.setVisibility(1);
						t5.setVisibility(1);
					}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
    					alertDialog.setTitle("Congrats!");
    				    alertDialog.setMessage("You win.");
    				    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    			            public void onClick(DialogInterface dialog,int which) {
    			            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
    			            	i1.putExtra("So",so);
    							startActivity(i1);
    			            }
    			        });
    				    alertDialog.show();
					}
	        					
	        			 
			}
					else
					{
						if(so==true)
						{
							mr.start();
						}
						AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
						alertDialog.setTitle("Entered number is invalid!");
					    alertDialog.setMessage("Please enter a four digit number.");
					    alertDialog.setCanceledOnTouchOutside(true);
					    alertDialog.show();
					}
				}	
	        }	
			 
);
	        b3.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t6=(TextView)findViewById(R.id.textView6);
		EditText e3=(EditText)findViewById(R.id.editText3);
		if(e3.getText().length()==4)
		{
		e3.setEnabled(false);
		int n1=Integer.parseInt(e3.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t6.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t7=(TextView)findViewById(R.id.textView7);
			EditText e4=(EditText)findViewById(R.id.editText4);
			Button b4=(Button)findViewById(R.id.button4);
			TextView t8=(TextView)findViewById(R.id.textView10);
			t7.setVisibility(1);
			e4.setVisibility(1);
			b4.setVisibility(1);
			t8.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
	}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
				}
});
	        b4.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t8=(TextView)findViewById(R.id.textView8);
		EditText e4=(EditText)findViewById(R.id.editText4);
		if(e4.getText().length()==4)
		{
		e4.setEnabled(false);
		int n1=Integer.parseInt(e4.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t8.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t9=(TextView)findViewById(R.id.textView9);
			EditText e5=(EditText)findViewById(R.id.editText5);
			Button b5=(Button)findViewById(R.id.button5);
			TextView t10=(TextView)findViewById(R.id.textView10);
			t9.setVisibility(1);
			e5.setVisibility(1);
			b5.setVisibility(1);
			t10.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
	            	startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	        b5.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t10=(TextView)findViewById(R.id.textView10);
		EditText e5=(EditText)findViewById(R.id.editText5);
		if(e5.getText().length()==4)
		{
		e5.setEnabled(false);
		int n1=Integer.parseInt(e5.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t10.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t11=(TextView)findViewById(R.id.textView11);
			EditText e6=(EditText)findViewById(R.id.editText6);
			Button b6=(Button)findViewById(R.id.button6);
			TextView t12=(TextView)findViewById(R.id.textView12);
			t11.setVisibility(1);
			e6.setVisibility(1);
			b6.setVisibility(1);
			t12.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}				
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	        b6.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t12=(TextView)findViewById(R.id.textView12);
		EditText e6=(EditText)findViewById(R.id.editText6);
		if(e6.getText().length()==4)
		{
		e6.setEnabled(false);
		int n1=Integer.parseInt(e6.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t12.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t13=(TextView)findViewById(R.id.textView13);
			EditText e7=(EditText)findViewById(R.id.editText7);
			Button b7=(Button)findViewById(R.id.button7);
			TextView t14=(TextView)findViewById(R.id.textView14);
			t13.setVisibility(1);
			e7.setVisibility(1);
			b7.setVisibility(1);
			t14.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}			
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	        b7.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t14=(TextView)findViewById(R.id.textView14);
		EditText e7=(EditText)findViewById(R.id.editText7);
		if(e7.getText().length()==4)
		{
		e7.setEnabled(false);
		int n1=Integer.parseInt(e7.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t14.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t15=(TextView)findViewById(R.id.textView15);
			EditText e8=(EditText)findViewById(R.id.editText8);
			Button b8=(Button)findViewById(R.id.button8);
			TextView t16=(TextView)findViewById(R.id.textView16);
			t15.setVisibility(1);
			e8.setVisibility(1);
			b8.setVisibility(1);
			t16.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	        b8.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView t16=(TextView)findViewById(R.id.textView16);
		EditText e8=(EditText)findViewById(R.id.editText8);
		if(e8.getText().length()==4)
		{
		e8.setEnabled(false);
		int n1=Integer.parseInt(e8.getText().toString());
		int g=n1;
		int unit1=n1%10;
		n1=n1/10;
		int tens1=n1%10;
		n1=n1/10;
		int hun1=n1%10;
		n1/=10;
		int th1=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			int a=100,b=100,c=100,d=100;
			int i=0;
			int j=0;
			if(unit1==u)
			{
				i++;
				a=u;
			}
			if(tens1==te)
			{
				i++;
				b=te;
			}
			if(hun1==h)
			{
				i++;
				c=h;
			}
			if(th1==t)
			{
				i++;
				d=t;
			}
			if(unit1!=tens1 && unit1!=hun1 && unit1!=th1 && tens1!=hun1 && tens1!=th1 && hun1!=th1)
			{
			if(unit1==te || unit1==h || unit1==t)
			{
				j++;
			}
			if(tens1==t || tens1==h || tens1==u)
			{
				j++;
			}
			if(hun1==te || hun1==u || hun1==t)
			{
				j++;
			}
			if(th1==te || th1==h || th1==u)
			{
				j++;
			}
			}
			else
			{
				if(unit1!=tens1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((tens1==t || tens1==h || tens1==u) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
					{
						j++;
					}
					if(unit1!=hun1 && tens1!=hun1)
					{
						if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && tens1!=th1)
						{
						if((th1==te || th1==h || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=hun1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((hun1==te || hun1==u || hun1==t) && hun1!=a && hun1!=b && hun1!=c && hun1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=hun1)
					{
						if((tens1==h || tens1==u || tens1==t) && tens1!=a && tens1!=b && tens1!=c && tens1!=d)
						{
							j++;
						}
					}
					else if(unit1!=th1 && hun1!=th1)
						{
						if((th1==h || th1==te || th1==u) && th1!=a && th1!=b && th1!=c && th1!=d)
						{
							j++;
						}
					}
				}
				else if(unit1!=th1)
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
					if((th1==te || th1==u || th1==h) && th1!=a && th1!=b && th1!=c && th1!=d)
					{
						j++;
					}
					if(unit1!=tens1 && tens1!=th1)
					{
						if(tens1==h || tens1==u || tens1==t)
						{
							j++;
						}
					}
					else if(unit1!=hun1 && hun1!=th1)
						{
						if(th1==h || th1==te || th1==u)
						{
							j++;
						}
					}
				}
				else
				{
					if((unit1==te || unit1==h || unit1==t) && unit1!=a && unit1!=b && unit1!=c && unit1!=d)
					{
						j++;
					}
				}
			}
			t16.setText(String.valueOf(i)+"A"+String.valueOf(j)+"B");
			TextView t17=(TextView)findViewById(R.id.textView17);
			EditText e9=(EditText)findViewById(R.id.editText9);
			Button b9=(Button)findViewById(R.id.button9);
			t17.setVisibility(1);
			e9.setVisibility(1);
			b9.setVisibility(1);
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	       b9.setOnClickListener(new OnClickListener() {
				@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText e9=(EditText)findViewById(R.id.editText9);
		if(e9.getText().length()==4)
		{
		e9.setEnabled(false);
		int n1=Integer.parseInt(e9.getText().toString());
		int g=n1;
		if(g!=num)
		{
			if(so==true)
			{
				m.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("You lose!");
		    alertDialog.setMessage("The number is "+String.valueOf(num));
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		else
		{
			if(so==true)
			{
				mr.start();
			}
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Congrats!");
		    alertDialog.setMessage("You win.");
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent i1=new Intent(getApplicationContext(),GuessActivity.class);
	            	i1.putExtra("So",so);
					startActivity(i1);
	            }
	        });
		    alertDialog.show();
		}
		}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(GuessplayActivity.this).create();
			alertDialog.setTitle("Entered number is invalid!");
		    alertDialog.setMessage("Please enter a four digit number.");
		    alertDialog.setCanceledOnTouchOutside(true);
		    alertDialog.show();
		}
}
});
	}
}
