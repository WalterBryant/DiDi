package com.didi.async.task;

public interface AsyncListenerInter {
    void doInBack();
    void doOnCancel();;
    void doOnPost();
    void doOnPre();
    void doOnProcess();
}
