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

public class YTFragment extends Fragment {

    private TextView text;
    private ImageView codeImage;
    private EditText input;
    private Button generateQRBtn;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YTFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.common_layout, container, false);
        input = rootView.findViewById(R.id.input);
        input.setHint("https://www.youtube.com/");

        TextView swipe = rootView.findViewById(R.id.swipe);
        swipe.setVisibility(View.GONE);

        TextView category = rootView.findViewById(R.id.category);
        category.setText("YOU TUBE");
        category.setBackgroundColor(getResources().getColor(R.color.youtube_color));

        text = rootView.findViewById(R.id.textover_code);
        codeImage = rootView.findViewById(R.id.image_QRcode);
        generateQRBtn = rootView.findViewById(R.id.build_button);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = input.getText().toString();

                if(data.isEmpty() || !data.contains("you")){
                    Toast.makeText(getContext(). getApplicationContext(), "Please enter a valid You Tube URL", Toast.LENGTH_SHORT).show();
                }
                else{
                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 1000);
                    text.setVisibility(View.GONE);
                    bitmap = qrgEncoder.getBitmap();
                    codeImage.setImageBitmap(bitmap);

                }
            }
        });
        return rootView;
    }
}