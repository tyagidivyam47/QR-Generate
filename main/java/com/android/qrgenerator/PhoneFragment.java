package com.android.qrgenerator;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class PhoneFragment extends Fragment {
    private TextView textView;
    private ImageView codeImage;
    private EditText inputData;
    private Button generateQRBtn;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    public PhoneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.common_layout, container, false);
        EditText input = rootView.findViewById(R.id.input);
        input.setHint("+12 345 6789");
        TextView category = (TextView) rootView.findViewById(R.id.category);
        category.setText("PHONE");
        category.setBackgroundColor(getResources().getColor(R.color.phone_color));

        textView = rootView.findViewById(R.id.textover_code);
        codeImage = rootView.findViewById(R.id.image_QRcode);
        inputData = rootView.findViewById(R.id.input);
        generateQRBtn = rootView.findViewById(R.id.build_button);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = input.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(getContext(). getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
                }

                boolean isValid = true;
                for(int i = 0; i < data.length(); i++){
                    if(data.charAt(i) < 48 || data.charAt(i) > 57){
                        Toast.makeText(getContext(). getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.PHONE, 1000);
                    bitmap = qrgEncoder.getBitmap();
                    textView.setVisibility(View.GONE);
                    codeImage.setImageBitmap(bitmap);
                }
            }
        });

        return rootView;
    }
}