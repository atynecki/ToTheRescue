package com.rescue.totherescue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.CaseViewHolder> {

    public Context context;
    private List<String> caseList;

    public CaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.case_row, viewGroup, false);
        return new CaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CaseViewHolder caseViewHolder, int i) {
        String oneCase = caseList.get(i);
        caseViewHolder.oneCase.setText(oneCase);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CaseViewHolder extends RecyclerView.ViewHolder {

        public Button oneCase;

        public CaseViewHolder(View itemView) {
            super(itemView);
            oneCase = (Button) itemView.findViewById(R.id.caseButton);
            oneCase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position = getAdapterPosition();
                }
            });
        }


    }

    public void addNewCase(String newCase){
        caseList.add(newCase);
        notifyDataSetChanged();
    }
}
