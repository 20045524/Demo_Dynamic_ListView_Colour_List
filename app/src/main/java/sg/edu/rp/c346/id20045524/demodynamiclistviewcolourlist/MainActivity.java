package sg.edu.rp.c346.id20045524.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        alColours = new ArrayList<>();
        alColours.add("Orange");
        alColours.add("Red");

        aaColour = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if(pos > alColours.size()-1){
                    int lastSlot = alColours.size();
                    Toast.makeText(MainActivity.this,
                            "Null Exception, adding to last slot", Toast.LENGTH_SHORT).show();
                    alColours.add(lastSlot, colour);
                }
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if(pos > alColours.size()-1){
                    Toast.makeText(MainActivity.this,
                            "Error Index Out of Bound", Toast.LENGTH_SHORT).show();
                } else {
                    alColours.remove(pos);
                }

                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkPos = 0;
                String checkColour = "";
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if(pos > alColours.size()-1){
                    int lastSlot = alColours.size();
                    Toast.makeText(MainActivity.this,
                            "Null Exception, adding to last slot", Toast.LENGTH_SHORT).show();
                    alColours.add(lastSlot, colour);
                } else {
                    alColours.set(pos, colour);
                }
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this,
                        "" + alColours.get(position), Toast.LENGTH_SHORT).show();
                Log.d("LV Click", colour);

            }
        });
    }
}