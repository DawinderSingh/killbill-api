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

package com.ning.billing.entitlement.api.user;

import java.util.UUID;

import org.joda.time.DateTime;

import com.ning.billing.catalog.api.Plan;
import com.ning.billing.catalog.api.PlanPhase;
import com.ning.billing.catalog.api.PriceList;
import com.ning.billing.entitlement.api.SubscriptionTransitionType;

public interface SubscriptionTransition {

    public UUID getSubscriptionId();

    public UUID getBundleId();

    public SubscriptionState getPreviousState();

    public SubscriptionState getNextState();

    public UUID getPreviousEventId();

    public DateTime getPreviousEventCreatedDate();

    public Plan getPreviousPlan();

    public Plan getNextPlan();

    public PlanPhase getPreviousPhase();

    public UUID getNextEventId();

    public DateTime getNextEventCreatedDate();

    public PlanPhase getNextPhase();

    public PriceList getPreviousPriceList();

    public PriceList getNextPriceList();

    public DateTime getRequestedTransitionTime();

    public DateTime getEffectiveTransitionTime();

    public SubscriptionTransitionType getTransitionType();
}
