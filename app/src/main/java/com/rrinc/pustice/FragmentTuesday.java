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

import androidx.annotation.NonNull;
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

public class FragmentTuesday extends Fragment {

    View view;
    private ListView mylistview;
    private ListViewAdapter adapter;
    private List<RoutineInfo> listInfo;

    public FragmentTuesday() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tuesday_fragment, container, false);
        ImageView add=(ImageView)view.findViewById(R.id.addbttue);
        ImageView save=(ImageView) view.findViewById(R.id.savetue);
        loadData();
        mylistview=(ListView) view.findViewById(R.id.tuesday_recy);
        adapter =new ListViewAdapter(getContext(),listInfo);
        mylistview.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog ndialog=new Dialog(getContext());
                ndialog.setContentView(R.layout.edit_routine);
                TextView nmsg=(TextView)ndialog.findViewById(R.id.tv);
                nmsg.setText("Add Routine");
                final EditText ntitl=(EditText)ndialog.findViewById(R.id.etctl);
                final EditText ncode=(EditText)ndialog.findViewById(R.id.etcc);
                final EditText ntime=(EditText)ndialog.findViewById(R.id.ettime);
                final EditText ntch=(EditText)ndialog.findViewById(R.id.etti);
                final EditText nroom=(EditText)ndialog.findViewById(R.id.etroom);


                Button nbtn=(Button)ndialog.findViewById(R.id.bt);

                nbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nctitl=ntitl.getText().toString();
                        String nccode=ncode.getText().toString();
                        String nctime=ntime.getText().toString();
                        String nctch=ntch.getText().toString();
                        String ncroom=nroom.getText().toString();

                        if(nctitl.isEmpty() || nccode.isEmpty()|| nctime.isEmpty()|| nctch.isEmpty() || ncroom.isEmpty()){
                            Toast.makeText(getContext(),"You have to fill up all field",Toast.LENGTH_SHORT).show();
                        }else {
                            RoutineInfo routineInfo=new RoutineInfo(nctitl,nccode,nctime,nctch,ncroom);
                            listInfo.add(routineInfo);
                            saveData();
                            adapter.notifyDataSetChanged();
                            ndialog.dismiss();
                            Toast.makeText(getContext(),nccode+" Added",Toast.LENGTH_SHORT).show();
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

        listInfo=new ArrayList<>();
        listInfo.add(new RoutineInfo("Applied Electricity and Magnetism Sessional","ICE1106","08:45 AM-11:10 AM","IA","502"));
        listInfo.add(new RoutineInfo("Basic Electronics","ICE1103","11:10 AM-12:20 PM","SS","503"));
        listInfo.add(new RoutineInfo("Applied Electricity and Magnetism","ICE1105","12:25 PM-02:00 PM","IA","503"));

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences tue", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("routine tue list", null);
        Type type = new TypeToken<ArrayList<RoutineInfo>>() {
        }.getType();
        listInfo = gson.fromJson(json, type);

        if (listInfo == null) {
            listInfo = new ArrayList<>();
            listInfo.add(new RoutineInfo("Applied Electricity and Magnetism Sessional","ICE1106","08:45 AM-11:10 AM","IA","502"));
            listInfo.add(new RoutineInfo("Basic Electronics","ICE1103","11:10 AM-12:20 PM","SS","503"));
            listInfo.add(new RoutineInfo("Applied Electricity and Magnetism","ICE1105","12:25 PM-02:00 PM","IA","503"));
        }
    }
    private void saveData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences tue", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listInfo);
        editor.putString("routine tue list", json);
        editor.apply();
    }

}
