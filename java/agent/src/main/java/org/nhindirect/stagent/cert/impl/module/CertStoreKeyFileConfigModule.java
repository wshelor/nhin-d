/* 
Copyright (c) 2010, NHIN Direct Project
All rights reserved.

Authors:
   Umesh Madan     umeshma@microsoft.com
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

package org.nhindirect.stagent.cert.impl.module;

import org.nhindirect.stagent.cert.impl.annotation.CertStoreKeyFile;
import org.nhindirect.stagent.cert.impl.annotation.CertStoreKeyFileCrl;
import org.nhindirect.stagent.cert.impl.annotation.CertStoreKeyFilePassword;
import org.nhindirect.stagent.cert.impl.annotation.CertStoreKeyFilePrivKeyPassword;

import com.google.inject.AbstractModule;

public class CertStoreKeyFileConfigModule extends AbstractModule 
{
	private final String keyFile;
	private final String filePassword;
	private final String privKeyPassword;
	private final String certificateRevocationListFile;
	
	public static CertStoreKeyFileConfigModule create(String keyFile, String filePassword, String privKeyPassword, String certificateRevocationListFile)
	{
		return new CertStoreKeyFileConfigModule(keyFile, filePassword, filePassword, certificateRevocationListFile);
	}
	
	private CertStoreKeyFileConfigModule(String keyFile, String filePassword, String privKeyPassword, String certificateRevocationListFile)
	{
		this.keyFile = keyFile;
		this.filePassword = filePassword;
		this.privKeyPassword = privKeyPassword;
		this.certificateRevocationListFile = certificateRevocationListFile;
	}
	
	protected void configure()
	{		
		bindConstant().annotatedWith(CertStoreKeyFile.class).to(keyFile);
		bindConstant().annotatedWith(CertStoreKeyFilePassword.class).to(filePassword);
		bindConstant().annotatedWith(CertStoreKeyFilePrivKeyPassword.class).to(privKeyPassword);	
		bindConstant().annotatedWith(CertStoreKeyFileCrl.class).to(certificateRevocationListFile);
	}	
}
