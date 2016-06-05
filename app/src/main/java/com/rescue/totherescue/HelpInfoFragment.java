package com.rescue.totherescue;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class HelpInfoFragment extends DialogFragment {

    public static HelpInfoFragment getInstance() {
        final HelpInfoFragment fragment = new HelpInfoFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View dialogView = inflater.inflate(R.layout.help_info_dialog, container);

        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.lightblue)));
        getDialog().setTitle(R.string.help_info);

        return dialogView;
    }
}