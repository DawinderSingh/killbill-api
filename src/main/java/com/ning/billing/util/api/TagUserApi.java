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

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.ning.billing.ObjectType;
import com.ning.billing.util.callcontext.CallContext;
import com.ning.billing.util.callcontext.TenantContext;
import com.ning.billing.util.tag.Tag;
import com.ning.billing.util.tag.TagDefinition;

public interface TagUserApi {

    /**
     * @param context The tenant context
     * @return the list of all available tag definitions
     */
    public List<TagDefinition> getTagDefinitions(TenantContext context);

    /**
     * @param definitionName Identifies the definition.
     * @param description    Describes the use of the definition.
     * @param context        The call context, for auditing purposes
     * @return the newly created tag definition
     * @throws TagDefinitionApiException
     */
    public TagDefinition createTagDefinition(String definitionName, String description, CallContext context) throws TagDefinitionApiException;

    /**
     * @param tagDefinitionId The UUID for that tagDefinition
     * @param context         The call context, for auditing purposes
     * @throws TagDefinitionApiException
     */
    public void deleteTagDefinition(UUID tagDefinitionId, CallContext context) throws TagDefinitionApiException;

    /**
     * @param tagDefinitionId The tag definition id
     * @param context         The call context, for auditing purposes
     * @return The Tag definition
     * @throws TagDefinitionApiException
     */
    public TagDefinition getTagDefinition(UUID tagDefinitionId, TenantContext context) throws TagDefinitionApiException;

    /**
     * @param tageDefinitionName The tag definition name
     * @param context            The call context, for auditing purposes
     * @return the tag definition
     * @throws TagDefinitionApiException
     */
    public TagDefinition getTagDefinitionForName(String tageDefinitionName, TenantContext context) throws TagDefinitionApiException;

    /**
     * @param tagDefinitionIds The collection of the defintion ids
     * @param context          The call context, for auditing purposes
     * @return the tag definition
     * @throws TagDefinitionApiException
     * @throws TagDefinitionApiException
     */
    public List<TagDefinition> getTagDefinitions(Collection<UUID> tagDefinitionIds, TenantContext context) throws TagDefinitionApiException;

    /**
     * @param objectId         The id for the object on which to add tags
     * @param objectType       The object type
     * @param tagDefinitionIds The collection of tag definition ids
     * @param context          The call context, for auditing purposes
     * @throws TagApiException
     */
    public void addTags(UUID objectId, ObjectType objectType, Collection<UUID> tagDefinitionIds, CallContext context) throws TagApiException;

    /**
     * @param objectId        The id for the object on which to add tags
     * @param objectType      The object type
     * @param tagDefinitionId The tag definition id
     * @param context         The call context, for auditing purposes
     * @throws TagApiException
     */
    public void addTag(UUID objectId, ObjectType objectType, UUID tagDefinitionId, CallContext context) throws TagApiException;

    /**
     * @param objectId       The id for the object on which to add tags
     * @param objectType     The object type
     * @param tagDefinitions The collection of tag definition ids
     * @param context        The call context, for auditing purposes
     * @throws TagApiException
     */
    public void removeTags(UUID objectId, ObjectType objectType, Collection<UUID> tagDefinitions, CallContext context) throws TagApiException;

    /**
     * @param objectId        The id for the object on which to add tags
     * @param objectType      The object type
     * @param tagDefinitionId The tage definition id
     * @param context         The call context, for auditing purposes
     * @throws TagApiException
     */
    public void removeTag(UUID objectId, ObjectType objectType, UUID tagDefinitionId, CallContext context) throws TagApiException;

    /**
     * @param objectId   UUID of the object on which to retrieve the tags
     * @param objectType The type of object
     * @param context    The tenant context
     * @return A map of tag, key being the tagId, and value the tag
     */
    public List<Tag> getTagsForObject(UUID objectId, ObjectType objectType, TenantContext context);

    /**
     * @param accountId  The account id
     * @param objectType The type of object on which to retrieve the tags
     * @param context    The tenant context
     * @return A list of tags for that object type and that given account
     */
    public List<Tag> getTagsForAccountType(UUID accountId, ObjectType objectType, TenantContext context);


    /**
     * @param accountId The account id
     * @param context   The tenant context
     * @return A list of tags for that given account
     */
    public List<Tag> getTagsForAccount(UUID accountId, TenantContext context);
}
