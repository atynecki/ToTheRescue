package com.rescue.totherescue.quiz;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.rescue.totherescue.R;


public class ExplanationFragment extends DialogFragment {

    private TextView explanationView;
    public static ExplanationFragment getInstance(String text) {
        final ExplanationFragment fragment = new ExplanationFragment();

        final Bundle args = new Bundle();
        args.putString("exp", text);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle bundle = getArguments();
        final String exp = bundle.getString("exp");

        View dialogView = inflater.inflate(R.layout.explanation_dialog, container);

        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.lightblue)));
        getDialog().setTitle("Explanation");

        explanationView =  (TextView)dialogView.findViewById(R.id.textView_explanation);
        explanationView.setText(exp);

        return dialogView;
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }
}
