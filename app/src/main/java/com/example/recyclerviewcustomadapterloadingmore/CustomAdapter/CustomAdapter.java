package com.example.recyclerviewcustomadapterloadingmore.CustomAdapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcustomadapterloadingmore.R;
import com.example.recyclerviewcustomadapterloadingmore.listener.OnButtomReachedListener;
import com.example.recyclerviewcustomadapterloadingmore.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
private static final int TYPE_AVAILABLE_HAEDER = 0;
private static final int TYPE_AVAILABLE_YES = 1;
private static final int TYPE_AVAILABLE_NOT = 2;
private static final int TYPE_AVAILABLE_FOOTER = 3;

Context context;
List<Member> members;
OnButtomReachedListener listener;

    public CustomAdapter(Context context, List<Member> members, OnButtomReachedListener listener) {
        this.context = context;
        this.members = members;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {

        if (isHeader(position)){return TYPE_AVAILABLE_HAEDER;}
        if (isFooter(position)){return TYPE_AVAILABLE_FOOTER;}
        Member member = members.get(position);
        if(member.isAvialable()){return  TYPE_AVAILABLE_YES;}
        return TYPE_AVAILABLE_NOT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_AVAILABLE_HAEDER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_header,parent,false);
            return new CustomViewHeaderHolder(view);
        }
        if (viewType == TYPE_AVAILABLE_FOOTER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_footer,parent,false);
            return new CustomViewFooterHolder(view);
        }
        if (viewType ==TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_yes,parent,false);
            return new CustomViewYesHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_not,parent,false);
        return new CustomViewNotHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (position == members.size() - 1){
            listener.onBottomReached(position);
        }
        if (isHeader(position) || isFooter(position)) return;

        if (holder instanceof CustomViewYesHolder){

            TextView first_name_yes = ((CustomViewYesHolder) holder).firstName;
            TextView last_name_not = ((CustomViewYesHolder) holder).lastName;
            first_name_yes.setText(member.getFirstName());
            last_name_not.setText(member.getLastName());

        }

        if (holder instanceof CustomViewNotHolder){
            TextView first_name_not = ((CustomViewNotHolder) holder).firstName;
            TextView last_name_not = ((CustomViewNotHolder) holder).lastName;
            first_name_not.setText(member.getFirstName());
            last_name_not.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    public boolean isHeader(int position){ return position ==0;}
    public boolean isFooter(int position){return position == (members.size() -1);}
    class CustomViewYesHolder extends RecyclerView.ViewHolder{
        TextView firstName;
        TextView lastName;
        public CustomViewYesHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.yes_first_name);
            lastName = itemView.findViewById(R.id.yes_last_name);
        }
    }
    class CustomViewNotHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        TextView lastName;
        public CustomViewNotHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.not_first_name);
            lastName = itemView.findViewById(R.id.not_last_name);
        }
    }
    class CustomViewHeaderHolder extends RecyclerView.ViewHolder{

        TextView header;
        public CustomViewHeaderHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header_textView);
        }
    }
    class CustomViewFooterHolder extends RecyclerView.ViewHolder{

        TextView footer;
        public CustomViewFooterHolder(@NonNull View itemView) {
            super(itemView);
            footer = itemView.findViewById(R.id.footer_textView);
        }
    }
}
