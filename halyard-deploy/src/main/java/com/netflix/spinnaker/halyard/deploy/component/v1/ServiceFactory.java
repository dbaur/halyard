/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.deploy.component.v1;

import org.springframework.beans.factory.annotation.Autowired;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class ServiceFactory<T extends ComponentService> {
  @Autowired
  OkClient okClient;

  public T createService(String endpoint, ComponentType componentType) {
    Class<T> clazz = (Class<T>) componentType.getServiceClass();
    return new RestAdapter.Builder()
        .setClient(okClient)
        .setEndpoint(endpoint)
        .build()
        .create(clazz);
  }
}
