package com.bagus.qrcode2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    Button gen;
    EditText edit;
    ImageView img;
    String text2Qr;

    MultiFormatWriter multi = new MultiFormatWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gen = (Button)findViewById(R.id.btnGen);
        edit = (EditText)findViewById(R.id.text);
        img = (ImageView)findViewById(R.id.image);

        gen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                text2Qr = edit.getText().toString();
                try {
                    BitMatrix bitMatrix = multi.encode(text2Qr, BarcodeFormat.QR_CODE, 300, 300);

                    BarcodeEncoder barcodeencoder = new BarcodeEncoder();

                    Bitmap bitmap = barcodeencoder.createBitmap(bitMatrix);
                    img.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
