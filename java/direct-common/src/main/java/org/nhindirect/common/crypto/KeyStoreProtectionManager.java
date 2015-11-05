/* 
Copyright (c) 2010, NHIN Direct Project
All rights reserved.

Authors:
   Greg Meyer      gm2552@cerner.com
 
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer 
in the documentation and/or other materials provided with the distribution.  Neither the name of the The NHIN Direct Project (nhindirect.org). 
nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.nhindirect.common.crypto;

import java.security.Key;
import java.security.KeyStore.Entry;
import java.util.Map;

import org.nhindirect.common.crypto.exceptions.CryptoException;

/**
 * Interface definition for accessing key store pass phrases.  PKCS12 keystores generally have two layers of protection with each being options:
 * <br>
 * <ul>
 * <li>Pass phrase protection for the entire key store.</li>
 * <li>Pass phrase protection for private keys associated with a public key</li>
 * <br>
 * This interface assumes that all private keys are stores with the same pass phrase.  Pass phrases may stored in a multitude of mediums such as protected files,
 * databases, or PKCS11 tokens.
 * @author Greg Meyer
 * @since 1.3
 *
 */
public interface KeyStoreProtectionManager 
{
	/**
	 * Gets the key protecting the key store as a whole.
	 * @return The key protecting the key store as a whole.
	 * @throws CryptoException
	 */
	public Key getPrivateKeyProtectionKey() throws CryptoException;
	
	/**
	 * Gets the key protecting private keys in the key store.
	 * @return The key protecting private keys in the key store.
	 * @throws CryptoException
	 */
	public Key getKeyStoreProtectionKey() throws CryptoException;
	
	/**
	 * Gets a Map of all keys managed by the token.
	 * @return Returns a map of all keys in the token.  The mapping is string alias to the key.
	 * @throws CryptoException
	 */
	public Map<String, Key> getAllKeys() throws CryptoException;
	
	/**
	 * Gets a specific key by name.
	 * @param keyName The name of the key to retrieve.  Returns null if the key doesn't exist.
	 * @return They key specified by the name. 
	 * @throws CryptoException
	 */
	public Key getKey(String keyName) throws CryptoException;
	
	/**
	 * Gets a Map of all entries managed by the token.
	 * @return Returns a map of all entries in the token.  The mapping is a string alias to the entry.
	 * @throws CryptoException
	 */
	public Map<String, Entry> getAllEntries() throws CryptoException;
	
	/**
	 * Gets a specific entry by name
	 * @param entryName The name of the entry to retrieve.  Returns null if the entry doesn't exist.
	 * @return They entry specified by the name.
	 * @throws CryptoException
	 */
	public Entry getEntry(String entryName) throws CryptoException;
}
