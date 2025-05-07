package jp.ac.gifu_u.info.ouga.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    // コンストラクタ（ここではこの引数のものを追加）
    public MyView(Context context) {
        super(context);
    }

    // ビューの描画を行うときに呼ばれるメソッド
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);  // 描画色を青に指定
// (10,20)から(30,40)へ青線を描画
        canvas.drawLine(10, 20, 300, 400, paint);
    }
}