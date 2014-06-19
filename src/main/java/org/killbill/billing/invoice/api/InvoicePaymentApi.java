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

package org.killbill.billing.invoice.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.killbill.billing.security.RequiresPermissions;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.TenantContext;

import static org.killbill.billing.security.Permission.PAYMENT_CAN_CHARGEBACK;

public interface InvoicePaymentApi {

    /**
     * @param accountId id of the account
     * @return All invoices, including migrated invoices
     */
    public List<Invoice> getAllInvoicesByAccount(UUID accountId, TenantContext context);

    public Invoice getInvoice(UUID invoiceId, TenantContext context) throws InvoiceApiException;

    public List<InvoicePayment> getInvoicePayments(UUID paymentId, TenantContext context);

    public InvoicePayment getInvoicePaymentForAttempt(UUID paymentId, TenantContext context);

    @RequiresPermissions(PAYMENT_CAN_CHARGEBACK)
    public InvoicePayment createChargeback(UUID invoicePaymentId, BigDecimal amount, CallContext context) throws InvoiceApiException;

    @RequiresPermissions(PAYMENT_CAN_CHARGEBACK)
    public InvoicePayment createChargeback(UUID invoicePaymentId, CallContext context) throws InvoiceApiException;

    public BigDecimal getRemainingAmountPaid(UUID invoicePaymentId, TenantContext context);

    public List<InvoicePayment> getChargebacksByAccountId(UUID accountId, TenantContext context);

    public UUID getAccountIdFromInvoicePaymentId(UUID uuid, TenantContext context) throws InvoiceApiException;

    public List<InvoicePayment> getChargebacksByPaymentId(UUID paymentId, TenantContext context);

    public InvoicePayment getChargebackById(UUID chargebackId, TenantContext context) throws InvoiceApiException;
}
