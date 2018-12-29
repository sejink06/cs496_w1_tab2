package com.example.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

public class FullImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);

        RequestManager requestManager = Glide.with(imageAdapter.getContext());
        RequestBuilder requestBuilder = requestManager.load(imageAdapter.getParts()[position]).apply(new RequestOptions().override(250, 250));
        // Show image into target imageview.
        requestBuilder.into(imageView);
        //imageView.setImageResource(imageAdapter.getParts()[position]);
    }

}
