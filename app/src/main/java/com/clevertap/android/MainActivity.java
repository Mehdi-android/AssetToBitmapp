package com.clevertap.android;

import android.app.Dialog;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.clevertap.android.adapter.DrawableList;
import com.clevertap.assettobitmap.AssetToBitmap;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_assetList;
    String[] filelistInSubfolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        final AssetManager assetManager = getAssets();
        try {
            // for assets/subFolderInAssets add only subfolder name
            filelistInSubfolder = assetManager.list("Drawables");
            if (filelistInSubfolder == null) {
                Toast.makeText(this, "No files inside assets folder", Toast.LENGTH_SHORT).show();
            }
            DrawableList drawableList = new DrawableList(this, filelistInSubfolder, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int) view.getTag();
                    String path = "Drawables/" + filelistInSubfolder[pos];
                    openImageDialog(path);

                }
            });
            rv_assetList.setAdapter(drawableList);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openImageDialog(String path) {
        Bitmap bitmap = AssetToBitmap.getBitmapFromAsset(this, path);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_imageview);
        ImageView imageView = dialog.findViewById(R.id.iv_img);
        imageView.setImageBitmap(bitmap);
        dialog.show();
    }

    private void initData() {
        rv_assetList = findViewById(R.id.rv_assetList);
        rv_assetList.setLayoutManager(new LinearLayoutManager(this));

    }
}