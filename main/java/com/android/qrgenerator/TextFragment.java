package com.android.qrgenerator;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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


public class TextFragment extends Fragment {
    private TextView textView;
    private ImageView codeImage;
    private EditText inputData;
    private Button generateQRBtn;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;


    public TextFragment() {
        // empty public constructor
    }



//    public static TextFragment newInstance(String param1, String param2) {
//        TextFragment fragment = new TextFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.common_layout, container, false);

        EditText input = rootView.findViewById(R.id.input);
        input.setHint("Enter the Text Here");

        TextView category = (TextView) rootView.findViewById(R.id.category);
        category.setText("TEXT");
        category.setBackgroundColor(getResources().getColor(R.color.teal_200));

        textView = rootView.findViewById(R.id.textover_code);
        codeImage = rootView.findViewById(R.id.image_QRcode);
        inputData = rootView.findViewById(R.id.input);
        generateQRBtn = rootView.findViewById(R.id.build_button);

        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = inputData.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(getContext(). getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
                }
                else{
//                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
//                    Display display = manager.getDefaultDisplay();
//                    Point point = new Point();
//                    display.getSize(point);
//                    int width = point.x;
//                    int height = point.y;
//                    int dimen = width<height ? width:height;
//                    dimen *= 3/4;

                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT,1000);
                    bitmap = qrgEncoder.getBitmap();
                    textView.setVisibility(View.GONE);
                    codeImage.setImageBitmap(bitmap);
                }
            }
        });
        return rootView;
    }
}