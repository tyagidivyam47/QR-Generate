package com.android.qrgenerator;

import android.graphics.Bitmap;
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

public class UrlFragment extends Fragment {
    private TextView text;
    private ImageView codeImage;
    private EditText input;
    private Button generateQRBtn;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    public UrlFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.common_layout, container, false);

        input = rootView.findViewById(R.id.input);
        input.setHint("Enter URL Eg. https://www.google.com/");

        TextView category = (TextView) rootView.findViewById(R.id.category);
        category.setText("URL");
        category.setBackgroundColor(getResources().getColor(R.color.url_color));

        text = rootView.findViewById(R.id.textover_code);
        codeImage = rootView.findViewById(R.id.image_QRcode);
        generateQRBtn = rootView.findViewById(R.id.build_button);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = input.getText().toString();
                if(inputStr.isEmpty()){
                    Toast.makeText(getContext(). getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
                }
                else if((!inputStr.contains(".com") && !inputStr.contains("www.") && !inputStr.contains("http"))){
                    Toast.makeText(getContext(). getApplicationContext(), "Enter a valid URL", Toast.LENGTH_SHORT).show();
                }
                else{
                    qrgEncoder = new QRGEncoder(inputStr, null, QRGContents.Type.TEXT, 1000);
                    bitmap = qrgEncoder.getBitmap();
                    text.setVisibility(View.GONE);
                    codeImage.setImageBitmap(bitmap);
                }
            }
        });
        return rootView;
    }
}