/*
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

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.knox.gateway.config.Configure;
import org.apache.knox.gateway.dispatch.DefaultDispatch;
import org.apache.knox.gateway.security.SubjectUtils;

public class AuthProxyDispatch extends DefaultDispatch {
  private String headerName;

  @Override
  public void copyRequestHeaderFields(HttpUriRequest outboundRequest, HttpServletRequest inboundRequest) {
    super.copyRequestHeaderFields(outboundRequest, inboundRequest);
    if (headerName != null) {
      addCredentialsToRequest(outboundRequest, headerName);
    }
  }

  public void addCredentialsToRequest(HttpUriRequest request, String headerName) {
    String principal = SubjectUtils.getCurrentEffectivePrincipalName();
    if (principal != null) {
      request.addHeader(headerName, principal);
    }
  }

  @Configure
  public void setHeaderName( String headerName ) {
    this.headerName = headerName;
  }
}
