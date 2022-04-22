package com.rrinc.pustice.support;

import android.app.Dialog;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.rrinc.pustice.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    int id= -1 ;
    private Context nContext;
    private List<RoutineInfo> mRouineInfoList;

    public ListViewAdapter(Context nContext, List<RoutineInfo> mRouineInfoList) {
        this.nContext = nContext;
        this.mRouineInfoList = mRouineInfoList;
    }

    @Override
    public int getCount() {
        return mRouineInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRouineInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View v=View.inflate(nContext, R.layout.class_list,null);



        TextView tv_title=(TextView)v.findViewById(R.id.clsttl);
        TextView tv_code=(TextView) v.findViewById(R.id.clscd);
        TextView tv_time=(TextView) v.findViewById(R.id.clstm);
        TextView tv_tech=(TextView) v.findViewById(R.id.techcd);
        TextView tv_room=(TextView) v.findViewById(R.id.roomno);
        ImageView alarmclck=(ImageView)v.findViewById(R.id.alarm);
       final TextView tv_option=(TextView)v.findViewById(R.id.option);


        final RoutineInfo itemList=mRouineInfoList.get(position);
        tv_title.setText(mRouineInfoList.get(position).getClsTitl());
        tv_code.setText(mRouineInfoList.get(position).getClsCode());
        tv_time.setText(mRouineInfoList.get(position).getClsTime());
        tv_tech.setText(mRouineInfoList.get(position).getClsTech());
        tv_room.setText(mRouineInfoList.get(position).getClsRoom());


        alarmclck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String al=mRouineInfoList.get(position).getClsTime();
                Toast.makeText(nContext,"Alarm Set to "+al,Toast.LENGTH_SHORT).show();
            }
        });




        tv_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(nContext,tv_option);
                popupMenu.inflate(R.menu.routine_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(final MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.rtEdit:
                                final Dialog dialog=new Dialog(nContext);
                                dialog.setContentView(R.layout.edit_routine);
                                TextView msg=(TextView)dialog.findViewById(R.id.tv);
                                msg.setText("Update Routine");
                                final EditText titl=(EditText)dialog.findViewById(R.id.etctl);
                                final EditText code=(EditText)dialog.findViewById(R.id.etcc);
                                final EditText time=(EditText)dialog.findViewById(R.id.ettime);
                                final EditText tch=(EditText)dialog.findViewById(R.id.etti);
                                final EditText room=(EditText)dialog.findViewById(R.id.etroom);

                                id=position;

                                titl.setText(mRouineInfoList.get(position).getClsTitl());
                                code.setText(mRouineInfoList.get(position).getClsCode());
                                time.setText(mRouineInfoList.get(position).getClsTime());
                                tch.setText(mRouineInfoList.get(position).getClsTech());
                                room.setText(mRouineInfoList.get(position).getClsRoom());

                                Button btn=(Button)dialog.findViewById(R.id.bt);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String ctitl=titl.getText().toString();
                                        String ccode=code.getText().toString();
                                        String ctime=time.getText().toString();
                                        String ctch=tch.getText().toString();
                                        String croom=room.getText().toString();

                                        if(ctitl.isEmpty() || ccode.isEmpty()|| ctime.isEmpty()|| ctch.isEmpty() || croom.isEmpty()){
                                            Toast.makeText(nContext,"Field must be Fillup",Toast.LENGTH_SHORT).show();
                                        }else {
                                            RoutineInfo routineInfo=new RoutineInfo(ctitl,ccode,ctime,ctch,croom);
                                            mRouineInfoList.set(id,routineInfo);
                                            id=-1;
                                            notifyDataSetChanged();
                                            dialog.dismiss();
                                            Toast.makeText(nContext,ccode+" Updated",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialog.show();
                                break;
                            case R.id.rtDelete:
                                String cd=mRouineInfoList.get(position).getClsCode();
                                mRouineInfoList.remove(position);
                                notifyDataSetChanged();

                                Toast.makeText(nContext,cd+" has been Deleted",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        return v;
    }
}
