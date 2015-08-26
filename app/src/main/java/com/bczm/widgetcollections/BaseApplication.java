package com.bczm.widgetcollections;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * @author ��Jorge on 2015/8/26 17:52
 */
public class BaseApplication extends Application{
    /** ȫ��Context��ԭ������ΪApplication����Ӧ���������еģ����������ǵĴ������ʱ����ֵ�Ѿ�����ֵ���� */
    private static BaseApplication mInstance;
    /** ���߳�ID */
    private static int mMainThreadId = -1;
    /** ���߳�ID */
    private static Thread mMainThread;
    /** ���߳�Handler */
    private static Handler mMainThreadHandler;
    /** ���߳�Looper */
    private static Looper mMainLooper;
    @Override
    public void onCreate() {
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
        mInstance = this;
        super.onCreate();
    }

    public static BaseApplication getApplication() {
        return mInstance;
    }

    /** ��ȡ���߳�ID */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /** ��ȡ���߳� */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /** ��ȡ���̵߳�handler */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /** ��ȡ���̵߳�looper */
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }
}
