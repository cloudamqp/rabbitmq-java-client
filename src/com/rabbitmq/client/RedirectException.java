//   The contents of this file are subject to the Mozilla Public License
//   Version 1.1 (the "License"); you may not use this file except in
//   compliance with the License. You may obtain a copy of the License at
//   http://www.mozilla.org/MPL/
//
//   Software distributed under the License is distributed on an "AS IS"
//   basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//   License for the specific language governing rights and limitations
//   under the License.
//
//   The Original Code is RabbitMQ.
//
//   The Initial Developers of the Original Code are LShift Ltd.,
//   Cohesive Financial Technologies LLC., and Rabbit Technologies Ltd.
//
//   Portions created by LShift Ltd., Cohesive Financial Technologies
//   LLC., and Rabbit Technologies Ltd. are Copyright (C) 2007-2008
//   LShift Ltd., Cohesive Financial Technologies LLC., and Rabbit
//   Technologies Ltd.;
//
//   All Rights Reserved.
//
//   Contributor(s): ______________________________________.
//

package com.rabbitmq.client;

/**
 * Encapsulates an exception requiring redirection to the next from a list of "known addresses"
 */
public class RedirectException extends Exception {
    /** Standard serialization ID. */
    private static final long serialVersionUID = 1L;

    /** The address to redirect to **/
    private final Address _address;

    /** Known cluster addresses **/
    private final Address[] _knownAddresses;

    /**
     * Construct a RedirectException from the given initialization parameters.
     * @param address the address we are redirecting to
     * @param knownAddresses the list of all known addresses
     */
    public RedirectException(Address address, Address[] knownAddresses) {
        super("redirect to " + address);
        _address = address;
        _knownAddresses = knownAddresses;
    }

    /**
     * Returns the address to redirect to
     * @return the redirection address
     */
    public Address getAddress() {
        return _address;
    }

    /**
     * Returns the known cluster addresses
     * @return an array of the known cluster addresses (each a hostname/port pair)
     */
    public Address[] getKnownAddresses() {
        return _knownAddresses;
    }
}
