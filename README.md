This library is to convert assets into bitmap.

**Step 1.** Add the JitPack repository to your build file

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


**step 2.** Add the dependency

dependencies {
	        implementation 'com.github.Mehdi-android:AssetToBitmapp:{ReleaseVersion}'
	}

**step 3.** AssetToBitmap.getBitmapFromAsset(context, path);

NOTE: In path you have to simple pass the file name. If you use subFolder like Drawable then use Drawables/filename.jpg.

**ARCHITECTURE**

The main components of android architecture that I have user are following:-

Applications
Application Framework
Android Runtime
Platform Libraries
Linux Kernel


**INSTRUMENTED TESTING:**

Have used instrumented testing as converting image from assets to bitmap requires context.

Have written 2 tests
1) To check if image does not exist.
2) To check if image exist
