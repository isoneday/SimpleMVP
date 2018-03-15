package com.blackswan.simplemvp.unittestMVP.presenter;


import com.blackswan.simplemvp.unittestMVP.model.MainModel;
import com.blackswan.simplemvp.unittestMVP.view.MainView;

/**
 * Created by iswandisaputra on 2/27/18.
 */

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public double volume(double panjang, double lebar, double tinggi) {
        return panjang * lebar * tinggi;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi) {
        double volume = volume(panjang, lebar, tinggi);
        MainModel model = new MainModel(volume);
        view.tampilVolume(model);
    }
}
