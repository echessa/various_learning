package com.echessa.instacam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class NewPhotoActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 10;
    public static final String PHOTO_EXTRA = "PHOTO_EXTRA";

    private Photo mPhoto;
    private ImageView mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_photo);

        mPreview = (ImageView) findViewById(R.id.photo_preview);
        final EditText caption = (EditText) findViewById(R.id.new_photo_caption);
        Button saveButton = (Button) findViewById(R.id.save_new_photo);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPhoto.setCaption(caption.getText().toString());
                Intent i = new Intent();
                i.putExtra(PHOTO_EXTRA, mPhoto);
                setResult(RESULT_OK, i);
                finish();
            }
        });

        launchCamera();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                Picasso.with(this).load(mPhoto.getFile()).into(mPreview);
            }
        }
    }

    private void launchCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mPhoto = new Photo();
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhoto.getFile()));
        startActivityForResult(i, CAMERA_REQUEST);
    }
}
