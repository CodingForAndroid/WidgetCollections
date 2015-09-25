/*
 * Copyright (C) 2011 VOV IO (http://vov.io/)
 */

package com.bczm.widgetcollections.ui.fragment;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnCompletionListener;
import io.vov.vitamio.MediaPlayer.OnInfoListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;


public class VideoPlayerActivity extends Activity implements OnCompletionListener, OnInfoListener {

	private String mPath;
	private String mTitle;
	private VideoView mVideoView;
	private View mVolumeBrightnessLayout;
	private ImageView mOperationBg;
	private ImageView mOperationPercent;
	private AudioManager mAudioManager;
	/** 最大声音 */
	private int mMaxVolume;
	/** 当前声音 */
	private int mVolume = -1;
	/** 当前亮度 */
	private float mBrightness = -1f;
	/** 当前缩放模式 */
	private int mLayout = VideoView.VIDEO_LAYOUT_ORIGIN;
	private GestureDetector mGestureDetector;
	private MediaController mMediaController;
	private View mLoadingView;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		// ~~~ 检测Vitamio是否解压解码包
		if (!LibsChecker.checkVitamioLibs(this, R.string.init_decoders))
			return;
		// ~~~ 获取播放地址和标题
		Intent intent = getIntent();
//		mPath = intent.getStringExtra("path");
		mPath="rtmp://live.hkstv.hk.lxdns.com/live/hks";
//		mPath="http://mvvideo1.meitudata.com/558931da76dda6982.mp4";
//		http://us.sinaimg.cn/003rWaQ0jx06VySJBUc0050d010000fj0k01.m3u8?KID=unistore,video&Expires=1442848623&ssig=PmY0mIGSWk
//		mPath="http://us.sinaimg.cn/003rWaQ0jx06VySJBUc0050d010000fj0k01.m3u8";
//		mPath="http://hls3.douyutv.com/live/319538rGmSLuO2IR/playlist.m3u8";
//		mPath="http://hdl3.douyutv.com/live319538rGmSLuO2IR.flv";
//		mPath = intent.getStringExtra("path");
		mTitle = "-------------------------title";
//		mTitle = intent.getStringExtra("title");
		if (TextUtils.isEmpty(mPath)) {
			mPath = Environment.getExternalStorageDirectory() + "/video/你太猖狂.flv";

		} else if (intent.getData() != null)
			mPath = intent.getData().toString();
		// ~~~ 绑定控件
		setContentView(R.layout.videoview);
		mVideoView = (VideoView) findViewById(R.id.surface_view);
		mVolumeBrightnessLayout = findViewById(R.id.operation_volume_brightness);
		mOperationBg = (ImageView) findViewById(R.id.operation_bg);
		mOperationPercent = (ImageView) findViewById(R.id.operation_percent);
		mLoadingView = findViewById(R.id.video_loading);
		// ~~~ 绑定事件
		mVideoView.setOnCompletionListener(this);
		mVideoView.setOnInfoListener(this);
		// ~~~ 绑定数据
		mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		mMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		if (mPath.startsWith("http:"))
			mVideoView.setVideoURI(Uri.parse(mPath));
		
		else
			mVideoView.setVideoPath(mPath);

		//设置显示名称
		mMediaController=new MediaController(UIUtils.getContext(),new MediaController.Controller(){
			@Override
			public View.OnClickListener getShareClickListener() {
				View. OnClickListener  shareController=new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						UIUtils.showToastSafe("getShareClickListener");
						LogUtils.e("分享操作_____before click____"+mLayout);
						if (mLayout == VideoView.VIDEO_LAYOUT_ZOOM)
							mLayout = VideoView.VIDEO_LAYOUT_ORIGIN;
						else
							mLayout++;
						if(mLayout==VideoView.VIDEO_LAYOUT_STRETCH){// 横竖屏切换记得 给activity 设置 configchange 属性      android:configChanges="orientation|keyboardHidden|screenSize"
							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
//							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
						}else{
							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
						}


//						if(mLayout==VideoView.VIDEO_LAYOUT_ORIGIN){
////							mLayout=VideoView.VIDEO_LAYOUT_SCALE;// 全屏
//							mLayout=VideoView.VIDEO_LAYOUT_STRETCH;// 全屏
//							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
//							if (mVideoView != null)
//								mVideoView.setVideoLayout(mLayout, 0);
//						}else if(mLayout==VideoView.VIDEO_LAYOUT_STRETCH){
//							mLayout=VideoView.VIDEO_LAYOUT_ORIGIN;   //原始   画面 全屏
////							mLayout=VideoView.VIDEO_LAYOUT_ORIGIN;   //原始   画面 全屏
//							setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//							if (mVideoView != null)
//								mVideoView.setVideoLayout(mLayout, 0);
//						}

						if (mVideoView != null)
								mVideoView.setVideoLayout(mLayout, 0);
//						public static final int VIDEO_LAYOUT_ORIGIN = 0;
//						public static final int VIDEO_LAYOUT_SCALE = 1;
//						public static final int VIDEO_LAYOUT_STRETCH = 2;
//						public static final int VIDEO_LAYOUT_ZOOM = 3;
//						public static final int VIDEO_LAYOUT_FIT_PARENT = 4;
						LogUtils.e("分享操作____after click_____" + mLayout);



					}
				};
				return shareController;
			}


