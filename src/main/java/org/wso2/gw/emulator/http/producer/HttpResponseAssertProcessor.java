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

import org.wso2.gw.emulator.http.dsl.dto.producer.OutgoingMessage;

public class HttpResponseAssertProcessor {

    public void process(HttpResponseContext responseContext, OutgoingMessage outgoingMessage) {
        assertResponseContent(responseContext, outgoingMessage);
        assertHeaderParameters(responseContext, outgoingMessage);
    }

    private void assertResponseContent(HttpResponseContext responseContext, OutgoingMessage outgoingMessage) {
        if (outgoingMessage.getBody().equalsIgnoreCase(responseContext.getRequestBody())) {
            System.out.print("Great");
        } else {
            System.out.print("Wrong");
        }
    }

    private void assertHeaderParameters(HttpResponseContext responseContext, OutgoingMessage outgoingMessage) {

    }
}
