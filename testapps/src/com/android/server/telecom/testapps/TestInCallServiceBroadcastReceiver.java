/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.server.telecom.testapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Test in call service broadcast receiver.
 */
public class TestInCallServiceBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TestInCallServiceBR";

    /**
     * Sends an upgrade to video request for any live calls.
     */
    public static final String ACTION_SEND_UPDATE_REQUEST_FROM_TEST_INCALL_SERVICE =
            "android.server.telecom.testapps.ACTION_SEND_UPDATE_REQUEST_FROM_TEST_INCALL_SERVICE";

    /**
     * Handles broadcasts directed at the {@link TestInCallServiceImpl}.
     *
     * @param context The Context in which the receiver is running.
     * @param intent  The Intent being received.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.v(TAG, "onReceive: " + action);

        if (ACTION_SEND_UPDATE_REQUEST_FROM_TEST_INCALL_SERVICE.equals(action)) {
            TestCallList.getInstance().sendUpgradeToVideoRequest();
        }
    }
}
