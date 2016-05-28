package com.rescue.totherescue;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rescue.totherescue.CaseActivity;
import com.rescue.totherescue.quiz.QuestionActivity;
import com.rescue.totherescue.quiz.QuizStartActivity;

import java.util.ArrayList;


public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.CaseViewHolder> {

    private ArrayList<String> caseList;
    private String mode;

    private static final String quiz_mode = "QUIZ";
    private  static final String help_mode = "HELP";

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
        return caseList.size();
    }

    public CaseAdapter(ArrayList<String> cases, String mode)
    {
        this.mode = mode;
        caseList = cases;
    }

    public class CaseViewHolder extends RecyclerView.ViewHolder {

        public Button oneCase;
        private final Context context;

        public CaseViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            oneCase = (Button) itemView.findViewById(R.id.caseButton);
            oneCase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position = getAdapterPosition();
                    String oneCase = caseList.get(position);
                    if(mode.equals(quiz_mode))
                    {
                        Intent intent = new Intent(context, QuizStartActivity.class);
                        intent.putExtra("case", oneCase);
                        context.startActivity(intent);
                    }
                    else if (mode.equals(help_mode))
                    {
                        //Intent intent = new Intent(context, HelpActivity.class);
                        //intent.putExtra("case", oneCase);
                        //context.startActivity(intent);
                    }
                }
            });
        }


    }
}
