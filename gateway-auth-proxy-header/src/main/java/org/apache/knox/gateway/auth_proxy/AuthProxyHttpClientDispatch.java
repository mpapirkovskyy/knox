/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.knox.gateway.auth_proxy;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.apache.knox.gateway.dispatch.GatewayDispatchFilter;

/***
 * KNOX-526. Need to keep this class around for backward compatibility of deployed
 * topologies. This is required for releases older than Apache Knox 0.6.0
 */
@Deprecated
public class AuthProxyHttpClientDispatch extends GatewayDispatchFilter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    setDispatch(new AuthProxyDispatch());
    super.init(filterConfig);
  }
}

