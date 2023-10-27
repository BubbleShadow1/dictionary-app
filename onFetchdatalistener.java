package com.androidapp.dictionary;

import com.androidapp.dictionary.Model.APIResponse;

public interface onFetchdatalistener {
    void onFetchData(APIResponse apiResponse,String message);
    void onerror(String message);
}
