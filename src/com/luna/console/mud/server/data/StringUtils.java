package com.luna.console.mud.server.data;

import net.sf.json.JSONObject;

public class StringUtils {

    public JSONObject jsonFromStr(String str) {

        JSONObject obj = JSONObject.fromObject(str);
        return obj;
    }
}
