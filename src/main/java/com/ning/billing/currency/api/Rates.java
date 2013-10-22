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

package com.ning.billing.currency.api;

import java.math.BigDecimal;
import java.util.List;

import com.ning.billing.catalog.api.Currency;

public interface Rates {

    /**
     *
     * @return the list of currencies
     */
    public List<Currency> getCurrencies();

    /**
     *
     * @param currency the currency
     *
     * @return the rate for the specified currency
     * @throws CurrencyConversionException if currency is not defined
     */
    public BigDecimal getRate(Currency currency)
            throws CurrencyConversionException;
}
