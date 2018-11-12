package com.mccam.pianopro;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity implements OnTouchListener {

	private static final int numWk = 11;
	private static final int numBk = 7;
	private static final int numKeys = numBk + numWk;
	private Region[] kb = new Region[numKeys];
	private MediaPlayer[] key = new MediaPlayer[numKeys];
	private int sw;
	private int sh;
	private int[] activePointers = new int[numKeys];
	private Drawable drawable_white;
	private Drawable drawable_black;
	private Drawable drawable_white_press;
	private Drawable drawable_black_press;
	private Timer timer;
	private Bitmap bitmap_keyboard;
	private ImageView iv;
	private boolean[] lastPlayingNotes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		TypedArray notes = this.getResources().obtainTypedArray(R.array.notes);

		for (int i = 0; i < notes.length(); i++) {
			int k = notes.getResourceId(i, -1);
			if (k != -1) {
				key[i] = MediaPlayer.create(this, k);
			} else {
				key[i] = null;
			}
		}

		Resources res = this.getResources();
		drawable_white = res.getDrawable(R.drawable.white);
		drawable_black = res.getDrawable(R.drawable.black);
		drawable_white_press = res.getDrawable(R.drawable.white_pressed);
		drawable_black_press = res.getDrawable(R.drawable.black_pressed);

		Display disp = ((WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

		sw = disp.getWidth();
		sh = disp.getHeight();

		this.makeRegions();
		for (int i = 0; i < numKeys; i++) {
			activePointers[i] = -1;
		}

		iv = (ImageView) findViewById(R.id.imageView1);
		iv.setOnTouchListener(this);
		
		//admob
		AdView adView = (AdView)this.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		adView.loadAd(adRequest);
	}

	private void makeRegions() {
		int kw;
		int kh;
		int bkw;
		int bkh;

		kw = (int) sw / numWk;
		kh = (int) (sh * 0.8);
		bkw = (int) (kw * 0.6);
		bkh = (int) (sh * 0.5);

		Path[] path = new Path[4];
		path[0] = new Path();
		path[1] = new Path();
		path[2] = new Path();
		path[3] = new Path();

		path[0].lineTo(0, kh);
		path[0].lineTo(kw, kh);
		path[0].lineTo(kw, bkh);
		path[0].lineTo(kw - (bkw / 2), bkh);
		path[0].lineTo(kw - (bkw / 2), 0);
		path[0].close();

		path[1].moveTo(bkw / 2, 0);
		path[1].lineTo(bkw / 2, bkh);
		path[1].lineTo(0, bkh);
		path[1].lineTo(0, kh);
		path[1].lineTo(kw, kh);
		path[1].lineTo(kw, bkh);
		path[1].lineTo(kw - (bkw / 2), bkh);
		path[1].lineTo(kw - (bkw / 2), 0);
		path[1].close();

		path[2].moveTo(bkw / 2, 0);
		path[2].lineTo(bkw / 2, bkh);
		path[2].lineTo(0, bkh);
		path[2].lineTo(0, kh);
		path[2].lineTo(kw, kh);
		path[2].lineTo(kw, 0);
		path[2].close();

		path[3].addRect(0, 0, bkw, bkh, Direction.CCW);

		Region region = new Region(0, 0, sw, sh);
		int kt[] = new int[] { 0, 1, 2, 0, 1, 1, 2, 0, 1, 2, 0, 3, 3, -1, 3, 3,
				3, -1, 3, 3 };
		for (int i = 0; i < numWk; i++) {
			kb[i] = new Region();
			Path pathtmp = new Path();
			pathtmp.addPath(path[kt[i]], i * kw, 0);
			kb[i].setPath(pathtmp, region);
		}

		int j = numWk;

		for (int i = numWk; i < kt.length; i++) {
			if (kt[i] != -1) {
				kb[j] = new Region();
				Path pathtmp = new Path();
				pathtmp.addPath(path[kt[i]], (i - numWk + 1) * kw - (bkw / 2),
						0);
				kb[j].setPath(pathtmp, region);
				j = j + 1;
			}
		}
	}

	private Bitmap drawKeys() {
		Bitmap bm = Bitmap.createBitmap(sw, sh, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bm);

		for (int i = 0; i < numWk; i++) {
			if (key[i].isPlaying()) {
				drawable_white_press.setBounds(kb[i].getBounds());
				drawable_white_press.draw(canvas);
			} else {
				drawable_white.setBounds(kb[i].getBounds());
				drawable_white.draw(canvas);
			}
		}

		for (int i = numWk; i < numKeys; i++) {
			if (key[i].isPlaying()) {
				drawable_black_press.setBounds(kb[i].getBounds());
				drawable_black_press.draw(canvas);
			} else {
				drawable_black.setBounds(kb[i].getBounds());
				drawable_black.draw(canvas);
			}
		}
		return bm;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int pointerIndex = event.getActionIndex();
		float x = event.getX(pointerIndex);
		float y = event.getY(pointerIndex);

		for (int j = 0; j < numKeys; j++) {
			if (kb[j].contains((int) x, (int) y)) {
				Log.d("notes", String.valueOf(j));
				switch (event.getActionMasked()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_POINTER_DOWN:
					playNote(key[j]);
					activePointers[pointerIndex] = j;
					break;
				case MotionEvent.ACTION_UP:
				case MotionEvent.ACTION_POINTER_UP:
					stopNote(key[j]);
					activePointers[pointerIndex] = -1;
					break;
				case MotionEvent.ACTION_MOVE:
					if (activePointers[pointerIndex] != j) {
						if (activePointers[pointerIndex] != -1) {
							stopNote(key[activePointers[pointerIndex]]);
						}
						playNote(key[j]);
						activePointers[pointerIndex] = j;
					}
					break;
				}
			}
		}

		return true;
	}

	private void playNote(MediaPlayer mp) {
		mp.seekTo(0);
		mp.start();
	}

	private void stopNote(MediaPlayer mp) {
		mp.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean[] playingNotes = new boolean[numKeys];
				for (int i = 0; i < playingNotes.length; i++) {
					playingNotes[i] = key[i].isPlaying();
				}

				if (!Arrays.equals(playingNotes, lastPlayingNotes)) {
					bitmap_keyboard = drawKeys();
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							iv.setImageBitmap(bitmap_keyboard);
						}
					});
				}

				lastPlayingNotes = playingNotes;
			}
		}, 0, 100);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		timer.cancel();
	}

	private void rateApp() {
		Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
		Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
		try {
			startActivity(goToMarket);
		} catch (Exception ex) {
			Toast.makeText(this, "Couldn't launch the market",
					Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.rate:
			rateApp();
			break;

		default:
			break;
		}
		return true;
	}

}
