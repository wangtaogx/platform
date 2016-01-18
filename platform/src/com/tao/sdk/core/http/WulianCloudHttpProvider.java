package com.tao.sdk.core.http;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class WulianCloudHttpProvider extends AbstractHttpProvider {

	private static HttpClient digestHttpClient = null;

	public WulianCloudHttpProvider() {
		getHttpClient();
	}

	@Override
	protected HttpClient getHttpClient() {
		if (null == digestHttpClient) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(new AuthScope(
					AuthScope.ANY)), new UsernamePasswordCredentials("wladmin",
					"wladmin"));
//			try {
				 /*SSLContext sslcontext = SSLContexts.custom().
			                .loadTrustMaterial(new File("my.keystore"), "nopassword".toCharArray(),
			                        new TrustSelfSignedStrategy())
//			                .build();*/
//				 SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(new TrustSelfSignedStrategy())
//								 .build();
//				 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//						 sslcontext,
//					        NoopHostnameVerifier.INSTANCE);
//				digestHttpClient = HttpClients.custom()
////						.setDefaultCredentialsProvider(credsProvider)
//						.setSSLSocketFactory(sslsf)
//						.build();
//			} catch (KeyManagementException e) {
//				e.printStackTrace();
//			} catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
//			} catch (KeyStoreException e) {
//				e.printStackTrace();
//			}
		}
		return digestHttpClient;
	}

}
