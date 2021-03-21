package com.clevertap.android;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.clevertap.assettobitmap.AssetToBitmap;

import org.junit.Assert;
import org.junit.Test;

public class AssetToBitmapTest {

    @Test
    public void testgetBitmapFromAssetCheckNull() {
        String testImage = "Drawables/nature_10.jpeg";
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Assert.assertNull("Image is not null", AssetToBitmap.getBitmapFromAsset(appContext, testImage));
    }

    @Test
    public void testgetBitmapFromAssetCheckNonNull() {
        String testImage = "Drawables/nature_3.jpeg";
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Assert.assertNotNull("Image is not null", AssetToBitmap.getBitmapFromAsset(appContext, testImage));
    }

}
