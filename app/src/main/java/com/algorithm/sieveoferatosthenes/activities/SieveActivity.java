package com.algorithm.sieveoferatosthenes.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.algorithm.sieveoferatosthenes.R;

import java.util.ArrayList;

public class SieveActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Integer> list;
    private TextView tv;
    StringBuilder sb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sieve);
        listView = (ListView) findViewById(R.id.listView);
        tv = (TextView) findViewById(R.id.sieveNumbers);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_sieve, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enterClicked(View v){

        try {
            String input = ((EditText)findViewById(R.id.enterText)).getText().toString();

            EditText myEditText = (EditText) findViewById(R.id.enterText);

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);

            if (input != null && input.trim().length() > 0) {

                int num = Integer.parseInt(input);

                if (num > 1) {

                    list = new ArrayList<Integer>();

                    for (int i = 2; i < num + 1; i++) {
                        list.add(i);
                    }

                    listView.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, list));
                    listView.deferNotifyDataSetChanged();

                    for (int i = 0; i < list.size(); i++) {
                        for (int k = list.size() - 1; k > -1; k--) {

                            boolean changed = false;

                            if ((list.get(k) != 2) && (list.get(k) % 2 == 0)) {
                                changed = true;
                            } else if (list.get(k) != 3 && list.get(k) % 3 == 0) {
                                changed = true;
                            } else if (list.get(k) != 5 && list.get(k) % 5 == 0) {
                                changed = true;
                            } else if ((list.get(i) < list.get(k)) && (list.get(k) % list.get(i) == 0)) {
                                changed = true;
                            }

                            if (changed) {
                                list.remove(k);
                            }
                        }
                    }

                    sb = new StringBuilder();
                    sb.append("Scroll through the list of prime numbers between 2 and " + num + ": ");
                    tv.setText(sb.toString());
                    tv.setVisibility(View.VISIBLE);

                } else {

                    sb.setLength(0);
                    sb.append("Invalid number, only numbers larger than 1");
                    tv.setText(sb.toString());
                    tv.setVisibility(View.VISIBLE);
                }
            }
        } catch (NumberFormatException ex) {

            sb.setLength(0);
            sb.append("Invalid entry, must be a whole number larger than 1");
            tv.setText(sb.toString());
            tv.setVisibility(View.VISIBLE);
            list.clear();

        }
    }

    public void resetClicked(View v) {

        tv.setText("");
        tv.setVisibility(View.INVISIBLE);

        EditText myEditText = (EditText) findViewById(R.id.enterText);
        myEditText.getText().clear();

        list.clear();
    }
}
