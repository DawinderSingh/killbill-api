/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.util.api;

import java.util.List;
import java.util.UUID;

import com.ning.billing.ObjectType;
import com.ning.billing.util.callcontext.CallContext;
import com.ning.billing.util.callcontext.TenantContext;
import com.ning.billing.util.customfield.CustomField;

public interface CustomFieldUserApi {

    /**
     * @param fields  the list of fields to add
     * @param context the call context
     * @throws CustomFieldApiException
     */
    void addCustomFields(List<CustomField> fields, CallContext context) throws CustomFieldApiException;

    /**
     *
     * @param fields
     * @param context
     * @throws CustomFieldApiException
     */
    void removeCustomFields(List<CustomField> fields, CallContext context) throws CustomFieldApiException;

    /**
     * @param objectId   the object id
     * @param objectType the object type
     * @param context    the call context
     * @return the list of custom fields associated with that object
     */
    List<CustomField> getCustomFieldsForObject(UUID objectId, ObjectType objectType, TenantContext context);


    /**
     * @param accountId  the account id
     * @param objectType the object type
     * @param context    the call context
     * @return the list of custom fields associated with that account for the specified type
     */
    List<CustomField> getCustomFieldsForAccountType(UUID accountId, ObjectType objectType, TenantContext context);


    /**
     * @param accountId the account id
     * @param context   the call context
     * @return the list of custom fields associated with that account
     */
    List<CustomField> getCustomFieldsForAccount(UUID accountId, TenantContext context);
}
