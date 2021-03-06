/*
 * *
 *  * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * WSO2 Inc. licenses this file to you under the Apache License,
 *  * Version 2.0 (the "License"); you may not use this file except
 *  * in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied.  See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */

package org.wso2.gw.emulator.http.producer;

import org.wso2.gw.emulator.core.RequestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseContext extends RequestContext {

    private Map<String, List<String>> headerParameters;
    private StringBuffer requestBody;

    public void addHeaderParameter(String key, String value) {
        if (headerParameters == null) {
            this.headerParameters = new HashMap<String, List<String>>();
        }

        List<String> headerValues = this.headerParameters.get(key);
        if (headerValues == null) {
            headerValues = new ArrayList<String>();
        }
        headerValues.add(value);
        this.headerParameters.put(key, headerValues);
    }

    public Map<String, List<String>> getHeaderParameters() {
        return headerParameters;
    }

    public void appendResponseContent(Object content) {
        if (requestBody == null) {
            this.requestBody = new StringBuffer();
        }
        this.requestBody.append(content);
    }

    public String getRequestBody() {
        if (requestBody == null) {
            return null;
        }
        return requestBody.toString();
    }
}
