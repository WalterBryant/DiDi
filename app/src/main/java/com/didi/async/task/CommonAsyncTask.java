package com.didi.async.task;

import android.os.AsyncTask;

public class CommonAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    private AsyncListenerInter mListener;

    public CommonAsyncTask(AsyncListenerInter mListener) {
        this.mListener = mListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        if (this.mListener != null) {
            this.mListener.doInBack();
        }
        return Boolean.valueOf(true);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
