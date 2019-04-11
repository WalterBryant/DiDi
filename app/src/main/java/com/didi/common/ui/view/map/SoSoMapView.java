package com.didi.common.ui.view.map;

import android.content.Context;

import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public class SoSoMapView extends MapView {

    private boolean isPaused = false;

    public SoSoMapView(Context context) {
        super(context);
    }

    public SoSoMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.isPaused = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    public boolean isPaused() {
        return this.isPaused;
    }
}
