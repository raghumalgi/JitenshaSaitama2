/*
 * Copyright 2015, The Android Open Source Project
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
 * limitations under the License.
 */

package com.crossover.assignment.jitenshasaitama.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class DataRespositories {

    private DataRespositories() {
        // no instance
    }

    private static DataRepository repository = null;

    public synchronized static DataRepository getInMemoryRepoInstance(@NonNull BikerServiceApi notesServiceApi) {
        checkNotNull(notesServiceApi);
        if (null == repository) {
            repository = new InMemoryDataRepository(notesServiceApi);
        }
        return repository;
    }
}