package com.victoria.skinhairdresser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ManageActivity extends AppCompatActivity {
    //고객 진단 관리 화면
    private LineChart chart;
    float average = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);


        chart = findViewById(R.id.lineChart);
        chart.getDescription().setEnabled(false);
        chart.invalidate();
        chart.setTouchEnabled(false);
        chart.setPinchZoom(false);

        Legend l = chart.getLegend();
        l.setEnabled(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);

        YAxis yLAxis =chart.getAxisLeft();
        yLAxis.setDrawLabels(false);
        yLAxis.setDrawAxisLine(false);
        yLAxis.setDrawGridLines(false);
        YAxis yRAxis = chart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);


        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            float val = (float) (Math.random() * 10);
            values.add(new Entry(i, val));
            average += val;
        }

        average = average / 10;

        LineDataSet set1;
        set1 = new LineDataSet(values, null);

        LimitLine limitLine = new LimitLine(average);
        limitLine.setLineColor(ContextCompat.getColor(this, R.color.limit_color));

        yLAxis.addLimitLine(limitLine);
        yLAxis.setDrawLimitLinesBehindData(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets

        // create a data object with the data sets
        LineData data = new LineData(dataSets);

        // black lines and points

//        chart.setBackgroundResource(R.drawable.graph_background);
        chart.setBackgroundColor(Color.WHITE);


        set1.setDrawFilled(false);
        set1.setDrawValues(false);
        set1.setDrawCircleHole(false);
        set1.setDrawCircles(false);
        set1.setColor(ContextCompat.getColor(this, R.color.main_brown));
        set1.setFillColor(R.color.main_brown);



        // set data
        chart.setData(data);





    }
}