package com.roundarch.codetest.part1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.roundarch.codetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdigiovanni on 8/15/13.
 */
public class Part1Fragment extends Fragment{
    // TODO - any member variables you need to store?
    private SeekBar bar1, bar2;
    private TextView tvDifference;
    private  Switch switchSync;

    //FIXME: Improve something! Anything
    private String getDifference(int a, int b)
    {
        return Integer.toString(Math.abs(a - b));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_part1, null);

        // TODO - obtain references to your views from the layout
        bar1 = (SeekBar)view.findViewById(R.id.seekBar1);
        bar2 = (SeekBar)view.findViewById(R.id.seekBar2);

        tvDifference = (TextView)view.findViewById(R.id.tvDifference);

        switchSync = (Switch)view.findViewById(R.id.switchSync);

        // TODO - hook up any event listeners that make sense for the task

        bar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvDifference.setText(getDifference(bar1.getProgress(), bar2.getProgress()));
                if(switchSync.isChecked())
                {
                    bar2.setProgress(bar1.getProgress());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvDifference.setText(getDifference(bar1.getProgress(), bar2.getProgress()));
                if(switchSync.isChecked())
                {
                    bar1.setProgress(bar2.getProgress());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }


}
