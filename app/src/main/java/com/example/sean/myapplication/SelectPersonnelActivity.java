package com.example.sean.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;



public class SelectPersonnelActivity extends AppCompatActivity {
    private static final String TAG = "SelectPersonnelActivity";
    private PopupWindow mpopup;
    TextView resultantTable;
    RosterDBHandler rDBHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_personnel);
        rDBHandler = new RosterDBHandler(this,null,null,1);
        //showDB();
    }

    public void showDB(){
        String result = rDBHandler.dbToString();
        try {
            resultantTable.setText(result);
        }
        catch(NullPointerException e)
        {
            Log.e(TAG, "Exception caught");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG,"onCreateOptionsMenu");
            getMenuInflater().inflate(R.menu.roster_overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.e("ALLGO", "Menu item selected");
        int id = item.getItemId();
        int bid;
        switch (id){
            case R.id.itemaddpersonnel:
                bid = R.id.add_personnel_submit;
                showPopUpWindow(R.layout.popup_add_personnel, bid);
                break;

            case R.id.itemremovepersonnel:
                Toast.makeText(getApplicationContext(),"This feature is not yet implemented",Toast.LENGTH_LONG).show();
                break;

            case R.id.itemfactoryreset:
                Toast.makeText(getApplicationContext(),"This feature is not yet implemented",Toast.LENGTH_LONG).show();
                break;

            default:
                Toast.makeText(getApplicationContext(),"This feature is not yet implemented",Toast.LENGTH_LONG).show();

                return true;
        }
        return true;
    }

    public void showPopUpWindow(int id, int bid)
    {

        final View popUpView = getLayoutInflater().inflate(id, null); // inflating popup layout
        mpopup = new PopupWindow(popUpView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);
        mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);



        Button b=(Button)popUpView.findViewById(bid);


        b.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {


                EditText tmpText;

                switch(v.getId()) {
                    case R.id.add_personnel_submit:
                        tmpText = (EditText) popUpView.findViewById(R.id.add_personnel_name);
                        String name = tmpText.getText().toString();
                        if(name.equals(""))
                            Toast.makeText(getApplicationContext(),"ENTER A NAME FOR THE PERSONNEL",Toast.LENGTH_LONG).show();
                        else
                        {
                            Personnel personnel = new Personnel(name);
                            rDBHandler.addPersonnel(personnel);
                            showDB();
                            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                            mpopup.dismiss();
                        }
                        break;


                }}});}
}
