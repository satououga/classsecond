package jp.ac.gifu_u.info.ouga.myapplication;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
    private Camera cam;
    private SurfaceHolder holder;

    public CameraView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        // deprecated ですが学習用で動きます
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        cam = Camera.open(0);  // 0:背面カメラ
        try {
            cam.setPreviewDisplay(holder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(
            SurfaceHolder holder, int format, int width, int height) {
        cam.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        cam.stopPreview();
        cam.release();
        cam = null;
    }
}
