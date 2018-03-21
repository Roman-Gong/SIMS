package com.gongyunhao.sims.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;

import java.util.ArrayList;
import java.util.List;

//    ┏┓　   ┏┓
// ┏━━┛┻━━━━━┛┻ ┓ 
// ┃　　　　　　 ┃  
// ┃　　　━　    ┃  
// ┃　＞　　＜　 ┃  
// ┃　　　　　　 ┃  
// ┃... ⌒ ...  ┃  
// ┃　　　　　 　┃  
// ┗━━━┓　　　┏━┛  
//     ┃　　　┃　  
//     ┃　　　┃  
//     ┃　　　┃  神兽保佑  
//     ┃　　　┃  代码无bug　　  
//     ┃　　　┃  
//     ┃　　　┗━━━━━━━━━┓
//     ┃　　　　　　　    ┣┓
//     ┃　　　　         ┏┛
//     ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//       ┃ ┫ ┫   ┃ ┫ ┫
//       ┗━┻━┛   ┗━┻━┛
//
//  作者：棒棒小糖
//  來源：简书
//
//  Creste by GongYunHao on 2018/3/21
// 
public class StudentDataAdapter extends RecyclerView.Adapter<StudentDataAdapter.ViewHolder> implements View.OnClickListener,View.OnLongClickListener{
    private List<StudentBean> studentBeanList=new ArrayList<>(  );
    private Context mcontext;
    private OnItemClickListener onItemClickListener = null;

    public StudentDataAdapter(Context context,List<StudentBean> studentBeanList) {
        this.mcontext=context;
        this.studentBeanList = studentBeanList;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_student_data, parent, false);
        view.setOnClickListener( this );
        view.setOnLongClickListener( this );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (studentBeanList.get( position ).getStudentSex()==1){
            holder.sex.setText( "性别：男" );
        }else {
            holder.sex.setText( "性别：女" );
        }
        holder.name.setText( studentBeanList.get( position ).getStudentName() );
        holder.number.setText( "学号："+studentBeanList.get( position ).getStudentNumber() );
        holder.grade.setText( "年级："+studentBeanList.get( position ).getStudentGrade() );
        holder.major.setText( "专业："+studentBeanList.get( position ).getStudentMajor() );
        holder.mstudentview.setTag( position );
    }

    @Override
    public int getItemCount() {
        return studentBeanList.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null){
            onItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (onItemClickListener != null){
            onItemClickListener.onItemLongClick(view,(int)view.getTag());
        }
        return false;
    }

    public void setmOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,number,sex,grade,major;
        View mstudentview;

        public ViewHolder(View itemView) {
            super( itemView );
            mstudentview=itemView;
            name=itemView.findViewById( R.id.textView_name );
            number=itemView.findViewById( R.id.textView_number );
            sex=itemView.findViewById( R.id.textView_sex );
            grade=itemView.findViewById( R.id.textView_grade );
            major=itemView.findViewById( R.id.textView_major );
        }
    }
}
