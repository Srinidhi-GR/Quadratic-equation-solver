package com.example.quadraticequationsolver;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class Quadratic extends BaseObservable {
    String x,y,z;
    ActivityMainBinding binding;

    public Quadratic(ActivityMainBinding binding) {
        this.binding = binding;
    }

    @Bindable
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
        notifyPropertyChanged(BR.x);
    }

    @Bindable
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
        notifyPropertyChanged(BR.y);
    }

    @Bindable
    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
        notifyPropertyChanged(BR.z);
    }

    @SuppressLint("SetTextI18n")
    public void getResult(View view){
        double a = Double.parseDouble(getX());
        double b = Double.parseDouble(getY());
        double c = Double.parseDouble(getZ());

        double discriminant = (b*b)-(4*a*c);

        double x1,x2;
        if(discriminant>0){
            x1 = (-b + Math.sqrt(discriminant))/2*a;
            x2 = (-b - Math.sqrt(discriminant))/2*a;

            binding.textView2.setText("x1: "+x1+" x2: "+x2);
        } else if (discriminant<0) {
            binding.textView2.setText("No real solution");
        } else {
            x1 = -b / (2*a);
            binding.textView2.setText("x: "+x1);
        }
    }
}