			@Override
			public View.OnClickListener getBackClickListener() {
				View. OnClickListener  backCOntroller=new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
						getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
						getWindow().addFlags(WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
						getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

//						mVideoView.stopPlayback();
//						VideoPlayerActivity.this.finish();
					}
				};
				return backCOntroller;
			}
		});
		mMediaController.setFileName(mTitle);
		mVideoView.setMediaController(mMediaController);
		mVideoView.requestFocus();


		mGestureDetector = new GestureDetector(this, new MyGestureListener());
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		ViewTreeObserver vto = mVideoView.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				mVideoView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				mVideoView.getHeight();
				mVideoView.getWidth();
//				mMediaController.setPadding(0, 0, 0,mVideoView.getBottom());
				LogUtils.e("ViewTreeObserver:\tmVideoView.getHeight();:"+	mVideoView.getHeight()+"mVideoView.getWidth();"+mVideoView.getWidth());
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mVideoView != null)
			mVideoView.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (mVideoView != null)
			mVideoView.resume();


	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mVideoView != null)
			mVideoView.stopPlayback();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mGestureDetector.onTouchEvent(event))
			return true;
		// 处理手势结束
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_UP:
			endGesture();
			break;
		}
		return super.onTouchEvent(event);
	}

	/** 手势结束 */
	private void endGesture() {
		mVolume = -1;
		mBrightness = -1f;
		// 隐藏
		mDismissHandler.removeMessages(0);
		mDismissHandler.sendEmptyMessageDelayed(0, 500);
	}

	private class MyGestureListener extends SimpleOnGestureListener {

		/** 双击 */
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			if (mLayout == VideoView.VIDEO_LAYOUT_ZOOM)
				mLayout = VideoView.VIDEO_LAYOUT_ORIGIN;
			else
				mLayout++;
			if (mVideoView != null)
				mVideoView.setVideoLayout(mLayout, 0);
			return true;
		}

		/** 滑动 */
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
			float mOldX = e1.getX(), mOldY = e1.getY();
			int y = (int) e2.getRawY();
			Display disp = getWindowManager().getDefaultDisplay();
			int windowWidth = disp.getWidth();
			int windowHeight = disp.getHeight();

			if (mOldX > windowWidth * 4.0 / 5)// 右边滑动
				onVolumeSlide((mOldY - y) / windowHeight);
			else if (mOldX < windowWidth / 5.0)// 左边滑动
				onBrightnessSlide((mOldY - y) / windowHeight);

			return super.onScroll(e1, e2, distanceX, distanceY);
		}
	}

	/** 定时隐藏 */
	private Handler mDismissHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			mVolumeBrightnessLayout.setVisibility(View.GONE);
		}
	};

	/**
	 * 滑动改变声音大小
	 * 
	 * @param percent
	 */
	private void onVolumeSlide(float percent) {
		if (mVolume == -1) {
			mVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
			if (mVolume < 0)
				mVolume = 0;

			// 显示
			mOperationBg.setImageResource(R.mipmap.video_volumn_bg);
			mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
		}

		int index = (int) (percent * mMaxVolume) + mVolume;
		if (index > mMaxVolume)
			index = mMaxVolume;
		else if (index < 0)
			index = 0;

		// 变更声音
		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);

		// 变更进度条
		ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
		lp.width = findViewById(R.id.operation_full).getLayoutParams().width * index / mMaxVolume;
		mOperationPercent.setLayoutParams(lp);
	}

	/**
	 * 滑动改变亮度
	 * 
	 * @param percent
	 */
	private void onBrightnessSlide(float percent) {
		if (mBrightness < 0) {
			mBrightness = getWindow().getAttributes().screenBrightness;
			if (mBrightness <= 0.00f)
				mBrightness = 0.50f;
			if (mBrightness < 0.01f)
				mBrightness = 0.01f;

			// 显示
			mOperationBg.setImageResource(R.mipmap.video_brightness_bg);
			mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
		}
		WindowManager.LayoutParams lpa = getWindow().getAttributes();
		lpa.screenBrightness = mBrightness + percent;
		if (lpa.screenBrightness > 1.0f)
			lpa.screenBrightness = 1.0f;
		else if (lpa.screenBrightness < 0.01f)
			lpa.screenBrightness = 0.01f;
		getWindow().setAttributes(lpa);

		ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
		lp.width = (int) (findViewById(R.id.operation_full).getLayoutParams().width * lpa.screenBrightness);
		mOperationPercent.setLayoutParams(lp);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if (mVideoView != null)
			mVideoView.setVideoLayout(mLayout, 0);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCompletion(MediaPlayer player) {
		finish();
	}

	private void stopPlayer() {
		if (mVideoView != null)
			mVideoView.pause();
	}

	private void startPlayer() {
		if (mVideoView != null)
			mVideoView.start();
	}

	private boolean isPlaying() {
		return mVideoView != null && mVideoView.isPlaying();
	}

	/** 是否需要自动恢复播放，用于自动暂停，恢复播放 */
//	private boolean needResume;
private  boolean needResume=true;
	@Override
	public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
		switch (arg1) {
		case MediaPlayer.MEDIA_INFO_BUFFERING_START:
			//开始缓存，暂停播放
			if (isPlaying()) {
				stopPlayer();
				needResume = true;
			}
			mLoadingView.setVisibility(View.VISIBLE);
			break;
		case MediaPlayer.MEDIA_INFO_BUFFERING_END:
			//缓存完成，继续播放
			if (needResume)
				startPlayer();
			mLoadingView.setVisibility(View.GONE);
			break;
		case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
			//显示 下载速度
			LogUtils.e("download rate:" + arg2);
			//mListener.onDownloadRateChanged(arg2);
			break;
		}
		return true;
	}

}