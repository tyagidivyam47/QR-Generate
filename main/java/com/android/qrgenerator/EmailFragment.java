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


public class EmailFragment extends Fragment {

    private TextView text;
    private ImageView codeImage;
    private EditText input;
    private Button generateQRBtn;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    public EmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.common_layout, container, false);
        input = rootView.findViewById(R.id.input);
        input.setHint("Enter receiver's E-Mail address");

        TextView category = rootView.findViewById(R.id.category);
        category.setText("EMAIL");
        category.setBackgroundColor(getResources().getColor(R.color.email_color));

        text = rootView.findViewById(R.id.textover_code);
        codeImage = rootView.findViewById(R.id.image_QRcode);
        generateQRBtn = rootView.findViewById(R.id.build_button);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = input.getText().toString();

                if(data.isEmpty() || !data.contains("@")){
                    Toast.makeText(getContext(). getApplicationContext(), "Please enter proper Email Address", Toast.LENGTH_SHORT).show();
                }
                else{
                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.EMAIL, 1000);
                    text.setVisibility(View.GONE);
                    bitmap = qrgEncoder.getBitmap();
                    codeImage.setImageBitmap(bitmap);
                }
            }
        });
        return rootView;
    }
}