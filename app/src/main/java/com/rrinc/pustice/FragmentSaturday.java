package com.rrinc.pustice;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rrinc.pustice.support.ListViewAdapter;
import com.rrinc.pustice.support.RoutineInfo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class FragmentSaturday extends Fragment {

    View view;
    private ListView mylistview;
    private ListViewAdapter adapter;
    private List<RoutineInfo> listInfo;

    public FragmentSaturday() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.saturday_fragment, container, false);
        ImageView add = (ImageView) view.findViewById(R.id.addbtsat);
        ImageView save=(ImageView) view.findViewById(R.id.savesat);
        mylistview = (ListView) view.findViewById(R.id.saturday_recy);
        loadData();
        adapter = new ListViewAdapter(getContext(), listInfo);
        mylistview.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog ndialog = new Dialog(getContext());
                ndialog.setContentView(R.layout.edit_routine);
                TextView nmsg = (TextView) ndialog.findViewById(R.id.tv);
                nmsg.setText("Add Routine");
                final EditText ntitl = (EditText) ndialog.findViewById(R.id.etctl);
                final EditText ncode = (EditText) ndialog.findViewById(R.id.etcc);
                final EditText ntime = (EditText) ndialog.findViewById(R.id.ettime);
                final EditText ntch = (EditText) ndialog.findViewById(R.id.etti);
                final EditText nroom = (EditText) ndialog.findViewById(R.id.etroom);



                Button nbtn = (Button) ndialog.findViewById(R.id.bt);

                nbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nctitl = ntitl.getText().toString();
                        String nccode = ncode.getText().toString();
                        String nctime = ntime.getText().toString();
                        String nctch = ntch.getText().toString();
                        String ncroom = nroom.getText().toString();

                        if (nctitl.isEmpty() || nccode.isEmpty() || nctime.isEmpty() || nctch.isEmpty() || ncroom.isEmpty()) {
                            Toast.makeText(getContext(), "You have to fill up all field", Toast.LENGTH_SHORT).show();
                        } else {
                            RoutineInfo routineInfo = new RoutineInfo(nctitl, nccode, nctime, nctch, ncroom);
                            listInfo.add(routineInfo);
                            adapter.notifyDataSetChanged();
                            saveData();
                            ndialog.dismiss();
                            Toast.makeText(getContext(), nccode + " Added", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                ndialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(getContext(),"Routine Save Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        listInfo = new ArrayList<>();
        listInfo.add(new RoutineInfo("Bangladesh Studies", "HUM1101", "08:45 AM-11:10 AM", "DMAI", "103"));
        listInfo.add(new RoutineInfo("Applied Electricity and Magnetism", "ICE1105", "11:10 AM-12:20 PM", "IA", "503"));
        listInfo.add(new RoutineInfo("Fundamental of ICT", "ICE1101", "12:25 PM-02:00 PM", "TNT", "503"));

    }
    private void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences sat", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("routine sat list", null);
        Type type = new TypeToken<ArrayList<RoutineInfo>>() {
        }.getType();
        listInfo = gson.fromJson(json, type);

        if (listInfo == null) {
            listInfo = new ArrayList<>();
            listInfo.add(new RoutineInfo("Bangladesh Studies", "HUM1101", "08:45 AM-11:10 AM", "DMAI", "103"));
            listInfo.add(new RoutineInfo("Applied Electricity and Magnetism", "ICE1105", "11:10 AM-12:20 PM", "IA", "503"));
            listInfo.add(new RoutineInfo("Fundamental of ICT", "ICE1101", "12:25 PM-02:00 PM", "TNT", "503"));
        }

    }
    private void saveData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences sat", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listInfo);
        editor.putString("routine sat list", json);
        editor.apply();
    }
}
