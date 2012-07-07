/*
 * Copyright (c) 2008-2012, Hazel Bilisim Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.aws;

import com.hazelcast.aws.impl.Constants;
import com.hazelcast.aws.impl.DescribeInstances;
import com.hazelcast.config.AwsConfig;

import java.util.List;

public class AWSClient {

    private String endpoint = Constants.HOST_HEADER;
    private final AwsConfig awsConfig;

    public AWSClient(AwsConfig awsConfig, String endpoint) {
        this.awsConfig = awsConfig;
    }

    public List<String> getPrivateIpAddresses(AwsConfig groupName) throws Exception {
        List<String> list = new DescribeInstances(awsConfig).execute(endpoint);
        return list;
    }

    public void setEndpoint(String s) {
        this.endpoint = s;
    }
}
