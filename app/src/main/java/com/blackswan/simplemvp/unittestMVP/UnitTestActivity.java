package com.blackswan.simplemvp.unittestMVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blackswan.simplemvp.R;
import com.blackswan.simplemvp.unittestMVP.model.MainModel;
import com.blackswan.simplemvp.unittestMVP.presenter.MainPresenter;
import com.blackswan.simplemvp.unittestMVP.view.MainView;


public class UnitTestActivity extends AppCompatActivity implements MainView {
    private EditText edtWidth, edtHeight, edtLength;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);
        edtWidth = (EditText)findViewById(R.id.edt_width);
        edtHeight = (EditText)findViewById(R.id.edt_height);
        edtLength = (EditText)findViewById(R.id.edt_length);
        Button btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView)findViewById(R.id.tv_result);
        final MainPresenter presenter = new MainPresenter(this);
  btnCalculate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String length = edtLength.getText().toString().trim();
          String width = edtWidth.getText().toString().trim();
          String height = edtHeight.getText().toString().trim();

          boolean isEmptyFields = false;

          if (TextUtils.isEmpty(length)){
              isEmptyFields = true;
              edtLength.setError("Field ini tidak boleh kosong");
          }

          if (TextUtils.isEmpty(width)){
              isEmptyFields = true;
              edtWidth.setError("Field ini tidak boleh kosong");
          }

          if (TextUtils.isEmpty(height)){
              isEmptyFields = true;
              edtHeight.setError("Field ini tidak boleh kosong");
          }

          if (!isEmptyFields){
              double l = Double.parseDouble(length);
              double w = Double.parseDouble(width);
              double h = Double.parseDouble(height);

              presenter.hitungVolume(l, w, h);
          }
      }
  });
    }

    @Override
    public void tampilVolume(MainModel model) {
        tvResult.setText(String.valueOf(model.getVolume()));
    }
}
