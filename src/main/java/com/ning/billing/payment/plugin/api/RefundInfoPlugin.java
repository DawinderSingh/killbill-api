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

package com.ning.billing.payment.plugin.api;

import com.ning.billing.catalog.api.Currency;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public interface RefundInfoPlugin {

    /**
     * @return refund amount
     */
    public BigDecimal getAmount();

    /**
     *
     * @return refund currency
     */
    public Currency getCurrency();

    /**
     * @return date when the refund was created
     */
    public DateTime getCreatedDate();

    /**
     * @return date when the refund is effective
     */
    public DateTime getEffectiveDate();

    /**
     * @return refund status in the gateway
     */
    public RefundPluginStatus getStatus();

    /**
     * @return gateway error, if any
     */
    public String getGatewayError();

    /**
     * @return gateway error code, if any
     */
    public String getGatewayErrorCode();

    /**
     * @return the reference id
     */
    public String getReferenceId();
}
